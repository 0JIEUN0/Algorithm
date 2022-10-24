/*
    Programmers 42860 [Greedy]
    : 조이스틱

    이게 왜 Greedy 인지는 모르겠지만...
    알파벳 자체를 바꾸는 수 + min(자리를 옮기는 수) 을 구하면 됨.
    - (문제에선 명확히 명시되어있진 않지만) 시작 위치는 첫 번째 문자
    - 자리를 옮기는 수는, A 가 아닌 위치의 자리를 기준으로
      앞으로/뒤로 가는 2가지 방법 중 짧은 것 반영.
 */


class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int notAIdxN = 0;
        int[] notAIdx = new int[name.length()];
        for (int i=0; i<name.length(); i++) {
            int now = name.charAt(i); // get ascii value
            if (now != 65) notAIdx[notAIdxN++] = i;
            answer += Math.min(now-65, 90-now+1);
        }
        if (notAIdxN != 0) {
            int min = notAIdx[notAIdxN-1];
            for (int i=0; i<notAIdxN-1; i++) {
                min = Math.min(min, (notAIdx[i]*2)+(n-notAIdx[i+1]));
                min = Math.min(min, (n-notAIdx[i+1])*2+notAIdx[i]);
            }
            min = Math.min(min, n-notAIdx[0]);
            answer += min;
        }
        return answer;
    }
}
