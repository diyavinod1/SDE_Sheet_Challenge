class Solution:
    def myPow(self, x: float, n: int) -> float:
        return pow(x,n)


#Alternatively

class Solution:
    def myPow(self, x: float, n: int) -> float:
        visited = {}
        def dfs(x,n):
            if n ==0:
                return 1
            if n == 1:
                return x
            if n == 2:
                return x*x
            if n in visited:
                return visited[n]
            if n>=0:
                half = dfs(x,n//2)
                if n%2 == 0:
                    res = half*half
                    visited[n] = res
                    return res
                else:
                    res = half*half*x
                    visited[n] = res
                    return res
            if n<0:
                x = 1 / x
                n = -n
            return dfs(x,n)
        return dfs(x,n)
        
