/*
[문제]
SWEA 1213 - String

[분류]
문자열 / 완전탐색 / 문자열 매칭

[접근]
- 찾고자 하는 문자열 target과 전체 문자열 word가 주어진다.
- word 안에서 target이 몇 번 등장하는지 세는 문제이다.
- word의 각 위치 i를 시작점으로 잡고, target 길이만큼 문자를 하나씩 비교한다.
- 모든 문자가 일치하면 count를 1 증가시킨다.
- i를 한 칸씩 이동하면서 검사하므로 겹치는 문자열도 셀 수 있다.

[시간복잡도]
- word의 길이를 N, target의 길이를 M이라고 하면
- 각 시작 위치마다 최대 M개의 문자를 비교한다.
- 전체 시간복잡도: O(N * M)

[핵심 포인트]
- contains()는 포함 여부만 true/false로 알려주기 때문에 등장 횟수를 세기에는 부족하다.
- 이 문제는 target이 word 안에 몇 번 등장하는지 세야 한다.
- 따라서 직접 문자열을 비교하거나 indexOf()를 반복해서 사용해야 한다.
- 직접 비교할 경우 검사 가능한 시작 위치는 0부터 word.length() - target.length()까지이다.
- 겹치는 경우도 세야 하므로 시작 인덱스를 한 칸씩 증가시키는 방식이 적절하다.
  예: target = "aa", word = "aaa"이면 정답은 2

[피드백]
- 직접 charAt()으로 비교한 방식은 정석적인 완전탐색 문자열 매칭 풀이이다.
- for문의 범위를 word.length() - target.length()까지 잡은 점이 좋다.
- 겹치는 문자열도 자연스럽게 처리할 수 있다.
- 첫 글자가 같은 경우에만 내부 반복문을 돌린 것도 가능하다.
- 다만 내부 반복문에서 어차피 j = 0부터 비교하므로 첫 글자 if문은 생략해도 된다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1213 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 0 ; tc < 10; tc++) {
            int T = Integer.parseInt(br.readLine());
            String target = br.readLine();
            String word = br.readLine();
            int count = 0;
            for(int i = 0; i<=word.length() - target.length(); i++) {
                boolean flag = true;
                if(word.charAt(i)==target.charAt(0)) {
                    for(int j = 0 ; j < target.length(); j++) {
                        if(word.charAt(i+j)!=target.charAt(j)) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        count++;
                    }
                }
            }
            sb.append("#").append(tc+1).append(" ").append(count).append("\n");
        }
        System.out.print(sb);
    }

}
