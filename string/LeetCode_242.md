[문제 링크](https://leetcode.com/problems/valid-anagram/)

## 문제
> LeetCode 242: Valid Anagram

효율성 개선을 위해 여러 방법으로 풀이 시도.


## Java (풀이 1)
단순하게, 문자 하나하나 비교하는 방법.
효율성이 별로 좋지 않았음. (Runtime 5.7%, Memory 84.16%)
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        StringBuilder sbuf = new StringBuilder(s);
        int idx = 0;
        for (int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            idx = sbuf.indexOf(String.valueOf(ch));
            if (idx >= 0) {
                sbuf.deleteCharAt(idx);
            } else return false;
        }
        if (sbuf.length() == 0) return true;
        else return false;
    }
}
```

## java (풀이 2)
각 문자열을 정렬해서 비교하는 방법.
Runtime 55.18%, Memory 96.47% 로 개선되었지만, Runtime 개선이 더 필요해 보임.
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        // sorted string #1
        String sortedS = s.chars().sorted().collect(
                StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append)
                .toString();
        
        // sorted string #2
        char[] chars = t.toCharArray();
        Arrays.sort(chars);
        String sortedT = new String(chars);
        
        return sortedS.equals(sortedT);
    }
}
```

## java (풀이 3)
각 알파벳에 대한 배열을 만들어두고, 각 알파벳의 등장 개수를 카운트하는 방식.
Runtime 94.77%, Memory 87.86% 으로 풀이 2 보다 Runtime 이 개선되었지만 Memory 를 더 쓴 풀이.
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] cnt = new int[26];
        for (int i=0; i<s.length(); i++) {
            cnt[s.charAt(i)-'a']++;
            cnt[t.charAt(i)-'a']--;
        }
        for (int c: cnt) {
            if (c != 0) return false;
        }
        return true;
    }
}
```
