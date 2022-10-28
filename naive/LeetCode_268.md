[문제 링크](https://leetcode.com/problems/missing-number/)

## 문제

> LeetCode 268 :missing number

정렬해서 해결

그런데 O(n) 으로 해결하는 방법(전체 합 이용)이 있다.
...더 생각해서 풀 것!

## Java
```java
import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) return 0;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i+1]-nums[i] != 1) return i+1;
        }
        return nums.length;
    }
}
```
