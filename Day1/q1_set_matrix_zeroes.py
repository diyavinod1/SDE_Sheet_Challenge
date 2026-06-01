class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        row=len(matrix)
        col=len(matrix[0])
        col0=1
        row0=1
        for r in range(row):
            for c in range(col):
                if matrix[r][c]==0:
                    if r==0:
                        col0=0
                    if c==0:
                        row0=0
                    else:
                        matrix[0][c]=0
                        matrix[r][0]=0
        for i in range(1,col):
            if matrix[0][i]==0:
                for j in range(row):
                    matrix[j][i]=0
        for i in range(row):
            if matrix[i][0]==0:
                for j in range(col):
                    matrix[i][j]=0
        if col0==0:
            for i in range(col):
                matrix[0][i]=0
        if row0==0:
            for j in range(row):
                matrix[j][0]=0
