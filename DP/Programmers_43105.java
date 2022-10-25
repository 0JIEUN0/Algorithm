/*
    Programmers 43105 [DP]
    : 계단 오르기

    전형적인 DP
    원래 triangle 배열을 이용해도 됨!
    - 이렇게 풀이한 것도 추가.
 */



/* 새 배열을 만들어서 해결한 풀이 */
import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int[][] answer = new int[2][triangle[triangle.length-1].length];
        answer[0][0] = triangle[0][0];
        int before = 0;
        int now = 1;
        for (int i=1; i<triangle.length; i++) {
            before = now == 1 ? 0 : 1;
            for (int j=0; j<triangle[i].length; j++) {
                if (j == 0) answer[now][j] = answer[before][j] + triangle[i][j];
                else answer[now][j] = Math.max(answer[before][j-1] + triangle[i][j],
                        answer[before][j] + triangle[i][j]);
            }
            now = before;
        }
        return Arrays.stream(answer[now == 1 ? 0 : 1]).max().getAsInt();
    }
}


/* 기존 triangle 배열을 써서 개선한 풀이 */
import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int i = 1;
        for (; i<triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j=1; j<triangle[i].length-1; j++) {
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }
        return Arrays.stream(triangle[i-1]).max().getAsInt();
    }
}
