class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict={}
        for i, v in enumerate(nums):
            dict[v]=i
        for i, v in enumerate(nums):
            complement = target-v
            if complement in dict.keys() and dict.get(complement) != i:
                print (i)
                print (dict.get(complement))
                print ([i,dict.get(complement)])
                return [i,dict.get(complement)]
            else:
                return 
            
        
x=Solution()
x.twoSum([3,2,4], 6)
