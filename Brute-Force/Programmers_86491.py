'''
    Programmers 86491 [완전탐색]
    : 최소직사각형

    어렵게 생각했지만
    결국 x, y 중에 작은 것끼리, 큰 것끼리 비교하는 것으로 생각하고 풀이
    꼬아둔 문제를 풀어서 생각할 필요.

    푼 후 더 짧게 풀이하는 방법도 존재함을 발견
    - max(max(x) for x in sizes) * max(min(x) for x in sizes)
'''

def solution(sizes):
    max_a = sizes[0][0] # small one
    max_b = sizes[0][1] # big one
    if max_a > max_b:
        max_a, max_b = max_b, max_a

    for a, b in sizes:
        if a < b:
            if max_a < a:
                max_a = a
            if max_b < b:
                max_b = b
        else:
            if max_a < b:
                max_a = b
            if max_b < a:
                max_b = a

    return max_a * max_b
