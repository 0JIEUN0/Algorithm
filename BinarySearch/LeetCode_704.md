[문제 링크](https://leetcode.com/problems/binary-search/)

## 문제

> LeetCode 704 [BinarySearch]: Binary Search

Binary Search 정석.

## Java
```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
```
