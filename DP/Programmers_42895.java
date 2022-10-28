/*
    Programmers 42895 [DP]
    : N으로 표현

    8자릿수의 모든 경우를 모든 사칙 연산으로 계산.
    - (ex. N=2 -> 2, 22, 222, 2222, 22222, 222222, 2222222, 22222222)
    중복 수를 방지하기 위해 Set 사용.
*/


/* 전체 경우 다 수행 후 답 찾기 */
import java.util.HashSet;

class Solution {
    final static int MAX = 9;
    public int solution(int N, int number) {
        HashSet<Integer>[] set = new HashSet[MAX]; // 최소값이 8보다 크면 -1을 리턴
        int n = 0;
        for (int i=1, j=1; i<set.length; i++, j*=10) {
            set[i] = new HashSet<>();
            n = n + N * j;
            set[i].add(n);
        }
        for (int i=1; i<MAX; i++) {
            for (int j=1; j<MAX-i; j++) {
                for (int a: set[i]) {
                    for (int b: set[j]) {
                        set[i+j].add(a + b);
                        set[i+j].add(a - b);
                        set[i+j].add(a * b);
                        if (b!=0) set[i+j].add(a / b);
                    }
                }
            }
        }
        for (int i=1; i<MAX; i++)
            if (set[i].contains(number)) return i;
        return -1;
    }
}


/* 개선) 작은 경우부터 수행하면서 답 찾기 */
import java.util.HashSet;

class Solution {
    final static int MAX = 9;
    public int solution(int N, int number) {
        HashSet<Integer>[] set = new HashSet[MAX]; // 최소값이 8보다 크면 -1을 리턴
        int n = 0;
        for (int i=1, j=1; i<set.length; i++, j*=10) {
            set[i] = new HashSet<>();
            n = n + N * j;
            set[i].add(n);
        }
        for (int i=1; i<MAX; i++) {
            for (int j=1; j<i; j++) {
                for (int a: set[j]) {
                    for (int b: set[i-j]) {
                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(a * b);
                        if (b!=0) set[i].add(a / b);
                    }
                }
            }
            if (set[i].contains(number)) return i;
        }
        return -1;
    }
}

