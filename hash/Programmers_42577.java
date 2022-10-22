/*
    Programmers 42577 [Hash]
    : 전화번호 목록

    Array 탐색으로 풀면 시간 초과/런타임 에러 뜸.
    한 전화번호가 다른 전화번호의 접두어인지 가 아니라,
    한 전화번호의 앞쪽 substring 이 전화번호 중에 있는지 확인하면 됨.

    * 혹은 이중 for문에서 두 전화번호를 서로 비교하는 방법도 있음
 */


import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String str: phone_book) map.put(str, 0); // value means nothing
        for(String str: phone_book) {
            for(int n=1; n<str.length(); n++) {
                if(map.containsKey(str.substring(0, n))) return false;
            }
        }
        return true;
    }
}
