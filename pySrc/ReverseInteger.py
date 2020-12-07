class Solution:
     def reverse(self, x: int) -> int:
        ans=0
        temp=x
        while x!=0:            
            x=abs(x)
            if ((ans*10)/10)!=ans:
                return 0
            ans=ans*10+x%10
            x=x//10
        if ans>-(2**31) and ans<2**31-1:
            if temp>0:   
                return ans
            else:
                return 0-ans
        else:
            return 0
s=Solution()
print(s.reverse(1534236469))

"""
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
请根据这个假设，如果反转后整数溢出那么就返回 0。
"""
"""
利用字符串切片
class Solution:
    def reverse(self, x:int) -> int:
            s = str(x)
            new_str =''
            le = len(s)-1
            if len(s) == 1 :
                return int(s)
            while le>=0 :
                if s[le] == '0':
                    s = s[:le]
                    le -= 1
                else:
                    break
            if s[0] == '-':
                new_str += s[0]
                s = s[1:]
            new_le = len(s) - 1
            while new_le>=0 :
                new_str += s[new_le]
                new_le -= 1
                x = int(new_str)
            if x not in range(-2**31,2**31) :
                return 0
            else :
                return x

作者：jekyll-hyde
链接：https://leetcode-cn.com/problems/reverse-integer/solution/pythonli-yong-zi-fu-chuan-qie-pian-jie-jue-by-jeky/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
"""
