'''
    BAEKJOON 1700 [Greedy]
    : 플러그를 빼는 횟수를 최소화하는 방법을 고안
'''

import sys

N = int(sys.stdin.readline().split(' ')[0])
electronics = [int(x) for x in sys.stdin.readline().split(' ')]
replaceN = 0
multitap = []

for i, e in enumerate(electronics):
    if len(multitap) < N:   # multitap is empty
        if e not in multitap:
            multitap.append(e)
    elif e not in multitap: # remove 1 electronic
        replaceN += 1
        if N == 1:
            multitap = [e]
            continue
        t_multitap = multitap.copy()
        for f in electronics[i:]:
            if f in t_multitap:
                t_multitap.remove(f)
                if len(t_multitap) == 1:
                    break
        # len(t_multitap) can be > 1: 2 or more electronics don't appear in the future
        multitap.remove(t_multitap[0]) # pick the first one
        multitap.append(e)

print(replaceN)
