'''
    Programmers 42586 [스택/큐]
    : 기능개발

    pairs 리스트를 앞에서부터 인덱스 기반 제거를 해서 (*)
    정확하지 않은 답이 도출되었음.
    list 관리 시 주의 필요!
'''


def solution(progresses, speeds):
    pairs = [p for p in zip(progresses, speeds)]
    answer = []
    c = 1 # day
    while len(pairs) != 0:
        today = []
        for i, (progresse, speed) in enumerate(pairs):
            if progresse + (speed * c) >= 100:
                today.append(i)
            else:
                break
        if len(today) != 0:
            today.reverse() # remove from tail
            answer.append(len(today))
            for i in today:
                del pairs[i] # (*)
        c += 1
