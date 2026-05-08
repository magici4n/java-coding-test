/*
[문제]
SWEA 5186 – 이진수2

[분류]
수학 / 구현 / 진법 변환 / 문자열 처리

[접근]
0보다 크고 1보다 작은 소수를 이진수로 변환하는 문제이다.

정수는 Integer.toBinaryString()으로 변환할 수 있지만,
소수 부분은 직접 변환해야 한다.

소수 이진수 변환 방식은 다음과 같다.

1. 소수에 2를 곱한다.
2. 결과가 1 이상이면 이진수 자리에 1을 붙이고, 1을 뺀다.
3. 결과가 1 미만이면 이진수 자리에 0을 붙인다.
4. 소수 부분이 0이 될 때까지 반복한다.
5. 단, 이진수 길이가 12자리를 넘으면 overflow를 출력한다.

예를 들어 0.625라면,

0.625 * 2 = 1.25 → 1 추가, 남은 값 0.25
0.25  * 2 = 0.5  → 0 추가, 남은 값 0.5
0.5   * 2 = 1.0  → 1 추가, 남은 값 0

결과는 101이다.

[시간복잡도]
O(1)

최대 12자리까지만 확인하고,
13자리가 되는 순간 overflow 처리하기 때문에 반복 횟수는 최대 13번 정도이다.

입력값의 크기와 관계없이 반복 횟수가 제한되어 있으므로 O(1)로 볼 수 있다.

[핵심 포인트]
- 소수 이진수 변환은 2를 계속 곱하는 방식으로 처리한다.
- num >= 1이면 '1'을 추가하고 num -= 1을 해준다.
- num < 1이면 '0'을 추가한다.
- StringBuilder에도 length() 메서드를 사용할 수 있다.
- result.length() > 12가 되면 12자리 안에 표현할 수 없으므로 overflow이다.
- Integer.toBinaryString()은 int 정수만 처리하므로 소수 변환에는 사용할 수 없다.

[피드백]
이번 풀이는 핵심 로직을 잘 구현한 풀이이다.

소수에 2를 곱하면서 이진수 자리를 하나씩 만들어가는 방식이 정확했고,
12자리를 초과했을 때 overflow 처리하는 조건도 잘 잡았다.

처음에는 소수도 Integer.toBinaryString()으로 바꿀 수 있을지 헷갈릴 수 있지만,
이 문제는 정수 진법 변환이 아니라 소수 부분의 진법 변환 문제이다.

또한 StringBuilder를 단순히 출력 누적용으로만 쓰는 것이 아니라,
result.length()를 통해 현재 만든 이진수의 길이를 확인할 수 있다는 점도 알아두면 좋다.

개선한다면 overflow 여부를 boolean 변수로 따로 관리하면 코드 의도가 조금 더 명확해진다.
하지만 현재 풀이도 논리적으로 문제 없고 정답 가능한 코드이다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_5186 {

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++) {
            sb.append("#").append(tc+1).append(" ");

            double num = Double.parseDouble(br.readLine());
            StringBuilder result = new StringBuilder();
            while(num>0) {
                num *= 2;

                if(num >= 1) {
                    result.append("1");
                    num -= 1;
                }else {
                    result.append("0");
                }

                if(result.length()>12) {
                    sb.append("overflow");
                    break;
                }
            }
            if(result.length() <=12) {
                sb.append(result);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
