'''
    Programmers 42840 [완전탐색]
    : 모의고사

    1, 2, 3번 학생의 순서대로 답을 도출하는 과정에서의
    효율을 따지다가 마지막에 답을 놓쳤음.
    일단은 max 값과 하나씩 비교해가며 답을 찾았는데, 더 효율적인 방법이 있을지?!
'''

def solution(answers):
    a1 = [1, 2, 3, 4, 5]
    a2 = [2, 1, 2, 3, 2, 4, 2, 5]
    a3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    c = [0, 0, 0]
    for i, a in enumerate(answers):
        if a == a1[i % 5]:
            c[0] += 1
        if a == a2[i % 8]:
            c[1] += 1
        if a == a3[i % 10]:
            c[2] += 1

    m = max(c)
    result = []
    for i, c0 in enumerate(c):
        if c0 == m:
            result.append(i+1)
    return result
