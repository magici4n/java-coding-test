/*
[문제]
SWEA 1928 - Base64 Decoder

[분류]
문자열 / 구현 / 인코딩·디코딩

[접근]
1. Base64 문자표를 만든다.
   "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"

2. 입력 문자열의 각 문자를 Base64 문자표에서 찾는다.
   - indexOf()를 사용하면 해당 문자의 Base64 값이 나온다.

3. 해당 값을 2진수 문자열로 바꾼다.
   - 단, Base64 문자 1개는 반드시 6비트이므로 앞에 0을 채워 6자리로 맞춘다.

4. 만들어진 6비트 문자열들을 전부 이어 붙인다.

5. 이어 붙인 전체 비트 문자열을 8개씩 자른다.

6. 8비트 문자열을 10진수 ASCII 값으로 바꾼 뒤 char로 변환한다.

[시간복잡도]
O(N)

입력 문자열의 길이를 N이라고 할 때,
각 문자를 한 번씩 확인하면서 6비트 문자열로 바꾸고,
전체 비트 문자열도 8개씩 한 번만 확인하므로 O(N)이다.

indexOf()는 Base64 문자표 길이가 64로 고정되어 있으므로
상수 시간처럼 볼 수 있다.

[핵심 포인트]
1. Base64 문자 1개는 6비트이다.

예를 들어,
A → 0 → 000000
B → 1 → 000001
/ → 63 → 111111

2. Integer.toBinaryString(value)만 사용하면 안 된다.

예를 들어,
Integer.toBinaryString(1)은 "1"을 반환한다.
하지만 Base64에서는 "000001"처럼 6자리로 맞춰야 한다.

따라서 다음과 같이 앞에 0을 채워야 한다.

String binary = Integer.toBinaryString(value);
while (binary.length() < 6) {
    binary = "0" + binary;
}

3. 8비트씩 자른 문자열은 다음 코드로 10진수로 바꿀 수 있다.

int ascii = Integer.parseInt(byteString, 2);

여기서 2는 byteString을 2진수로 해석하겠다는 의미이다.

예시:
"01000001" → 65 → 'A'

4. String은 배열처럼 직접 수정할 수 없다.

잘못된 예:
String ch = "00000000";
ch[i] = "1";   // 불가능

문자열을 계속 이어 붙일 때는 StringBuilder를 사용하는 것이 좋다.

[피드백]
문제를 이해하는 것도 어렵긴 했지만
코드를 적을때 생각보다 자료형을 어떻게 받아야할지, 어떻게 변환해야 할지가
어렵게 느껴졌다. 그리고 생각보다는 list는 최대한 지양하는게 좋을 것 같다.
list를 쓰기 시작하면 항상 산으로 가는 느낌이다.
 Integer.parseInt(byteString, 2); 은 뒤에 2가 진수를 나타내는것으로 2진수를 10진수로 바꾸는 내용이라는 것을 기억하자.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class swea_1928 {
    public static void main(String[] args)throws IOException {

        String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            String input = br.readLine();

            StringBuilder bits = new StringBuilder();

            for(int i = 0; i < input.length(); i++){
                char cur = input.charAt(i);

                int value = base64.indexOf(cur);
                String binary = Integer.toBinaryString(value);

                while (binary.length() < 6) {
                    binary = "0" + binary;
                }

                bits.append(binary);
            }
            sb.append("#").append(tc+1).append(" ");
            for(int i = 0; i< bits.length(); i+=8){
                String byteString = bits.substring(i, i + 8);
                int ascii = Integer.parseInt(byteString, 2);
                sb.append((char) ascii);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
