"""
69.x的平方根
实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sqrtx
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    '''二分法：'''
    def mySqrt(self, x: int) -> int:
        left=0
        right=x//2
        if x==1:
            return 1
        while left<right:
            mid = (left + right) >> 1
            power = mid ** 2
            if power<=x and (mid+1)**2>x:
                return mid
            if power>=x:
                right=mid-1
            else:
                left=mid
        return left

    '''牛顿法'''
    def mySqrt2(self, x:int) -> int:
        if x<0:
            return -1
        if x==0:
            return 0
        temp=1
        while True:
            i=temp
            temp=(temp+x/temp)/2
            if abs(i-temp) <= 1e-6:
                return int(i)




s=Solution()
print(s.mySqrt2(15))

"""
    def mySqrt(self, x: int) -> int:
        if x == 0:
            return 0
        left = 1
        right = x // 2
        while left < right:
            # 注意：这里一定取右中位数，如果取左中位数，代码可能会进入死循环
            # mid = left + (right - left + 1) // 2
            mid = (left + right + 1) >> 1
            square = mid * mid

            if square > x:
                right = mid - 1
            else:
                left = mid
        # 因为一定存在，因此无需后处理
        return left
"""