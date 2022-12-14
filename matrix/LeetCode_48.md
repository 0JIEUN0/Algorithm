[문제 링크](https://leetcode.com/problems/rotate-image/)

## 문제
> LeetCode 48: Rotate Image

규칙을 찾아 DFS 로 풀이.

* [LeetCode Official Solution](https://leetcode.com/problems/rotate-image/solutions/1037232/rotate-image/)
    
* matrix 의 성질을 백분 활용하는 방법
  - clockwise rotate - first reverse up to down, then swap the symmetry
    - ```
      1 2 3     7 8 9     7 4 1
      4 5 6  => 4 5 6  => 8 5 2
      7 8 9     1 2 3     9 6 3
      ```
  - anticlockwise rotate: first reverse left to right, then swap the symmetry
    


## Java
DFS 로 탐색해서 풀이.
- 4x4 matrix 기준으로, 다음의 규칙으로 현재 값을 어디에 옮길지 알 수 있다.
  ```
  (3,0) 0, 4-3 (0,1) 
  (3,1) 1, 4-3 (1,1)
  (2,1) 1, 4-2 (1,2)
  (4,0) 0, 4-4 (0,0)
  (1,2) 2, 4-1 (2,3)
  ```
- Runtime 100% (0 ms), Memory 82.86%
```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        boolean[][] changed = new boolean[n][n];
        int origval = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!changed[i][j]) {
                    dfs(j, n-1-i, matrix[i][j], changed, matrix, n);
                }
            }
        }
    }
    public static void dfs(int i, int j, int val, boolean[][] changed, int[][] matrix, int n) {
        changed[i][j] = true;
        if (!changed[j][n-1-i]) dfs(j, n-1-i, matrix[i][j], changed, matrix, n);
        matrix[i][j] = val;
    }
}
```