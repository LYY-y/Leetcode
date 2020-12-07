class TwoSum(object):
    #用字典实现HashMap，成功
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict={}
        for k, v in enumerate(nums):
            dict[v]=k

        for k,v in enumerate(nums):
            print(k,v)
            complement = target-v
            print(complement)
            print(dict.keys())
            print(dict.get(complement))
            if complement in dict.keys() and dict.get(complement) != k:
                print (v)
                print (dict.get(complement))
                print ([k,dict.get(complement)])
                return [k,dict.get(complement)]
            
        
x=TwoSum()
x.twoSum([3,2,4], 6)

"""
def twoSum(nums, target):
    hashmap={}
    for ind,num in enumerate(nums):
        hashmap[num] = ind
    for i,num in enumerate(nums):
        j = hashmap.get(target - num)
        if j is not None and i!=j:
            return [i,j]



作者：lao-la-rou-yue-jiao-yue-xiang
链接：https://leetcode-cn.com/problems/two-sum/solution/xiao-bai-pythonji-chong-jie-fa-by-lao-la-rou-yue-j/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
"""
