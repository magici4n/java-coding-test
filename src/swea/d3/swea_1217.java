/*
[문제]
SWEA 1217 - 거듭 제곱

[분류]
재귀 / 구현

[접근]
A의 B제곱을 구하기 위해 A를 B번 곱한다.
repeat(A, B) 함수에서 answer에 A를 한 번 곱하고,
B를 1 감소시켜 다시 repeat(A, B - 1)을 호출한다.
B가 0이 되면 더 이상 곱할 필요가 없으므로 재귀를 종료한다.

[시간복잡도]
O(B)

B번 재귀 호출하면서 A를 한 번씩 곱한다.

[핵심 포인트]
재귀 함수에는 반드시 종료 조건이 필요하다.

if (B == 0) {
    return;
}

또한 재귀 호출을 할 때는 종료 조건에 가까워지도록 값이 변해야 한다.

repeat(A, B - 1);

[피드백]
현재 코드는 문제 의도에 맞게 재귀로 잘 풀었다.
answer를 전역 변수로 두고 값을 누적하는 방식도 가능하다.
다만 재귀 연습 관점에서는 pow(A, B)가 결과값을 return하도록 작성하는 방식이 더 깔끔하다.

예:
static int pow(int A, int B) {
    if (B == 0) return 1;
    return A * pow(A, B - 1);
}
*/
package swea.d3;

import java.util.Scanner;

public class swea_1217 {
    static int answer;

    static void repeat(int A, int B) {
        if(B == 0) {
            return;
        }
        answer *= A;
        repeat(A,B-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 0; tc < 10; tc++) {
            int T = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();

            answer = 1;
            repeat(A,B);
            System.out.print("#");
            System.out.print(T);
            System.out.print(" ");
            System.out.print(answer);
            System.out.println();
        }
    }
}

