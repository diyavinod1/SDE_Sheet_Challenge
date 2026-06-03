class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        l=[intervals[0]]
        for i,j in intervals[1:]:
            if i<=l[-1][1]:
                l[-1][1]=max(l[-1][1],j)
            else:
                l.append([i,j])
        return l
