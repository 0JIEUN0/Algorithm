/*
    Programmers 42842 [Brute-Force]
    : 소수찾기

    dfs 로 만들 수 있는 모든 수를 만들어보고,
    소수면 set 에 넣어서 중복되지 않게 소수 집합을 만들어서 그 크기를 반환.

    여러 자릿수를 만들 수 있다는 것에 주의.

    (정통적인 조합 코드보다는 dfs 적으로 접근하는 게 편해서 이렇게 함)
 */


import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int solution(String numbers) {
        int[] numbers_int = Arrays.stream(numbers.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] eachN = numbers.split("");
        HashSet<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        dfs("", eachN, visited, set);
        return set.size();
    }
    public static void dfs(String before, String[] eachN, boolean[] visited, HashSet<Integer> set) {
        for (int i=0; i<visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int now = Integer.parseInt(before + eachN[i]);
                if (isPrime(now)) set.add(now);
                dfs(Integer.toString(now), eachN, visited, set);
                visited[i] = false;
            }
        }
    }
    public static boolean isPrime(int n) {
        if (n==0 || n==1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i=3; i<=(int)Math.sqrt(n); i+=2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
