/*
    Programmers 42842 [Brute-Force]
    : 카펫

    전체 탐색 + yellow 가 홀수인 경우를 조심하기
 */


class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=1; i<=yellow; i++){
            int h = i;
            if (yellow % h != 0) continue;
            int w = yellow / h;
            int depth = 2;
            while (true) {
                int brown_num = h * depth + w * depth + 4;
                if (brown_num == brown) {
                    answer[0] = w + depth;
                    answer[1] = h + depth;
                    if (answer[0] < answer[1]) continue;
                    return answer;
                } else if (brown_num > brown) break;
                depth += 2;
            }
        }
        return answer;
    }
}
