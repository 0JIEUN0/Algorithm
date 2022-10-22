'''
    Programmers 12909 [스택/큐]
    : 올바른 괄호

    효율성 테스트도 존재했으므로
    반드시 올바르지 않는 괄호를 초기에 제거,
    중간에 ( 가 더이상 없는데 ) 가 있는 경우도 고려해줘야 했던 문제
'''

def solution(s):
    if s[0] == ')': return False
    if s[-1] == '(': return False
    if len(s) % 2 != 0: return False
    a = []
    for s0 in s:
        if s0 == '(':
            a.append(s0)
        elif len(a) == 0:
            return False
        elif a[-1] == '(':
            a.pop()
    if len(a) == 0:
        return True
    return False
