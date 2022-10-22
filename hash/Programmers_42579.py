'''
    Programmers 42576 [해시]
    : 완주하지 못한 선수

    처음엔 list 기반으로 풀었으나 효율성 테스트 통과 x
    해시 문제여서 dictionary 로 접근하니 풀림.
    - list 로 풀 경우 탐색 과정이 오래 걸리기 때문
'''

def solution(participant, completion):
    dic = {p: 0 for p in participant}
    for p in participant:
        dic[p] += 1
    for c in completion:
        dic[c] -= 1
    for key, value in dic.items():
        if value != 0:
            return key
