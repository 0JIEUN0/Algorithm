## 문제
> [198. House Robber](https://leetcode.com/problems/house-robber/)

- o (턴다) / x (안 턴다)
- '현재 집'은 3가지 경우가 가능: x-x-o / o-x-o / o-x-x / x-o-x (순서대로 전전집-전집-현재집)
  - 100 10 10 100 과 같은 경우가 있다면, 두 집을 건너뛰더라도 다음 집을 터는 게 이득이기 때문
    
- 따라서 크기가 2인 dp 배열을 선언 (이전 집/현재 집), 한 집은 이전 집에 따라 3가지 경우로 기록
- 이 외로도, recursive 하게 푸는 방법도 있는 듯.

## Python
- Runtime Beats 96.80%, Memory Beats 89.62%
```python
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ''' cases
        x o -> x o x
        o x -> o x o / o x x
        x x -> x x o'''

        dp = [[0, 0, 0], [0, 0, 0]]
        curr = 0
        prev = 1
        for num in nums:
            prev, curr = curr, prev
            dp[curr][0] = max(dp[prev][1] + num, dp[prev][2] + num) # o x o / x x o
            dp[curr][1] = dp[prev][0] # x o x
            dp[curr][2] = dp[prev][1] # o x x

        return max(dp[curr][0], dp[curr][1], dp[curr][2])

```
