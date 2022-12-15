[문제 링크](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

## 문제
> LeetCode 124. Binary Tree Maximum Path Sum

트리 탐색하며
- max(현 노드 + 왼쪽 자식으로부터의 최대 경로, 현 노드 + 오른쪽 자식으로부터의 최대 경로) 를 구해서
- 현재 노드를 포함하는 경로 중 큰 값이 답.
- 현재 노드를 기준으로, 왼쪽 또는 오른쪽 자식 트리만을 포함하여 위 노드로의 경로를 확장할 수 있다는 것과,
현재 노드를 포함하는 것을 기준으로 최대값을 산정해야 함을 유의해서 풀기!
  - 처음엔 왼쪽+오른쪽+현재노드 로 구하기도 하고,
  - 현재 노드를 포함하거나, 아니거나 로 최대값을 구하려 해서 잘 안 됐었음.
  - 또, 2가지 값이 재귀 함수들 사이에서 업데이트되어야 하기 때문에 `answer` 를 빼서 사용(다른 하나는 return value). 

## java
- Runtime 99.55%, Memory 88.8%
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int answer = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recursive(root);
        return answer;
    }
    public int recursive(TreeNode parent) {
        if (parent == null) return 0;
        int left = Math.max(recursive(parent.left), 0);
        int right = Math.max(recursive(parent.right), 0);
        answer = Math.max(answer, left + parent.val + right);

        int max = Math.max(left, right);
        return max + parent.val;
    }
}
```
