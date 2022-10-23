/*
    Programmers 86971 [완전탐색]
    : 전력망을 둘로 나누기

    Union-Find 로 해결
    - 해당 알고리즘을 처음 구현해서 오류가 좀 있었음...
    DFS 로도 풀 수 있던데 나중에 시도해볼 것~!
 */


import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 10000;
        int[] parents = new int[n+1];
        for (int i=0; i<wires.length; i++) {
            for (int j=1; j<=n; j++) parents[j]=j;
            for (int j=0; j<wires.length; j++) {
                if (i == j) continue;
                union(parents, wires[j][0], wires[j][1]);
            }
            int p1N = 0;
            int p2N = 0;
            for (int j=1; j<=n; j++) {
                if (find(parents, parents[j]) == 1) p1N++;
                else p2N++;
            }
            if (Math.abs(p1N-p2N) < answer) answer = Math.abs(p1N-p2N);
            //if (Math.abs(n-2*p1N) < answer) answer = Math.abs(n-2*p1N);
        }
        return answer;
    }
    public static void union(int[] parents, int x, int y) {
        int rx = find(parents, x);
        int ry = find(parents, y);
        if (rx < ry) parents[ry] = rx;
        else if (ry < rx) parents[rx] = ry;
    }
    public static int find(int[] parents, int x) {
        if (parents[x] != x)
            parents[x] = find(parents, parents[x]);
        return parents[x];
    }
}
