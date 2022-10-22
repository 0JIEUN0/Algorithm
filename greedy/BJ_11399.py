'''
    BAEKJOON 11399 [Greedy]
    : ATM 최소 인출 시간 구하기
'''

import sys

N = int(sys.stdin.readline())
P_list = [int(x) for x in sys.stdin.readline().split(' ')]
P_list.sort()

s = t = 0
for P in P_list:
    t += P
    s = s + t

print(s)
