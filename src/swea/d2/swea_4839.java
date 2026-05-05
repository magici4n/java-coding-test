/*
[문제]
SWEA 4839 – 이진탐색

[분류]
구현 / 이진 탐색 / 시뮬레이션

[접근]
A와 B가 각각 목표 페이지를 찾을 때까지 이진 탐색을 진행한다.
각각 몇 번 만에 페이지를 찾는지 count로 세고,
더 적은 횟수로 찾은 사람이 승리한다.
횟수가 같으면 0을 출력한다.

[시간복잡도]
O(T * log P)

각 테스트케이스마다 A와 B에 대해 이진 탐색을 한 번씩 수행한다.
이진 탐색은 탐색 범위가 절반씩 줄어들기 때문에 O(log P)이다.
A, B 두 번 수행해도 상수 배이므로 테스트케이스 하나당 O(log P)이다.

[핵심 포인트]
1. 이 문제는 일반적인 이진 탐색과 탐색 방식이 다르다.

일반 이진 탐색에서는 이미 확인한 mid를 제외하기 때문에

left = mid + 1;
right = mid - 1;

을 사용한다.

하지만 SWEA 4839번은 문제에서 제시한 방식대로

left = mid;
right = mid;

를 사용한다.

2. 배열을 만들 필요가 없다.

페이지 번호는 1부터 P까지이므로

int left = 1;
int right = P;

로 두고 mid를 계산하면 된다.

3. 탐색 횟수 비교

A가 더 적은 횟수로 찾으면 A 출력
B가 더 적은 횟수로 찾으면 B 출력
둘의 횟수가 같으면 0 출력

[피드백]
처음 코드에서는 int[] book 배열을 만들어서 페이지 번호를 저장했다.
하지만 이 문제는 실제 배열 탐색이 아니라 1부터 P까지의 페이지 범위에서
가운데 페이지를 계속 확인하는 문제이므로 배열은 필요 없다.

또 처음에는 일반 이진 탐색처럼

left = mid + 1;
right = mid - 1;

방식으로 작성했는데, SWEA 4839번은 문제에서 제시한 탐색 방식이 따로 있기 때문에
탐색 횟수가 달라질 수 있다.

즉, 일반 이진 탐색 코드로는 논리 자체는 맞아 보여도
이 문제에서 요구하는 탐색 횟수와 달라져 오답이 될 수 있다.

다만 left = mid, right = mid 방식은 일반적인 이진 탐색에서는 무한 루프 위험이 있다.
그래서 이 방식은 SWEA 4839번처럼 문제에서 특별히 요구할 때만 사용해야 한다.

다음에 이진 탐색 문제를 풀 때는 먼저 확인할 것:

1. 단순히 값을 찾는 일반 이진 탐색 문제인가?
2. 문제에서 특정한 탐색 과정을 그대로 따라 하라고 한 문제인가?

이 둘을 구분하는 것이 중요하다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4839 {

    static int binary(int P , int search_num) {
        int count = 0;
        int left = 1;
        int right = P;

        while (true) {
            count++;
            int mid = (left + right) / 2;

            if (mid == search_num) {
                return count;
            } else if (mid > search_num) {
                right = mid;
            } else {
                left = mid;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Pa = Integer.parseInt(st.nextToken());
            int Pb = Integer.parseInt(st.nextToken());

            int A = binary(P,Pa);
            int B = binary(P,Pb);

            sb.append("#").append(tc+1).append(" ");
            if(A>B){
                sb.append("B");
            }else if(A < B){
                sb.append("A");
            }else{
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
