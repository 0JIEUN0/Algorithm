[문제 링크](https://leetcode.com/problems/longest-consecutive-sequence/)

## 문제
> LeetCode 128. Longest Consecutive Sequence

정렬해서 풀었지만, hashset 으로 접근하는 방법도 있다.
- 중복되는 숫자가 있는 경우, 입력 배열의 크기가 0인 경우를 고려하지 않았다가 수정. 

## java
```java
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int answer = 0;
        int now = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i]-nums[i-1] == 1) now++; // consecutive
            else if(nums[i]-nums[i-1] == 0) continue;
            else {
                answer = Math.max(answer, now);
                now = 1;
            }
        }
        answer = Math.max(answer, now);
        return answer;
    }
}
```
