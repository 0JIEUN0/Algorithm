[문제 링크](https://leetcode.com/problems/top-k-frequent-elements/)

## 문제
> LeetCode 347. Top K Frequent Elements

Map 으로 각 숫자 카운트 후 Map 의 value 를 기준으로 정렬한 다음,
return the k most frequent elements.


## Python
- dictionary subclass `Counter` 사용할 수도 있음.
```python
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        dic = {}
        for num in nums:
            if num not in dic: dic[num]=0
            dic[num] = dic[num] + 1
        frequent_elements = [key for key, v in sorted(dic.items(), key=lambda item: -item[1])]
        return frequent_elements[:k]
```
