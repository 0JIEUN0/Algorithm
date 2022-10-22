/*
        Programmers 42746 [Sort]
        : 가장 큰 수

        *** solve 못 함 *** (TC 1~6 에서 런타임 에러)

        이렇게 풀려니 경우의 수가 너무 많은..
*/


import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        // 자릿수 배열 생성
        int[][] eachN = new int[numbers.length][4];
        for (int i=0; i<eachN.length; i++) {
            int n = numbers[i];
            int j = 0;
            int k = 1000;
            if (n == 0) k = 1;
            boolean flag = false;
            while (n > 0) {
                if (n / k != 0) {
                    eachN[i][j++] = n / k;
                    n = n % k;
                    flag = true;
                } else if (flag && n / k == 0 && n % k != 0) {
                    eachN[i][j++] = n / k;
                    n = n % k;
                }
                k /= 10;
            }
            for (; k >= 1; k /= 10) eachN[i][j++] = 0;
            for (; j < 4; j++) eachN[i][j] = -1; // 낮은 수가 우선
        }

        // 정렬
        for (int i=0; i<eachN.length-1; i++) {
            int idx = i; // find 'max' number // 첫째 자릿수가 큰 수인 게 우선
            for (int j=i+1; j<eachN.length; j++) {
                for (int k=0; k<=4; k++) { // 0~1000 이니 최대 비교 횟수: 4
                    if (eachN[idx][k] == -1) {
                        if (eachN[idx][k-1] < eachN[j][k]) idx = j;
                        break;
                    } else if (eachN[j][k] == -1) {
                        if (eachN[idx][k] <= eachN[j][k-1]) idx = j;
                        break;
                    } else if (eachN[idx][k] < eachN[j][k]) {
                        idx = j;
                        break;
                    } else if (eachN[idx][k] > eachN[j][k]) break;
                }
            }
            if (idx != i) {
                int[] temp = eachN[i];
                eachN[i] = eachN[idx];
                eachN[idx] = temp;
            }
        }

        // mask as String
        if (eachN[0][0] == 0) return "0";
        StringBuilder answer = new StringBuilder();
        for (int[] ints : eachN) {
            for (int j = 0; j < 4; j++) {
                if (ints[j] != -1) answer.append(ints[j]);
            }
        }
        return answer.toString();
    }
}
