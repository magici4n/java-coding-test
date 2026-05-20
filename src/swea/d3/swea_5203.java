/*
[문제]
SWEA 5203 - 베이비진 게임

[분류]
구현 / 배열 / 시뮬레이션 / 완전탐색

[접근]
두 플레이어가 카드를 번갈아 받으므로, A와 B 배열에 각각 받은 카드를 저장한다.

각 플레이어가 최소 3장 이상 받은 시점부터 run 또는 triplet이 만들어졌는지 검사한다.

triplet은 현재 받은 카드와 같은 숫자가 이전 카드들 중 몇 개 있는지 세어서,
현재 카드까지 포함해 3개 이상이면 true로 판단한다.

run은 현재 받은 카드를 기준으로 만들 수 있는 연속된 세 숫자 조합을 확인한다.
현재 카드가 num일 때 가능한 run은 다음 세 가지이다.

1. num-2, num-1, num
2. num-1, num, num+1
3. num, num+1, num+2

따라서 이전 카드들 중 num-2, num-1, num+1, num+2가 있는지 확인하고,
가능한 조합 중 하나라도 만족하면 run으로 판단한다.

카드를 받을 때마다 A와 B를 검사하고, 먼저 run 또는 triplet을 만든 플레이어를 승자로 출력한다.
아무도 만들지 못하면 0을 출력한다.

[시간복잡도]
O(1)

각 테스트케이스마다 플레이어별 최대 6장의 카드만 검사한다.
run_check와 triplet_check 모두 최대 6개 이하의 카드만 확인하므로,
입력 크기와 무관하게 상수 시간으로 볼 수 있다.

일반적으로 표현하면 카드 개수를 N이라고 할 때,
각 카드마다 이전 카드들을 검사하므로 O(N^2)이지만,
이 문제에서는 N이 6으로 고정되어 O(1)이다.

[핵심 포인트]
1. 최소 3장을 받은 뒤부터 run 또는 triplet 검사가 가능하다.

if (i >= 2) {
    // 검사 시작
}

2. triplet은 현재 카드와 같은 숫자가 이전에 2장 이상 있는지 확인하면 된다.

int count = 1;
for (int i = 0; i < index; i++) {
    if (N[i] == num) {
        count++;
    }
}
return count >= 3;

3. run은 현재 카드를 기준으로 가능한 세 가지 경우를 확인한다.

num-2, num-1, num
num-1, num, num+1
num, num+1, num+2

4. 찾을 숫자 배열과 체크 배열을 분리해야 한다.

int[] close = {num - 2, num - 1, num + 1, num + 2};
int[] check = {0, 0, 0, 0};

처음에는 찾은 값을 1로 바꾸는 방식 때문에,
실제 카드 숫자 1과 표시값 1이 충돌할 수 있었다.
따라서 close 배열은 비교 대상 숫자를 저장하고,
check 배열은 해당 숫자를 찾았는지 여부만 저장하도록 분리했다.

5. flag_A와 flag_B를 이용해 승리 여부를 저장한다.
출력할 때 A를 먼저 검사하면, 같은 턴에서 둘 다 완성된 경우에도 A가 우선된다.

[피드백]
이번 풀이는 정석적인 카운팅 배열 풀이와는 다르지만, 접근 자체는 맞았다.
문제의 핵심인 "카드를 받을 때마다 run 또는 triplet을 검사한다"는 흐름을 제대로 잡았다.

다만 run_check에서 처음에는 찾은 값을 표시하기 위해 check 값을 1로 바꾸는 방식이었는데,
카드 숫자 1과 표시값 1이 충돌할 수 있어 오답 가능성이 있었다.
이를 close 배열과 check 배열로 분리하면서 논리 오류를 해결했다.

현재 풀이는 현재 받은 카드를 기준으로 가능한 run 조합만 확인하는 직접 구현 방식이다.
카드 개수가 적기 때문에 충분히 가능한 풀이이다.

다만 이 문제의 더 정석적인 풀이는 숫자 카드가 0~9라는 점을 이용해
int[] count = new int[10] 배열로 각 숫자의 개수를 관리하는 방식이다.

정리하면,
이번 풀이는 정석 풀이는 아니지만 문제 조건 안에서는 충분히 맞는 구현 풀이이다.
다음에 baby-gin, 숫자 카드, run/triplet 문제가 나오면
카운팅 배열 풀이도 함께 떠올리면 좋다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5203 {

    static boolean run_check(int [] N, int index) {
        int num = N[index];
        int []close = {num-2,num-1,num+1,num+2};
        int []check = {0,0,0,0};
        for(int i = 0; i< index; i++) {
            for(int j = 0; j < 4; j++) {
                if(N[i]==close[j]) {
                    check[j] = 1;
                }
            }
        }
        if(check[0] == 1 && check[1] == 1) return true;
        if(check[1] == 1 && check[2] == 1) return true;
        if(check[2] == 1 && check[3] == 1) return true;
        return false;
    }
    static boolean triplet_check(int []N, int index) {
        int num = N[index];
        int count = 1;
        for(int i =0; i<index; i++) {
            if(N[i] == num) {
                count++;
            }
        }
        return count >= 3;
    }

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A[] = new int[6];
            int B[] = new int[6];
            boolean flag_A = false;
            boolean flag_B = false;
            for(int i = 0; i<6; i++) {
                A[i] = Integer.parseInt(st.nextToken());
                B[i] = Integer.parseInt(st.nextToken());
                if(i >=2) {
                    if(run_check(A,i)) flag_A = true;
                    if(run_check(B,i)) flag_B = true;
                    if(triplet_check(A,i)) flag_A = true;
                    if(triplet_check(B,i)) flag_B = true;
                }
                if(flag_A || flag_B) {
                    break;
                }
            }
            sb.append("#").append(tc+1).append(" ");
            if(flag_A) {
                sb.append("1").append("\n");
            }else if(flag_B) {
                sb.append("2").append("\n");
            }else {
                sb.append("0").append("\n");
            }

        }
        System.out.print(sb);
    }
}
