/*
[문제]
BOJ 10845 - 큐

[분류]
구현 / 큐

[접근]
이 문제를 어떤 방식으로 풀었는지 한두 줄로 적기

[시간복잡도]
O(N)
- 반복문이 N번

[핵심 포인트]
이 문제는 뒤에도 신경 써야하기 때문에 덱을 사용해야함.
Deque<Integer> queue = new ArrayDeque<>();

[피드백]
removeFirst()는 빈 큐에서 예외가 날 수 있으므로 isEmpty() 체크가 필요하다 -> pollFirst(), pollLast()사용하기
*/

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_10845 {
    public static void main(String []args)throws IOException {
        Deque<Integer> queue = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "push":queue.addLast(Integer.parseInt(st.nextToken())); break;
                case "pop":
                    if (!queue.isEmpty()){
                        sb.append(queue.removeFirst()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "front":
                    if (!queue.isEmpty()){
                        sb.append(queue.peekFirst()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if (!queue.isEmpty()){
                        sb.append(queue.peekLast()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size": sb.append(queue.size()).append("\n"); break;
                case "empty":
                    if (!queue.isEmpty()){
                        sb.append(0).append("\n");
                    }else{
                        sb.append(1).append("\n");
                    }
                    break;

            }
        }
        System.out.println(sb);
    }
}
