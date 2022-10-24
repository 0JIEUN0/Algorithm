/*
        Programmers 42584 [스택/큐]
        : 주식가격

        그냥 열심히 돌리면 됨
*/


class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            int now = prices[i];
            int j=i+1;
            while(j<n) {
                if (now > prices[j++]) break;
            }
            answer[i] = j-i-1;
        }
        answer[n-1] = 0;
        return answer;
    }
}
