[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/49191)

## 문제

> Programmers 49191 [Graph]: 순위

그래프를 타고 들어가서 계속 탐색해야 한다는 생각헤 헤맸지만, 
*Floyd-Warshall* 이라는 힌트를 통해 풀 수 있었다.

A->B 이고 B->C 인 경우들을 정리해두고,
해당 배열을 통해 A->C 인 경우를 추가해주는 방식이다. 
회종적으로 모든 이긴(이긴 것이 확실한) 경우를 통해 해당 선수의 순위를 알 수 있는지를 체크한다.  

## Java
```java
class Solution {
    public int solution(int n, int[][] results) {
        int[][] floyd = new int[n+1][n+1];
        for (int i=0; i<results.length; i++) {
            floyd[results[i][0]][results[i][1]] = 1;
        }
        
        // floyd-warshall
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<n+1; j++) {
                for (int k=1; k<n+1; k++) {
                    if (floyd[j][i] == 1 && floyd[i][k] == 1){
                        floyd[j][k] = 1;
                    }
                }
            }
        }
        
        // find answer
        int answer = 0;        
        for (int i=1; i<n+1; i++) {
            int known = 0;
            for (int j=1; j<n+1; j++) {
                if (floyd[i][j] == 1 || floyd[j][i] == 1) known++;
            }
            if (known == n-1) answer++;
        }
        return answer;
    }
}
```
