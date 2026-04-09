# Queue
______________________________
먼저 넣은 데이터를 먼저 꺼내는 구조(FIFO = First In First Out)   

### 자바에서 큐를 사용하는 방법

1. 
<pre><code>
import java.util.Queue;
import java.util.LinkedList;

Queue<Integer> queue = new LinkedList<>();
</code></pre>
2. 
<pre><code>
import java.util.Queue;
import java.util.ArrayDeque;

Queue<Integer> queue = new ArrayDeque<>();
</code></pre>  


Queue<Integer> queue = new LinkedList<>();는 옛날에 쓰는 방식   
일반 큐 용도로는 보통 Queue<Integer> q = new ArrayDeque<>(); 사용   
-> 이유는 일반적으로 더 깔끔하고 빠름 
   
- 일반 큐 -> ArrayDeque
- 우선순위 큐 -> PriorityQueue   
   
### 자주 쓰는 메서드   
- offer() : 큐의 뒤에 데이터를 넣음   
<pre><code>

queue.offer(10);

</code></pre>

- poll() : 큐의 맨 앞 데이터를 제거 후 반환
<pre><code>

int x = queue.poll();
System.out.println(x);

</code></pre>

- peek() : 큐의 맨 앞 데이터를 반환(제거 x)
<pre><code>

System.out.println(queue.peek());

</code></pre>

- isEmpty() : 비어 있는지 확인
<pre><code>

if (queue.isEmpty()) {
    System.out.println("비어있음");
}

</code></pre>  

- size() : 현재 원소 개수 반환 
<pre><code>

System.out.println(queue.size());

</code></pre>


### 비슷한 메서드
큐에는 비슷한 메서드가 두 세트가 있음   
- offer() / poll() / peek()
- add() / remove() / element()

이것들의 차이 : 비어있을 때나 실패할 때의 처리 방식   

코테에서는 이것들 추천 
- offer()
- poll()
- peek()  
이유 -> 실패 시 예외 대신 false나 null로 다루기 쉬워서.   

### 활용 전체 예시   
<pre><code>

import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue.peek()); // 10
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 20
        System.out.println(queue.size()); // 1
        System.out.println(queue.peek()); // 30
    }
}

</code></pre>   


### 큐의 맨 뒤 값을 확인하고 싶을 때   
Queue 인터페이스는 기본적으로 맨 앞(front) 중심 구조라서 맨 뒤를 바로 보는 메서드는 없음  
-> Deque을 써야 함.  

즉, 큐 문제인데 맨 뒤 확인 필요하다 -> 구현은 Deque을 사용   


### 큐를 주로 쓸때  
- 줄 서는 순서 처리
- 작업 대기열
- 프린터 대기
- BFS(너비 우선 탐색)
- 카드 버리기 문제
- 요세푸스 비슷한 회전 처리
- 특히 알고리즘에서는 BFS의 핵심 자료구조가 큐