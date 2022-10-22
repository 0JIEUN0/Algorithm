'''
    Programmers 1844 [DFS/BFS] ★
    : 게임 맵 최단거리

    (아주 힘들게 풀었던 문제...)

    처음엔 DFS 로 접근했다가,
    모든 경로를 구하는 것이 아니라 최단 경로를 구하는 것이 목표이므로
    BFS 로 변경해서 풀이
    (사실 재귀 depth 제한에 걸려서 포기)


    접근 방법
    1) dummy maps 를 만들어서 index 가 넘어가지 않도록 (편의를 위한)
    2) collections.deque 를 이용해서 BFS 구현 - 그냥 list 에서 pop(0) 하면 O(n) 이므로
    3) dx, dy 배열을 활용해서 코드 간결화
    4) visit 리스트는 좌표값만 저장, queue 에는 좌표값에 현재까지의 거리값 저장

    -- 여기까지 했을 때 답은 나와도 효율성 테스트 통과 x
    5) visit 의 list 탐색에서 시간이 오래 걸린다고 생각, visit 을 dictionary 로 접근하니 통과!
        - (42576 에서의 풀이를 착안)
'''

from collections import deque

def solution(maps):
    n = len(maps) + 2
    m = len(maps[0]) + 2
    if maps[n-4][m-3] == 0 and maps[n-3][m-4] == 0: return -1
    dummy_maps = []
    for i in range(n):
        if i == 0 or i == n-1:
            dummy_maps.append([0]*m)
        else:
            dummy_maps.append([0] + maps[i-1] + [0])

    q = deque([[1, 1, 1]]) # (x, y, num)
    visit = {(1, 1): 1}
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    while q:
        x, y, num = q.popleft()
        for i in range(4):
            x0 = x + dx[i]
            y0 = y + dy[i]
            if x0 == n-2 and y0 == m-2: # end!
                return num+1
            if dummy_maps[x0][y0] == 1 and visit.get((x0, y0)) == None:
                visit[(x0, y0)] = 1
                q.append([x0, y0, num+1])

    return -1
