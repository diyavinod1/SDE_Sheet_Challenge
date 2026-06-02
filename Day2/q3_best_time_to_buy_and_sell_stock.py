class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        mi=float('inf')
        ma=0
        for p in prices:
            mi=min(mi,p)
            ma=max(ma,p-mi)
        return ma
