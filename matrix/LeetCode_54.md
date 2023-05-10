## 문제
> [54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)

- `Spiral` 을 정의 (이동 방향을 순서대로 정의) 한 후,
- `Spiral` 에 따라 이동하다가 limit (`x_min`/`x_max`/`y_min`/`y_max`)에 걸리면 다음 방향(`(spiral_idx + 1) % 4`)으로 이동
  - 이때, 방향을 바꾸면 limit 도 변경 (ex. `y_max`에 걸렸다면 해당 행은 더이상 방문할 필요가 없으므로 `x_min`을 1 줄여줌.
- -> 이 규칙에 따라 전체를 순회하면 답을 얻을 수 있다.

## Python
- Runtime Beats 40.41%, Memory Beats 90.64%
```python
class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        spiral = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        m, n = len(matrix), len(matrix[0])
        x, y = 0, 0
        x_min, x_max, y_min, y_max = 0, m-1, 0, n-1
        spiral_idx = 0
        ans = [matrix[x][y]]
        for i in range(m*n-1):
            next_x = x + spiral[spiral_idx][0]
            next_y = y + spiral[spiral_idx][1]
            if next_x < x_min: y_min += 1
            elif next_x > x_max: y_max -= 1
            elif next_y < y_min: x_max -= 1
            elif next_y > y_max: x_min += 1
            else:
                x, y = next_x, next_y
                ans.append(matrix[x][y])
                continue
            spiral_idx = (spiral_idx + 1) % 4
            next_x = x + spiral[spiral_idx][0]
            next_y = y + spiral[spiral_idx][1]
            x, y = next_x, next_y
            ans.append(matrix[x][y])
        return ans
```