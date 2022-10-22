/*
        Programmers 43163 [DFS/BFS]
        : 단어 변환

        조건 '한 번에 한 개의 알파벳만 바꿀 수 있다'를 판단한 방법
        : 현재 단어(string)에서, 한 char 마다,
        words 에 있는 단어에서 해당 char 로 해당 위치의 문자를 바꾸면 동일한지를 확인
        이게 동일하면, 한 개의 char 만 바꿨는데 동일하다는 것이므로 한 알파벳만 다른 문자열임.

        해당 문자열들을 찾아서 dfs.
        다 visit 했는데도 target 에 도달하지 못했으면 0 반환, 아니면 +1 한 게 answer.
*/


class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        return dfs(begin, target, words, visited);
    }
    public static int dfs(String begin, String target, String[] words, boolean[] visited) {
        int answer = 51;
        for (int i=0; i<begin.length(); i++) {
            char ch = begin.charAt(i);
            for (int j=0; j<visited.length; j++) {
                if (visited[j]) continue;
                String str = words[j].substring(0, i) + ch + words[j].substring(i+1);
                if (begin.equals(str)) {
                    if (target.equals(words[j])) return 1;
                    visited[j] = true;
                    int result = dfs(words[j], target, words, visited) + 1;
                    if (result > 1 && result < answer) answer = result;
                    visited[j] = false;
                }
            }
        }
        if (answer == 51) return 0;
        return answer;
    }
}
