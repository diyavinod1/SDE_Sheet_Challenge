#Brute-Force
nums=list(map(int,input().split()))
r,m=0,0
for i in range(1,len(nums)+1):
    if nums.count(i)==2:
        r=i
    if i not in nums:
        m=i
    if r!=0 and m!=0:
        break
print(r,m)

#Optimal Solution
arr=list(map(int,input().split()))
n=len(arr)
actual_sum=n*(n+1)//2
actual_sq_sum=n*(n+1)*(2*n+1)//6
arr_sum=sum(arr)
arr_sq_sum=sum(x*x for x in arr)
diff=arr_sum-actual_sum       
sq_diff=arr_sq_sum-actual_sq_sum 
sum_xy=sq_diff//diff           
repeating=(diff+sum_xy)//2
missing=sum_xy-repeating
print(repeating,missing)
