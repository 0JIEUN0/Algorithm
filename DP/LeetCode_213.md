## 문제
> [213. House Robber II](https://leetcode.com/problems/house-robber-ii/)

- 198번 문제 (198. House Robber)의 solution 을 이용,
- 첫 번째 집을 털지 않는 경우와 마지막 집을 털지 않는 경우로 나누어 가장 많은 돈을 털 수 있는 경우를 구함.

## Python
- Runtime Beats 76.29%, Memory Beats 71.58%
- `maxMoney()` 가 198번의 solution 과 동일.
```python
class Solution(object):
  def rob(self, nums):
    """
    :type nums: List[int]
    :rtype: int
    """

    def maxMoney(nums):
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

    n = len(nums)
    if n == 1: return nums[0]
    elif n == 2: return max(nums[0], nums[1])

    not_take_first_house = maxMoney(nums[1:])
    not_take_nth_house = maxMoney(nums[:-1])

    return max(not_take_first_house, not_take_nth_house)
```
