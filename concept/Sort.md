# 정렬
_________________

### 배열 정렬
Arrays.sort(arr);    
### 리스트 정렬
Collections.sort(list); <-> Collections.sort(list, Collections.reverseOrder());  
또는   
list.sort(null);  <-> list.sort(Collections.reverseOrder());   


### 배열 내림차순
int[] 같은 기본형 배열 -> reverseOrder() 사용 불가  
<pre><code>
int[] arr = {3, 1, 2};    
// Arrays.sort(arr, Collections.reverseOrder());  // 안 됨

//기본형 배열
//int[] arr;
//double[] arr;
//char[] arr;

</code></pre>

Integer[] 같은 객체형 배열 ->  reverseOrder() 사용 가능
<pre><code>
Integer[] arr = {3, 1, 2};
Arrays.sort(arr, Collections.reverseOrder());

// 객체형 배열
// Integer[] arr;
// Double[] arr;
// String[] arr;
</code></pre>   


## 기준을 바꾼 정렬
-> 기본 사전순이 아니라 직접 기준을 준 정렬   
ex) 예를 들어 문자열 길이순 정렬
<pre><code>
List<String> list = new ArrayList<>();
list.add("bbb");
list.add("a");
list.add("cc");

list.sort((a, b) -> a.length() - b.length());

</code></pre>

ex) 2차원 배열 정렬 (첫 번째 값 기준 오름차순 ,같으면 두 번째 값 기준 오름차순)   
<pre><code>
int[][] arr = {
    {3, 2},
    {1, 5},
    {1, 2}
};

Arrays.sort(arr, (a, b) -> {
    if (a[0] == b[0]) {
        return a[1] - b[1];
    }
    return a[0] - b[0];
});

// # {1, 2}
// # {1, 5}
// # {3, 2}
</code></pre>
