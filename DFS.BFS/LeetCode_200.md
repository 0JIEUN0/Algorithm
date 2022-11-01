[문제 링크]

## 문제
> LeetCode 200: Number of Islands

DFS 로, `'1'`(land)인 곳들의 인접(=상하좌우) land 를 `'0'`(water) 으로 변경한다.
이 작업이 일어나는 수 = 답.

## Java
- Runtime: 3 ms, faster than 97.76% of Java online submissions
- Memory Usage: 51 MB, less than 88.15% of Java online submissions
```java
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int answer = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    deep(grid, m, n, i, j);
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    public static int[] dy = {0, 0, -1, 1};
    
    public static void deep(char[][] grid, int m, int n, int x, int y) {
        for(int i=0; i<4; i++) {
            int rx = x + dx[i];
            int ry = y + dy[i];
            if (rx >= 0 && ry >=0 && rx < m && ry < n) {
                if (grid[rx][ry] == '1'){
                    grid[rx][ry] = '0';
                    deep(grid, m, n, rx, ry);
                }
            }
        }
    }
}
```
