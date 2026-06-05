class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        ans=None
        c=0
        for i in nums:
            if c==0:
                ans=i
                c+=1
            else:
                if ans==i:
                    c+=1
                else:
                    c-=1
        return ans
