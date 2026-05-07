/*
[문제]
SWEA 5185 - 이진수

[분류]
구현 / 문자열 / 진법 변환

[접근]
16진수 문자열을 입력받아 2진수 문자열로 변환하는 문제이다.

처음에는 16진수 문자열 전체를 int나 long으로 변환하는 방식을 생각할 수 있지만,
N이 최대 100이므로 전체 값을 정수형 변수에 담을 수 없다.

따라서 16진수 문자열을 한 글자씩 처리한다.
16진수 한 글자는 항상 2진수 4자리로 표현되므로,
각 문자를 10진수 값으로 바꾼 뒤 2진수 문자열로 변환하고,
길이가 4보다 작으면 앞에 0을 채워 출력한다.

[시간복잡도]
O(N)

16진수 문자열의 길이가 N이고,
각 문자를 한 번씩 처리하므로 시간복잡도는 O(N)이다.

[핵심 포인트]
- 16진수 한 글자는 2진수 4자리로 표현된다.
  예: A → 1010, F → 1111, 3 → 0011
- 전체 16진수 문자열을 int나 long으로 변환하면 범위 초과가 발생할 수 있다.
- Character.digit(c, 16)은 문자 c를 16진수로 해석해서 10진수 int 값으로 바꿔준다.
- Integer.toBinaryString(value)는 정수를 2진수 문자열로 바꿔준다.
- 변환된 2진수 문자열의 길이가 4보다 작으면 앞에 0을 붙여야 한다.

[피드백]
처음 풀이에서는 Integer.valueOf(num, 16)을 사용해
16진수 문자열 전체를 한 번에 정수로 변환하려고 했다.

하지만 문제에서 N이 최대 100이므로,
16진수 100자리는 2진수로 최대 400비트가 될 수 있다.
int나 long으로는 이 값을 저장할 수 없기 때문에
런타임 에러가 발생할 수 있다.

수정한 풀이에서는 16진수 문자열을 한 글자씩 처리하도록 바꾸었다.
각 문자를 Character.digit(c, 16)으로 10진수 값으로 바꾸고,
Integer.toBinaryString()으로 2진수 문자열을 만든 뒤,
4자리가 되도록 앞에 0을 채웠다.
*/

package swea.d2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5185 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            String num = st.nextToken();
            sb.append("#").append(tc+1).append(" ");

            for(int i = 0; i< num.length(); i++) {
                char c = num.charAt(i);

                int tmp = Character.digit(c, 16);

                String binary = Integer.toBinaryString(tmp);

                while(binary.length() < 4) {
                    binary = "0" + binary;
                }
                sb.append(binary);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

