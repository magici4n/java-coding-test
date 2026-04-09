# Deque
_______________________________
양쪽 끝에서 넣고 뺄 수 있는 자료구조(Double-Ended Queue의 줄임말)

### 자바에서 덱 선언
<pre><code>
import java.util.Deque;
import java.util.ArrayDeque;

Deque<Integer> dq = new ArrayDeque<>();

</code></pre>

### 덱의 기본 메서드
- offerFirst : 앞에 넣기
<pre><code>

dq.offerFirst(10);

</code></pre>

- offerLast : 뒤에 넣기
<pre><code>

dq.offerLast(20);

</code></pre>

- pollFirst : 앞에서 빼기
<pre><code>

dq.pollFirst();

</code></pre>

- pollLast : 뒤에서 빼기
<pre><code>

dq.pollLast();

</code></pre>

- peekFirst : 앞 데이터 값 확인 
<pre><code>

dq.peekFirst();

</code></pre>

- peekLast : 뒤 데이터 값 확인
<pre><code>

dq.peekLast();

</code></pre>


### 덱 사용 예시   
<pre><code>
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();

        dq.offerLast(10);   // [10]
        dq.offerLast(20);   // [10, 20]
        dq.offerFirst(5);   // [5, 10, 20]

        System.out.println(dq.peekFirst()); // 5
        System.out.println(dq.peekLast());  // 20

        System.out.println(dq.pollFirst()); // 5
        System.out.println(dq.pollLast());  // 20

        System.out.println(dq.peekFirst()); // 10
    }
}

</code></pre>   

### 덱은 스택처럼도 사용 가능
-> 스택 스타일처럼 push, pop, peek도 사용가능


### 덱 사용
- 앞뒤 둘 다 써야할 때
- 회전이 필요한 문제(카드 돌리기, 풍선 문제, 슬라이딩 윈도우)