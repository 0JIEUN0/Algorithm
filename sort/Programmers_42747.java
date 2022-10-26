/*
        Programmers 42747 [Sort]
        : H-Index

        처음에 문제를 잘못 이해하고 삽질하다가
        (h번 이상 인용 논문이 h편 이상에 그 외 논문이 h편 이하인 줄)
        다음 날 문제 다시 보고 깨닫고 바로 해결...!

        * 생각해보니 큰 수부터 정렬하면 굳이 minIdx 를 관리할 필요 없이
        인덱스가 작아질수록 h 값 또한 커지니 일반화해서 풀어도 될 듯.
*/


import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int min = -1;
        int minIdx = -1;
        int answer = 0;
        int h = 0;
        for (int i=0; i<n; i++) {
            int now = citations[i];
            if (min == now) continue;
            min = now;
            minIdx = i;

            h = n-minIdx;
            if (now < h) h = now;
            answer = Math.max(answer, h);
        }
        return answer;
    }
}
