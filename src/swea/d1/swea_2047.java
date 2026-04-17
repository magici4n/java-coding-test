/*
[문제]
SWEA 2047 - 신문 헤드라인

[분류]
문자열 / 구현

[접근]
- Java의 문자열 메서드 toUpperCase()를 사용해 모든 알파벳을 대문자로 변환한다.


[시간복잡도]
O(N)
- 문자열의 길이를 N이라고 하면, 각 문자를 한 번씩 확인하며 대문자로 변환하므로 O(N)이다.

[핵심 포인트]
생략

[피드백]
이 문제는 너무 쉬워서 생략
*/

package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2047 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine().toUpperCase();

        System.out.print(sentence);
    }
}
