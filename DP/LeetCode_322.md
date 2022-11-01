[문제 링크](https://leetcode.com/problems/coin-change/)

## 문제
> LeetCode 322: Coin Change

DP 로 풀이
- 처음에 set 으로 풀었다가 Time Limit 에 걸려서 (풀이 1)
- Array 로 풀 수 있음을 깨닫고 풀이 (풀이 2)
- DISCUSS 에 [BFS 로 푼 풀이](https://leetcode.com/problems/coin-change/discuss/198007/Java-BFS-Solution)
  도 발견. (amount 에서 coin 을 빼가며 탐색)

## Java (풀이 1)
- 183 / 189 test cases passed.
  - `[2,4,6,8,10,12,14,16,18,20,22,24], 9999`에서 `Time Limit Exceeded` 로 실패.
```java
import java.util.HashSet;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        HashSet<Integer>[] set = new HashSet[2];
        set[0] = Arrays.stream(coins).boxed().collect(Collectors.toCollection(HashSet<Integer>::new));
        set[1] = new HashSet<>();

        int before = 0;
        int now = 0;
        int answer = 1;
        int min = 0;
        while (true) {
            if (set[before].contains(amount)) return answer;
            now = now == 1 ? 0:1;
            set[now].clear();
            min = Integer.MAX_VALUE;
            for (Integer item: set[before]) {
                for (int coin: coins) {
                    int new_value = item + coin;
                    if (new_value <= amount) {
                        set[now].add(new_value);
                        if (new_value < min) min = new_value;
                    }
                }
            }
            answer++;
            if (set[now].size() == 0) break;
            if (min > amount) break;
            before = now;
        }
        return -1;
    }
}
```


## Java (풀이 2)
각 amount 만큼을 만들기 위해 필요한 최소 동전의 개수를 구한다. (: `dp[]`)

`dp[i]` 는 i 만큼을 만들기 위해 필요한 최소 동전 개수이고, 
`dp[i-coin]` 중 최소값에서 하나의 동전을 더한 값이 `dp[i]` 값이 된다.
(동전을 하나 덜 썼을 때의 최소 동전 개수에 동전을 하나 더 쓰면 최소 동전 개수가 됨)


- Runtime: 32 ms, faster than 58.93% of Java online submissions
- Memory Usage: 44.3 MB, less than 81.70% of Java online submissions


```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int dp[] = new int[amount+1];
        for (int i=1; i<=amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin: coins) {
                if (i-coin >=0 && dp[i-coin] != -1)
                    min = Math.min(dp[i-coin], min);
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1; // 이전 min + coin 한 개
        }
        return dp[amount];
    }
}
```

