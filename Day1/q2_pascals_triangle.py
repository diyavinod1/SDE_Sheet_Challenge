class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        t=[]
        for i in range(numRows):
            r=[1]*(i+1)
            for j in range(1,i):
                r[j]=t[i-1][j-1]+t[i-1][j]
            t.append(r)
        return t
