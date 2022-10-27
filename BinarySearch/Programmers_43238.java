/*
    Programmers 43238 [BinarySearch]
    : 입국심사

    처음엔 복잡하게 생각했다가 문제 분류가 이분 탐색이어서 그렇게 접근.
    '시간이 더 짧게 걸리는 줄로 간다'라는 조건 때문에 헤맸는데,
    결국 주어진 '시간' 내에 심사를 받을 수 있는 사람 수를 기준으로 탐색하면 된다.
    - n=6, times=[7,10] 일 때 28분에서 28/7(=4)+28/10(=2) -> 6명 달성.
*/


import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 1; // 1분 이상
        long right = (long)n * times[times.length-1];
        long mid = 0;
        long sum = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            sum = 0;
            for (int t: times) sum += mid / t;
            if (sum < n) left = mid + 1; // 시간 더 필요
            else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}

