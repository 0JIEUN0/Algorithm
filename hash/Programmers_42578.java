/*
    Programmers 42578 [Hash]
    : 위장

    * 수학적 해결법: 종류의 개수가 a, b, c 라면 답=(1+a)(1+b)(1+c)-1

    위를 몰랐어서, 직접 경우의 수를 따져가며 풀었음.
    a + ab + abc
      + ac
    b + bc
    c
    이렇게 되니까, '자신의 다음'과 곱하고 그걸 더해주는 과정을 재귀로 반복.
    (경우의 수 따질 때 머리 터질 뻔...)

    visited 를 써서 dfs 처럼 구현해야 하나 싶었으나
    자신의 다음만 순서대로 고려해주면 되어서 visited 삭제하고 구현.
 */



import java.util.HashMap;

/* visited 를 같이 사용한 케이스 */
class Solution {
    public int solution(String[][] clothes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<String, Integer> mapInt = new HashMap<>();
        int n = 0;
        for (String[] c: clothes) {
            if (mapInt.containsKey(c[1])) {
                int now = mapInt.get(c[1]);
                map.put(now, map.get(now)+1);
            } else {
                map.put(n, 1);
                mapInt.put(c[1], n);
                n++;
            }
        }
        boolean[] visited = new boolean[n];
        return dfs(map, visited, 0, 1);
    }

    private static int dfs(HashMap<Integer, Integer> map, boolean[] visited, int start, int before) {
        int result = 0;
        for (int i=start; i<visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int now = before * map.get(i);
                result += now + dfs(map, visited, i+1, now);
                visited[i] = false;
            }
        }
        return result;
    }
}



/* visited 필요 없어서 개선한 코드 */
class Solution {
    public int solution(String[][] clothes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<String, Integer> mapInt = new HashMap<>();
        int n = 0;
        for (String[] c: clothes) {
            if (mapInt.containsKey(c[1])) {
                int now = mapInt.get(c[1]);
                map.put(now, map.get(now)+1);
            } else {
                map.put(n, 1);
                mapInt.put(c[1], n);
                n++;
            }
        }
        return deep(map, n, 0, 1);
    }

    private static int deep(HashMap<Integer, Integer> map, int n, int start, int before) {
        int result = 0;
        for (int i=start; i<n; i++) {
            int now = before * map.get(i);
            result += now + deep(map, n, i+1, now);
        }
        return result;
    }
}
