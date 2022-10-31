[문제 링크](https://leetcode.com/problems/network-delay-time/)

## 문제

> LeetCode 743: Network Delay Time

다익스트라 문제.


## Java
- Runtime: 4 ms, faster than 99.70% of Java online submissions
- Memory Usage: 47.9 MB, less than 83.66% of Java online submissions
```java
import java.util.Arrays;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n+1][n+1];
        for (int[] t: times) graph[t[0]][t[1]] = t[2] + 1;
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // dummy
        dist[k] = 0; // start node

        int now = k;
        boolean[] visited = new boolean[n+1];
        visited[k] = true;
        int min = 0;
        int minIdx = 0;
        for (int i=1; i<n+1; i++) {
            min = Integer.MAX_VALUE;
            for (int j=1; j<n+1; j++) {
                if (now == j) continue;
                if (graph[now][j] != 0)
                    dist[j] = Math.min(dist[now]+graph[now][j]-1, dist[j]);
                if (dist[j] < min && !visited[j]) {
                    min = dist[j];
                    minIdx = j;
                }
            }
            now = minIdx;
            visited[now] = true;
        }
        int answer = Arrays.stream(dist).max().getAsInt();
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
```
