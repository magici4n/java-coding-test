/*
[문제]
Programmers 468371 - 노란불 신호등

[분류]
구현 / 수학 / 최대공약수(GCD) / 최소공배수(LCM) / 나머지 연산

[접근]
각 신호등의 한 주기는 G + Y + R이다.
모든 신호등의 주기의 최소공배수까지만 시간을 1초씩 증가시키며 확인한다.

현재 시간이 각 신호등의 한 주기에서 어느 위치인지
(time - 1) % cycle 로 구하고,
모든 신호등이 동시에 노란불인 최초의 시간을 반환한다.

전체 주기 안에서도 동시에 노란불이 되는 시간이 없다면 -1을 반환한다.

[시간복잡도]
O(L * N)

N = 신호등의 개수
L = 모든 신호등 주기의 최소공배수

각 시간마다 N개의 신호등을 확인하기 때문.

[핵심 포인트]
1. 배열의 길이
   signals.length

2. 각 신호등의 주기
   cycle = G + Y + R

3. 현재 시간의 주기 내 위치
   position = (time - 1) % cycle

   time이 1초부터 시작하지만
   배열처럼 position은 0부터 생각하기 때문에 time - 1을 사용한다.

4. 노란불 범위
   G <= position && position < G + Y

   반대로 노란불이 아닌 경우
   position < G || position >= G + Y

5. 최대공약수 - 유클리드 호제법
   gcd(a, b) = gcd(b, a % b)

6. 최소공배수
   lcm(a, b) = a / gcd(a, b) * b

7. 여러 주기의 최소공배수
   앞에서부터 하나씩 LCM을 누적해서 계산한다.

8. 모든 신호등이 조건을 만족하는지 확인할 때
   boolean allYellow = true 로 시작하고,
   하나라도 만족하지 않으면 false로 바꾸고 break 한다.

[피드백]
- 2차원 배열에서 signals.length와 signals[i][j] 사용을 다시 복습했다.
- GCD와 LCM 구현법이 바로 떠오르지 않았다.
- 노란불의 범위를 잡을 때 <, <=, >= 경계조건이 헷갈렸다.

[다시 풀 때]
1. 먼저 각 신호등의 주기를 구한다.
2. 전체 패턴이 언제 반복되는지 생각한다. → LCM
3. 현재 시간이 주기에서 어디인지 생각한다. → %
4. 노란불 구간을 [G, G + Y) 형태로 표현한다.
*/
package programmers.lv1;

public class P468371 {
    public static void main(String[] args){
        Solution sol = new Solution();

        int[][] signals = {
                {2, 1, 2},
                {5, 1, 1}
        };

        System.out.println(sol.solution(signals));
    }

    static class Solution {
        public int solution(int[][] signals) {

            int []cycles = new int[signals.length];

            for(int i = 0; i<cycles.length; i++){
                cycles[i] = signals[i][0] + signals[i][1] + signals[i][2];
            }

            int totalCycle = cycles[0];

            for(int i = 1; i < cycles.length; i++){
                totalCycle = lcm(totalCycle, cycles[i]);
            }

            for(int time = 1; time <= totalCycle; time++){
                boolean allYellow = true;

                for(int i = 0; i < signals.length; i++){
                    int position = (time - 1) % cycles[i];

                    if(position < signals[i][0] || position >= signals[i][0] + signals[i][1]){
                        allYellow = false;
                        break;
                    }
                }
                if(allYellow){
                    return time;
                }
            }
            return -1;
        }
        int gcd(int a, int b){
            while(b!=0){
                int temp = a % b;
                a = b;
                b = temp;
            }
            return a;
        }
        int lcm(int a, int b) {
            return a * b / gcd(a, b);
        }
    }

}
