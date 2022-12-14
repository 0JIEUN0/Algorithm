[문제 링크](https://leetcode.com/problems/merge-intervals/)

## 문제
> LeetCode 56: Merge Intervals

단순 interval 문제.


## Java
```java
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (x1, x2)->x1[0]-x2[0]);
        for (int i=0; i<intervals.length-1; i++) {
            if (intervals[i][0] <= intervals[i+1][0] && intervals[i+1][0] <= intervals[i][1]) {
                intervals[i+1][0] = Math.min(intervals[i][0], intervals[i+1][0]);
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
            } else {
                list.add(intervals[i]);
            }
        }
        list.add(intervals[intervals.length-1]);
        return list.toArray(int[][]::new);
    }
}
```
