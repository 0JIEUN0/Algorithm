'''
    Programmers 43165 [DFS/BFS]
    : 타겟 넘버

    트리 그려가며 풀이!
    모든 경우 최고 depth 까지 내려가야 하므로 DFS 로 풀이.
    한 숫자가 2개의 경우(+/-)가 있고, 순서가 바뀌지 않아서 재귀로.
'''

def dfs(s, numbers, target):
    num = 0
    my_n = numbers[0]
    if len(numbers) == 1:
        if s + my_n == target: num += 1
        if s - my_n == target: num += 1
        return num
    else:
        return dfs(s + my_n, numbers[1:], target) + dfs(s - my_n, numbers[1:], target)

def solution(numbers, target):
    return dfs(numbers[0], numbers[1:], target) + dfs(-numbers[0], numbers[1:], target)
