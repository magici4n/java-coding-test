/*
[문제]
SWEA 1220 - Magnetic

[분류]
구현 / 배열 / 시뮬레이션 / 상태 관리

[접근]
자성체는 위아래 방향으로만 움직이므로, 행이 아니라 열 단위로 확인한다.

한 열을 위에서 아래로 탐색하면서 0은 빈 공간이므로 무시한다.
교착상태는 1번 자성체를 만난 뒤, 그 아래에서 2번 자성체를 만날 때 발생한다.

따라서 flag를 사용해서 현재 1번 자성체를 만난 상태인지 기록한다.

flag == 0 : 아직 1을 기다리는 상태
flag == 1 : 1을 만났고, 이제 2를 기다리는 상태

탐색 중 1을 만나면 flag를 1로 바꾸고,
flag가 1인 상태에서 2를 만나면 교착상태가 발생한 것이므로 answer를 증가시킨다.
그 후 다시 새로운 1을 찾기 위해 flag를 0으로 되돌린다.

[시간복잡도]
O(N^2)

N x N 배열의 모든 칸을 한 번씩 확인하므로 O(N^2)이다.
SWEA 1220에서는 N이 100으로 고정되어 있어 충분히 빠르다.

[핵심 포인트]
1. 자성체가 세로 방향으로만 움직이므로 열 단위로 탐색해야 한다.

2. 0은 빈 공간이므로 무시한다.

3. 교착상태는 한 열에서 의미 있는 숫자만 봤을 때,
   1 다음에 2가 나오는 경우이다.

4. flag 하나로 상태를 관리할 수 있다.

   flag == 0 : 1을 기다림
   flag == 1 : 2를 기다림

5. 1을 만난 뒤 2를 만나면 answer++ 하고,
   다시 다음 교착상태를 찾기 위해 flag = 0으로 초기화한다.

[피드백]
처음 문제를 보면 자성체가 움직이는 과정을 직접 시뮬레이션해야 할 것처럼 느껴질 수 있다.
하지만 이 문제는 실제 이동을 구현하는 문제가 아니라,
최종적으로 교착상태가 되는 패턴을 세는 문제이다.

핵심은 전체 격자를 복잡하게 보지 않고,
한 열씩 보면서 0을 무시하고 1 다음에 나오는 2의 개수를 세는 것이다.

힌트를 보고 아이디어를 얻었더라도 괜찮다.
이 문제에서 배워야 할 점은 시뮬레이션 문제라고 해서 반드시 실제 움직임을 구현할 필요는 없고,
방향성과 패턴을 관찰해서 더 단순하게 풀 수 있다는 것이다.

다음에 비슷한 문제가 나오면 먼저 다음 순서로 생각해보자.

1. 어느 방향으로 움직이는가?
2. 행 단위로 볼지, 열 단위로 볼지 정할 수 있는가?
3. 무시해도 되는 값이 있는가?
4. 사건이 발생하는 순서 패턴이 있는가?
5. 상태 변수 하나로 관리할 수 있는가?
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1220 {

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <=10; tc++) {
            int N = Integer.parseInt(br.readLine());

            int [][]map = new int[N][N];

            for(int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            for(int col = 0; col< 100; col++) {
                int flag = 0;
                for(int row = 0; row < 100; row++) {
                    if(flag == 0) {
                        if(map[row][col] == 1) {
                            flag = 1;
                        }
                    }else if(flag==1) {
                        if(map[row][col] == 2) {
                            flag = 0;
                            answer++;
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
