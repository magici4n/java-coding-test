# 이분 탐색(Binary Search)
___________________________
### 이분 탐색이란?
-> 정렬된 배열에서 가운데 값을 기준으로 찾는 방법.  

예를 들어 1 3 5 7 9 11 13 중에서 9를 찾는다면?   
가운데 7 확인.  
9는 7보다 큼  
→ 오른쪽만 탐색  

이런 식으로 범위를 절반씩 줄여나감  
-> 시간 복잡도 O(log N)


### 구현 코드   
<pre><code>
static boolean binarySearch(int[] arr, int target){
    int left = 0;
    int right = arr.length -1;
    
    while(left <= right){
        int mid = (left+right)/2;

        if(arr[mid] == target){
            return true;
        }else if(arr[mid] < target{
            left = mid + 1;
        }else{
            right = mid - 1;
        }
    }
    return false;
}
</code></pre>

### 자바 기본 메서드 사용
Arrays.sort(arr); 와 같이 반드시 정렬 먼저 한 후   

Arrays.binarySearch(arr, target) 사용   
-> 반환 값은 찾은 값의 인덱스, 못 찾은 경우 음수 반환  

그래서 코테에서는
if (Arrays.binarySearch(arr, target) >= 0) {   
    // 존재함  
} else {  
    // 존재하지 않음   
}  

이런 식으로 사용