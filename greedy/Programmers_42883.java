/*
    Programmers 42883 [Greedy]
    : 큰 수 만들기

    처음엔 양옆보다 작은 수면 빼려고 했으나
    - 그냥 앞에서부터 k번, 다음 수보다 작으면 빼고,
      (주의: 뺀 경우 index 조정 필요)
    - 마지막 수는 이전 수보다 작으면 빼기 (-ㄱ)
    - 그랬는데도 더 빼야 한다면 (문제에서 불가능한 경우에 대한 설명 x)
      다 같은 수만 남은 것이므로 그만큼 빼주기
      (혹은 ㄱ을 생략하고 여기서 마지막 수부터 k-count 만큼 빼줘도 ok)
 */


class Solution {
    public String solution(String number, int k) {
        int i=0, count=0;
        StringBuilder sbuf = new StringBuilder(number);
        while (true) {
            if (count == k) break;
            if (i == sbuf.length()-1) {
                if (sbuf.charAt(i-1) > sbuf.charAt(i)) {
                    sbuf.deleteCharAt(i);
                    count++;
                }
                break;
            } else if (sbuf.charAt(i) < sbuf.charAt(i+1)) {
                sbuf.deleteCharAt(i);
                count++;
                if (i != 0) i--;
            } else i++;
        }
        if (k != count) sbuf.delete(0, k-count); // 남은 수가 모두 같은 수인 경우
        return sbuf.toString();
    }
}
