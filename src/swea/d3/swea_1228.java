/*
[문제]
SWEA 1228 - 암호문1

[분류]
구현 / 리스트 / ArrayList / 문자열 처리

[접근]
원본 암호문을 ArrayList에 저장한 뒤, 명령어 I를 순서대로 처리한다.

명령어 형식은 다음과 같다.

I x y s1 s2 ... sy

x : 삽입할 위치
y : 삽입할 숫자의 개수
s1 ~ sy : 삽입할 숫자들

ArrayList의 add(index, value)는 해당 index 위치에 값을 삽입하고,
기존 값들은 뒤로 밀린다.

따라서 여러 개의 숫자를 같은 위치 x에 계속 삽입하면
입력 순서가 뒤집히게 된다.

이를 방지하기 위해 숫자를 하나 삽입할 때마다 x를 1씩 증가시켰다.

list.add(x, value);
x++;

이렇게 하면 첫 번째 숫자는 x 위치에,
두 번째 숫자는 x + 1 위치에,
세 번째 숫자는 x + 2 위치에 들어가므로 입력 순서가 유지된다.

모든 명령어 처리가 끝난 뒤, 암호문의 앞 10개 숫자만 출력한다.

[시간복잡도]
O(M * L)

M은 명령어의 개수이고,
L은 삽입 과정에서 리스트 원소들이 밀리는 비용이다.

ArrayList의 중간 삽입은 뒤쪽 원소들을 한 칸씩 밀어야 하므로 O(N)이 걸릴 수 있다.
하지만 SWEA 1228의 입력 크기에서는 ArrayList로 충분히 해결 가능하다.

[핵심 포인트]
1. ArrayList의 add(index, value)는 삽입이다.
   기존 값이 사라지는 것이 아니라 뒤로 밀린다.

2. 같은 index에 여러 번 add하면 삽입 순서가 뒤집힌다.

   예를 들어 x = 2이고 100, 200, 300을 같은 x에 계속 넣으면

   [100]
   [200, 100]
   [300, 200, 100]

   처럼 뒤집힌다.

3. 입력 순서를 유지하려면 삽입할 때마다 index를 증가시켜야 한다.

   list.add(x, value);
   x++;

4. 명령어 I 뒤에는 x, y가 나오고,
   그 다음 y개의 숫자가 이어진다.

5. 출력은 전체 리스트가 아니라 앞의 10개만 출력한다.

[피드백]
처음에는 list.add(x, value)를 반복해서 사용하면
입력된 숫자들이 그대로 순서대로 들어갈 것처럼 생각할 수 있다.

하지만 ArrayList의 add(index, value)는 삽입 연산이기 때문에
같은 위치에 계속 삽입하면 기존에 넣은 값이 뒤로 밀리고,
결과적으로 입력 순서가 반대로 들어간다.

마무리한 코드에서는 삽입 후 x++를 해주었기 때문에
숫자들이 입력 순서 그대로 들어가도록 잘 수정했다.

이번 문제에서 기억할 점은 ArrayList의 add와 set의 차이다.

add(index, value) : 삽입, 크기 증가, 기존 값 뒤로 밀림
set(index, value) : 교체, 크기 유지, 기존 값 변경

앞으로 리스트 중간에 여러 값을 삽입하는 문제가 나오면,
삽입 위치를 고정할지 증가시킬지 작은 예시로 확인하는 습관을 들이면 좋다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1228 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <=10; tc++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }


            int M = Integer.parseInt(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                String c = st1.nextToken();
                int x = Integer.parseInt(st1.nextToken());
                int y = Integer.parseInt(st1.nextToken());
                for(int j = 0; j < y; j++) {
                    list.add(x,Integer.parseInt(st1.nextToken()));
                    x++;
                }
            }
            sb.append("#").append(tc).append(" ");
            for(int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}
