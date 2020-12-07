"""
59.队列的最大值2
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
若队列为空，pop_front 和 max_value 需要返回 -1
示例 1：
输入:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
示例 2：
输入:
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
限制：
1 <= push_back,pop_front,max_value的总操作数 <= 10000
1 <= value <= 10^5
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class MaxQueue:
    # Your MaxQueue object will be instantiated and called as such:
    # obj = MaxQueue()
    # param_1 = obj.max_value()
    # obj.push_back(value)
    # param_3 = obj.pop_front()
    # def __init__(self):
    #     self.queue = []
    #
    # def max_value(self) -> int:
    #     if self.queue == []:
    #         return -1
    #     max = self.queue[0]
    #     for num in self.queue:
    #         if max < num:
    #             max = num
    #     return max
    #
    # def push_back(self, value: int) -> None:
    #     self.queue.append(value)
    #
    # def pop_front(self) -> int:
    #     if self.queue == []:
    #         return -1
    #     return self.queue.pop(0)

    #两个队列，一个原始队列、一个辅助队列（递减）
    def __init__(self):
        from collections import deque
        self.queue = deque()
        self.maxQueue = deque()

    def max_value(self) -> int:
        if not self.maxQueue:
            return -1
        else:
            return self.maxQueue[0]

    def push_back(self, value: int) -> None:
        self.queue.append(value)
        while self.maxQueue and self.maxQueue[-1] < value:
            self.maxQueue.pop()
        self.maxQueue.append(value)

    def pop_front(self) -> int:
        if not self.queue :
            return -1
        if self.queue[0] == self.maxQueue[0]:
            self.maxQueue.popleft()
        return self.queue.popleft()


object = MaxQueue()
object.push_back(46)
object.push_back(868)
object.push_back(525)
object.push_back(123)
object.push_back(646)
print(object.max_value())

