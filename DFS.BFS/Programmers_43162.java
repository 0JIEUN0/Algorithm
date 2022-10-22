/*
        Programmers 43162 [DFS/BFS]
        : 네트워크

        한 네트워크로부터 시작해서 연관된 모든 곳을 0 으로 만들기.
        '시작'을 얼마나 하느냐가 곧 답이 되도록 함.
        (어떤한 '시작' 컴퓨터에 연결된 컴퓨터면 이미 방문 후 0 으로 만들었을 것이고,
        연계된 모든 컴퓨터들은 한번 '시작'하면 모두 같은 네트워크로 취급하기 때문)

        처음에는 배열 모양에서 착안해 DFS 로 구현하고자 했는데,
        [[1, 0, 1], [0, 1, 0], [1, 0, 1]] 과 같은 케이스가 있음을 깨닫고
        [x, x] 에서 시작해서 같은 네트워크에 있는 컴퓨터를 모두 찾는 것으로 변경.
*/


class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int k=0; k<n; k++) {
            if (computers[k][k] == 1) {
                computers[k][k] = 0;
                lookup(k, n, computers);
                answer++;
            }
        }
        return answer;
    }

    public static void lookup(int x, int n, int[][] computers) {
        for(int k=0; k<n; k++) { // look up this network's connections
            if (computers[x][k] == 1) {
                computers[x][k] = 0; // set visited
                computers[k][x] = 0; // mirrored
                lookup(k, n, computers);
            }
        }
    }
}
