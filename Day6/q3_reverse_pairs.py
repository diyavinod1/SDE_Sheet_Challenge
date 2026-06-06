class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        n=len(nums)
        sl=SortedList()
        inpair=0
        for num in nums:
            inpair+=sl.bisect_right(2*num)
            sl.add(num)
        tot=(n*(n-1))//2
        return tot-inpair
