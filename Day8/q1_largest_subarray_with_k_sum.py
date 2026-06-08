n = int(input())
arr = list(map(int, input().split()))

prefix_sum = 0
max_len = 0
prefix_map = {}

for i in range(n):
    prefix_sum += arr[i]

    if prefix_sum == 0:
        max_len = i + 1

    elif prefix_sum in prefix_map:
        max_len = max(max_len, i - prefix_map[prefix_sum])

    else:
        prefix_map[prefix_sum] = i

print(max_len)
