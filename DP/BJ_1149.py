'''
    BAEKJOON 1149 [DP]
    : 모든 집을 칠하는 비용의 최솟값
'''

import sys

N = int(sys.stdin.readline())
costs = [[0, 0, 0]] # dummy data
for _ in range(N):
    costs.append([int(x) for x in sys.stdin.readline().split(' ')])

d = {0: [0, 0, 0]} # dummy data
for i in range(1, N+1):
    d[i] = {}
    d[i][0] = costs[i][0] + min(d[i-1][1], d[i-1][2])
    d[i][1] = costs[i][1] + min(d[i-1][0], d[i-1][2])
    d[i][2] = costs[i][2] + min(d[i-1][0], d[i-1][1])

print(min(d[N].values()))
