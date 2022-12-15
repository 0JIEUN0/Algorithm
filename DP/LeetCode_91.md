[문제 링크](https://leetcode.com/problems/decode-ways/)

## 문제
> LeetCode 91. Decode Ways

- 크기가 2인 배열(`dp`)을 만들어두고,
- `dp[0]`: 현재 문자가 단독으로 해석될 수 있으면 `(이전) dp[0]+dp[1]`, 아니면 0
- `dp[1]`: 현재 문자가 앞 문자와 함께 해석될 수 있으면 `(이전) dp[0]`, 아니면 0
- 로 규칙을 만들어서 풀이.


## java (풀이 1)
- Runtime 9.19%, Memory 70.2%: 개선 필요
```java
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0)=='0') return 0; // cant decode leading zero

        int[] dp = {1, 0}; // cause 1<=s.length<=100 and no leading zero(s)
        StringBuilder sbuf = new StringBuilder();
        sbuf.append(s.charAt(0));
        for (int i=1; i<s.length(); i++) {
            int prev = dp[0];
            if (s.charAt(i) != '0') dp[0] = dp[0] + dp[1]; // can be decodeed independently
            else dp[0] = 0;

            sbuf.append(s.charAt(i));
            int sint = Integer.parseInt(sbuf.toString());
            if (sint > 9 && sint < 27) dp[1] = prev;
            else dp[1] = 0;
            sbuf.deleteCharAt(0);
        }
        return dp[0] + dp[1];
    }
}
```

## java (풀이 2)
- Runtime 97.83%, Memory 94.90%
- String 이 계속 바뀌어서 StringBuilder 를 사용했지만, `substring()` 으로 개선.
```java
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0)=='0') return 0; // cant decode leading zero

        int[] dp = {1, 0}; // cause 1<=s.length<=100 and no leading zero(s)
        for (int i=1; i<s.length(); i++) {
            int prev = dp[0];
            if (s.charAt(i) != '0') dp[0] = dp[0] + dp[1]; // can be decodeed independently
            else dp[0] = 0;

            int sint = Integer.parseInt(s.substring(i-1, i+1));
            if (sint > 9 && sint < 27) dp[1] = prev;
            else dp[1] = 0;
        }
        return dp[0] + dp[1];
    }
}
```
