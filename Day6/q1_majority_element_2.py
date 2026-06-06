class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        freq=Counter(nums)
        ans=[]
        for num,cnt in freq.items():
            if cnt > len(nums)//3:
                ans.append(num)
        return ans
