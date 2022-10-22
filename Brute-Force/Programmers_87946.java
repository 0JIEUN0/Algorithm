/*
        Programmers 87946 [완전탐색]
        : 피로도

        처음에는 Greedy 처럼 접근하려고 정렬해보려 했으나,
        조건이 2가지라서 결국 완전탐색으로 접근해야 함을 꺠달음.

        각 던전부터 시작해서 가장 깊게 내려갈 수 있는 = 가장 많이 갈 수 있는 던전의 수를 구함.
        즉, 어떤 던전에서 시작하면 가장 많이 갈 수 있는 경우가 나오는지 찾음.
*/


import java.util.Arrays;

class Solution {
    public int solution(int k, int[][] dungeons) {
        // sort dungeons first --- no need to sort
        // Arrays.sort(dungeons, (x1, x2)->x1[0]-x2[0]);

        // search
        int answer = -1;
        int n = dungeons.length;
        for (int i=0; i<n; i++) {
            if (k >= dungeons[i][0]) {
                int[] visited = new int[n]; // default value is 0
                visited[i] = 1;             // 0: not visited, 1: visited
                int result = dfs(k - dungeons[i][1], dungeons, visited) + 1;
                if (answer < result) answer = result;
            }
        }
        return answer;
    }
    public static int dfs(int k, int[][] dungeons, int[] visited) {
        //System.out.println("visited: " + Arrays.toString(visited));
        int depth = 0;
        for (int i=0; i<dungeons.length; i++) {
            if (visited[i] == 0 && k >= dungeons[i][0]) { // look
                visited[i] = 1;
                int result = dfs(k - dungeons[i][1], dungeons, visited) + 1;
                if (depth < result) depth = result;
                visited[i] = 0; // for BF
            }
        }
        return depth;
    }
}
