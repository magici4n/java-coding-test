/*
[문제]
SWEA 2007 - 패턴 마디의 길이

[분류]
구현 / 문자열

[접근]
문자열의 앞부분을 길이 1부터 10까지 하나씩 잘라서 패턴 후보로 두고,
그 바로 다음 구간이 같은 문자열인지 비교했다.
처음으로 앞부분과 다음 부분이 같아지는 길이를 정답으로 처리했다.

[시간복잡도]
O(1)
- 마디 길이를 1부터 10까지만 확인하므로 사실상 상수 시간
- substring과 equals를 포함해도 문제 조건에서는 매우 작은 범위

[핵심 포인트]
- substring(0, i+1) : 길이 i+1인 앞 패턴 추출
- substring(i+1, 2*i+2) : 바로 다음 같은 길이 구간 추출
- 두 문자열이 equals()로 같으면 그 길이가 마디 길이
- 이 문제는 비교 길이가 같아야 하므로 인덱스 범위를 정확히 잡는 것이 중요함
- 입력 조건상 마디 길이는 10 이하라는 점을 이용

[피드백]
앞부분 패턴과 바로 다음 구간을 비교해서 마디 길이를 찾는 핵심 접근은 맞았다.
substring 인덱스도 올바르게 잘 잡았고, equals를 사용한 문자열 비교도 적절하다.
다만 변수명 mady는 pattern 처럼 더 직관적으로 쓰는 것이 좋다.
또한 이 풀이는 "앞의 두 구간이 같은가"를 확인하는 방식이라,
일반적인 문자열 패턴 검증 문제에서는 전체 반복 여부까지 확인해야 할 수도 있다는 점은 기억해두자.
하지만 SWEA 2007 문제 조건에서는 충분히 통과 가능한 풀이이다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2007 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            String sentence = br.readLine();
            int answer = 0;
            for(int i = 0; i<10;i++){
                String mady = sentence.substring(0,i+1);
                if(sentence.substring(i+1,2*i+2).equals(mady)){
                    answer = mady.length();
                    break;
                }
            }
            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
