"""
加一：
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。
示例 1:
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def plusOne(self, digits) :
        if digits[0] == 0:
            return [1]
        length = len(digits)
        num = 0
        for i in digits:
            length = length - 1
            num=num+i*(10**length)
        num=num + 1
        length = len(str(num))
        result = [0]*length
        for j in range(length-1,-1,-1):
            result[j] = num % 10
            num = num // 10
        return result

    def plusOne2(self, digits) :
        if digits[0] == 0:
            return [1]
        length = len(digits)
        digits[length-1] = digits[length-1] + 1
        for i in range(length-1, -1, -1):
            if digits[i] > 9:
                digits[i] = 0
                if i != 0:
                    digits[i-1]=digits[i-1]+1
                else:
                    digits.insert(0,1)
        return digits

    def plusOne3(self, digits) :
        if digits[0] == 0:
            return [1]
        length = len(digits)
        result = [0]*(length+1)
        result[1:] = digits
        result[length] = result[length] + 1
        for i in range(length, 0, -1):
            if result[i] > 9:
                result[i] = 0
                result[i-1]=result[i-1]+1
        if result[0] == 0:
            return result[1:]
        return result

    def plusOne4(self, digits):
        n = len(digits)-1
        while True:
            if digits[n]==9 and n==0:
                digits[n]=0
                digits.insert(0,1)
                break
            elif digits[n]==9:
                digits[n]=0
                n=n-1
                continue
            else:
                digits[n]=digits[n]+1
                break
        return digits


s=Solution()
print(s.plusOne4([9]))