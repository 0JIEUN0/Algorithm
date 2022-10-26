/*
        Programmers 42746 [Sort]
        : 가장 큰 수

        *** solve 못 함 *** (TC 1~6 에서 런타임 에러)

        이렇게 풀려니 경우의 수가 너무 많은..

        - 위의 풀이의 런타임 에러의 원인을 찾아서 고쳤으나 모든 경우를 비교하지 않아 실패.

        --> 결국 다른 방법을 찾음.
        풀이2) int 를 String 으로 변환해서, String 간의 크기 비교를 하면 끝.
        String 으로 변환해서 하는 작업의 오버헤드를 걱정했으나,
        정렬 문제에 맞게 두 수를 붙였을 때 더 큰 값을 취하면 되는 문제였다.


        * 이 외로 숫자들 중 가장 큰 수의 자릿수만큼 모든 수를 만들어서 정렬하는 풀이도 존재.
        - ex) [9, 10, 2] 라고 했을 때 [99, 10, 22] 로 만들어서, 그 값들로 정렬.
*/



/* 각 자릿수마다 비교해주려 시도 -> 실패 */
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
                for (int k=0; k<=3; k++) { // 0~1000 이니 최대 비교 횟수: 4 // runtime error 발생했던 부분 수정
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


/* 추가 풀이: String 붙여서 비교 */
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] str = Arrays.stream(numbers).boxed().map((n)->Integer.toString(n))
                .sorted((s1, s2)->(s2+s1).compareTo(s1+s2))
                .toArray(String[]::new);

        // make as String
        if (str[0].equals("0")) return "0";
        StringBuilder answer = new StringBuilder();
        for (String s: str) {
            answer.append(s);
        }
        return answer.toString();
    }
}

