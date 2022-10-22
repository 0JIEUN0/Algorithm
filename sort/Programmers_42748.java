/*
        Programmers 42748 [Sort]
        : K번째수

        엄청 간단한 정렬 문제
        java 언어에 익숙해지기 위해 풀이.
*/


import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i = 0;
        for (int[] cmd: commands) {
            int[] arrayRange = Arrays.copyOfRange(array, cmd[0]-1, cmd[1]);
            Arrays.sort(arrayRange);
            answer[i++] = arrayRange[cmd[2]-1];

        }
        return answer;
    }
}
