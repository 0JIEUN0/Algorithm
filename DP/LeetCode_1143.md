[문제 링크](https://leetcode.com/problems/longest-common-subsequence/)

## 문제
> LeetCode 1143: Longest Common Subsequence

DP 로 풀이.

각 자리가 가질 수 있는 최대값을 통해 풀었지만,
3중 for 문 없이 이전('왼쪽') 값에 최대값을 저장해두는 방법도 있다.
(`max(dp[i - 1][j], dp[i][j - 1])`) 
(이렇게 하면 더 긴 글자를 기준으로('위로') 두지 않아도 된다..!)


## Java
```java
import java.util.Arrays;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() > text2.length()) {
            String tmp = text1;
            text1 = text2;
            text2 = tmp;
        }
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) dp[i][j] = 1;
            }
        }
        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                int max = Math.max(dp[i][j], dp[i-1][j]);
                for (int k=0; k<j; k++) max = Math.max(max, dp[i-1][k] + dp[i][j]);
                dp[i][j] = max;
            }
        }
        return Arrays.stream(dp[n-1]).max().getAsInt();
    }
}
```
