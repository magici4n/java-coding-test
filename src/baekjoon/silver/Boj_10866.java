/*
[문제]
BOJ 10866 - 덱

[분류]
구현 / 덱

[접근]
양쪽 끝에서 삽입과 삭제가 모두 가능해야 하므로 Deque를 사용했다.

[시간복잡도]
O(N)
- 명령 N개 수행, Deque메서드들은 O(1)

[핵심 포인트]
offerFirst(),offerLast()
pollFirst(),pollLast()
peekFirst(),peekLast()
isEmpty()
size()

[피드백]
덱 메서드들 잘 숙지하기
비슷한 if-else가 반복되므로 삼항 연산자를 쓰면 더 간결해질 수 있다
-> sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append('\n');
*/

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_10866 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i =0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push_front": dq.offerFirst(Integer.parseInt(st.nextToken())); break;
                case "push_back":  dq.offerLast(Integer.parseInt(st.nextToken())); break;
                case "pop_front":
                    if(dq.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(dq.pollFirst()).append("\n");
                    }
                    break;

                case "pop_back":
                    if(dq.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(dq.pollLast()).append("\n");
                    }
                    break;
                case "size": sb.append(dq.size()).append("\n");break;
                case "empty":
                    if(dq.isEmpty()){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(dq.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(dq.peekFirst()).append("\n");
                    }
                    break;
                case "back" :
                    if(dq.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(dq.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}