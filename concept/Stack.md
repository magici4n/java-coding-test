# 스택(Stack)
_________________
### 자바에서 스택을 사용하는 방법   
1. Stack 클래스
<pre>
<code>
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
</code>
</pre>
2. Deque 사용
<pre>
<code>
import java.util.ArrayDeque;
import java.util.Deque;

Deque<Integer> stack = new ArrayDeque<>();
</code>
</pre>

### 최근에는 Stack 보단 Deque(ArrayDeque)를 더 추천함  
-Stack도 쓸 수 있지만 자바에서 오래된 클래스라서 Deque를 추천.  

### 자주쓰는 메서드   
- push(값) : 스택에 값 넣기
<pre><code>
stack.push(5);
</code></pre>
- pop() : 맨 위 값 꺼내면서 제거(비어 있는데 pop할 경우 에러)
<pre><code>
int x = stack.pop();
</code></pre>
- peek() : 맨 위 값 보기만 하고 제거는 안 함(비어 있는데 peek할 경우 에러)
<pre><code>
int x = stack.peek();
</code></pre>
- isEmpty() : 비었는지 확인
<pre><code>
if (stack.isEmpty()) {
    System.out.println("비어있음");
}
</code></pre>
- size() : 들어있는 개수 확인  
<pre><code>
System.out.println(stack.size());
</code></pre>   


### 활용 전체 예시  
<pre><code>
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                stack.push(x);
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            } else if (command.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
</code></pre>

### 스택을 주로 쓸때   
- 괄호 검사  
- 되돌리기(undo)
- 함수 호출 순서 관리
- DFS(깊이 우선 탐색)
- 문자열 뒤집기