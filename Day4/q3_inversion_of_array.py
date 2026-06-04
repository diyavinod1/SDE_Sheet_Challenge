def merge(arr,low,mid,high):
    temp=[]
    left=low
    right=mid+1
    inv_count=0
    while left<=mid and right<=high:
        if arr[left]<=arr[right]:
            temp.append(arr[left])
            left+=1
        else:
            temp.append(arr[right])
            inv_count+=(mid-left+1)
            right+=1
    while left<=mid:
        temp.append(arr[left])
        left+=1
    while right<=high:
        temp.append(arr[right])
        right+=1
    for i in range(low,high+1):
        arr[i]=temp[i-low]
    return inv_count

def merge_sort(arr,low,high):
    if low>=high:
        return 0
    mid=(low+high)//2
    inv_count=merge_sort(arr,low,mid)
    inv_count+=merge_sort(arr,mid+1,high)
    inv_count+=merge(arr,low,mid,high)
    return inv_count

arr=list(map(int, input().split()))
n=len(arr)
result=merge_sort(arr,0,n-1)
print(result)
