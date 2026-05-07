/*
[문제]
SWEA 4880 - 토너먼트 카드게임

[분류]
재귀 / 분할정복 / 구현

[접근]
학생들이 낸 카드 정보를 배열에 저장한 뒤,
전체 학생 범위를 반으로 나누어 각각의 승자를 구한다.

start부터 end까지의 학생 중 승자를 구하는 divide(start, end) 함수를 만든다.
학생이 한 명만 남은 경우에는 그 학생이 승자이므로 start를 반환한다.

학생이 여러 명이면 구간을 왼쪽과 오른쪽으로 나눈다.
왼쪽 구간의 승자와 오른쪽 구간의 승자를 각각 재귀로 구한 뒤,
두 승자끼리 가위바위보 규칙에 따라 비교한다.

카드가 같은 경우에는 번호가 작은 학생이 이기므로,
왼쪽 승자를 반환하면 된다.

[시간복잡도]
O(N)

각 학생은 토너먼트 과정에서 비교 대상이 되고,
전체적으로 승부 비교는 N - 1번 정도 발생한다.
따라서 시간복잡도는 O(N)이다.

[핵심 포인트]
- divide(start, end)는 카드 값이 아니라 승자의 인덱스를 반환한다.
- start == end이면 학생이 한 명뿐이므로 start를 반환한다.
- mid = (start + end) / 2로 구간을 나눈다.
- left = divide(start, mid)
- right = divide(mid + 1, end)
- left와 right의 카드 값을 비교해서 이긴 학생의 인덱스를 반환한다.

[피드백]
풀이 방향은 분할정복을 사용한 정석적인 방식이다.
전체 구간을 반으로 나누고,
각 구간의 승자를 재귀적으로 구한 뒤,
두 승자끼리 비교하는 구조를 잘 잡았다.
*/
package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4880 {
    static int N;
    static int []cards;
    static int divide(int start, int end) {
        if(start == end) {
            return start;
        }

        int left = divide(start, (start+end)/2);
        int right = divide((start+end)/2+1,end);

        if(cards[left] == 1) {
            if(cards[right] == 1 || cards[right] ==3) {
                return left;
            }else {
                return right;
            }
        }else if(cards[left] == 2) {
            if(cards[right] == 1 || cards[right] ==2) {
                return left;
            }else {
                return right;
            }
        }else  {
            if(cards[right] == 2 || cards[right] ==3) {
                return left;
            }else {
                return right;
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            cards = new int[N];

            for(int i = 0; i < N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }
            int answer = divide(0,N-1)+1;


            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");

        }
        System.out.print(sb);
    }
}