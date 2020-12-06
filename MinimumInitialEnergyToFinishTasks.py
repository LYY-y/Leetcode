# 1665.完成所有任务的最少初始能量
# 给你一个任务数组tasks ，其中tasks[i] = [actuali, minimumi] ：actuali是完成第i个任务需要耗费的实际能量。
# minimumi是开始第i个任务前需要达到的最低能量。比方说，如果任务为[10, 12]且你当前的能量为11 ，那么你不能开始这个任务。
# 如果你当前的能量为13 ，你可以完成这个任务，且完成它后剩余能量为3 。你可以按照任意顺序完成任务。
# 请你返回完成所有任务的最少初始能量。

class Solution:
    # 57.50 68.62
    def minimumEffort(self, tasks) -> int:
        tasks.sort(key=lambda x:x[0]-x[1])
        minEffort = curEffort = 0
        for a,m in tasks:
            minEffort = max(minEffort,curEffort+m)
            curEffort += a
        return minEffort

    # 优秀解答
    def minimumEffort(self, tasks) -> int:
        sumt = 0
        least_diff = 9999
        least_actu = 9999
        greatest_req = 0
        for i in tasks:
            sumt += i[0]
            if i[1] - i[0] < least_diff:
                least_diff = i[1] - i[0]
            if i[0] < least_actu:
                least_actu = i[0]
            if greatest_req < i[1]:
                greatest_req = i[1]
        # ret1 = actual之和 + (minimum - actual)的最小值
        ret1 = sumt + least_diff

        return ret1 if ret1 > greatest_req else greatest_req

s=Solution()
# print(s.minimumEffort([[1,2],[2,4],[4,8]]))
print(32,s.minimumEffort([[1,3],[2,4],[10,11],[10,12],[8,9]]))
print(27,s.minimumEffort([[1,7],[2,8],[3,9],[4,10],[5,11],[6,12]]))