/*
    Programmers 1845 [Hash]
    : 폰켓몬

    간단하지만 java 언어에 익숙해지기 위해 풀이.

    * HashSet 을 사용하는 방법도!
    HashSet<Integer> hs = new HashSet<>();
 */



import java.util.LinkedHashMap;

class Solution {
    public int solution(int[] nums) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int count = 0;
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key: map.keySet()) {
            count++;
        }
        if (count < nums.length / 2)
            return count;
        else
            return nums.length / 2;
    }
}
