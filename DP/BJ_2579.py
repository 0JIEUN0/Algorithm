'''
    BAEKJOON 2579 [DP]
    : 계단 오르기

    선택지
    0. 앞앞 o 앞 o -> x
    1. 앞앞 o 앞 x -> o
    2. 앞앞 x 앞 o -> o
    3. 앞앞 x 앞 o -> x

    첫 번째 계단은 앞앞이 0인 걸로 간주(dummy)
    마지막 계단은 1,2 중에 결정되어야 함.
'''

import sys

N = int(sys.stdin.readline())
stairs = [[0]] # dummy data
for _ in range(N):
    stairs.append(int(sys.stdin.readline()))

d = {0: [0, 0, 0, 0]}
for i in range(1, N+1):
    d[i] = {}
    d[i][0] = d[i-1][2]
    d[i][1] = max(d[i-1][0], d[i-1][3]) + stairs[i]
    d[i][2] = d[i-1][1] + stairs[i]
    d[i][3] = d[i-1][1]

print(max(d[N][1], d[N][2]))


''' 다른 풀이 '''
if N == 1: print(stairs[1])
elif N == 2: print(stairs[1] + stairs[2])
elif N == 3: print(max(stairs[1] + stairs[3], stairs[2] + stairs[3]))
else:
    d = {}
    d[1] = stairs[1]
    d[2] = stairs[1] + stairs[2]
    d[3] = max(stairs[1] + stairs[3], stairs[2] + stairs[3])
    for i in range(4, N+1):
        d[i] = max(d[i-2] + stairs[i], d[i-3] + stairs[i-1] + stairs[i])

    print(d[N])
