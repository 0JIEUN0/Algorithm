[문제 링크](https://leetcode.com/problems/container-with-most-water/)

## 문제
> LeetCode 11. Container With Most Water

처음엔 Brute-Force 로 풀려고 했으나, `Time Limit Exceeded` 발생. (`풀이 1`)

결국 막대가 길수록, 거리가 멀수록 유리하므로
- 양쪽에서(거리 우선) 좁혀오는(긴 막대 우선), Two Pointer Approach 로 해결. (`풀이 2`)


## java (풀이 1) - Time Limit Exceeded
```java
class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        for (int i=0; i<height.length; i++) {
            int curr = height[i];
            for (int j=i+1; j<height.length; j++) {
                answer = Math.max(Math.min(curr, height[j]) * (j-i), answer);
            }
        }
        return answer;
    }
}
```

## java (풀이 2)
- Runtime 86.75%, Memory 87.91%
```java
class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int leftIdx = 0;
        int left = height[0];
        int rightIdx = height.length-1;
        int right = height[rightIdx];

        while (leftIdx < rightIdx) {
            int width = rightIdx - leftIdx;
            answer = Math.max(answer, Math.min(left, right) * width);
            if (left < right) {
                leftIdx++;
                left = height[leftIdx];
            } else {
                rightIdx--;
                right = height[rightIdx];
            }
        }
        return answer;
    }
}
```
