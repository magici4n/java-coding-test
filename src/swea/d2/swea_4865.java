/*
[문제]
SWEA 4865 – 글자수

[분류]
문자열 / 구현 / 빈도 카운팅 / 브루트포스

[접근]
str1에 포함된 문자들 중에서,
str2에 가장 많이 등장하는 문자의 개수를 구하는 문제이다.

내 풀이에서는 str1의 문자를 하나씩 꺼낸 뒤,
str2 전체를 순회하면서 해당 문자가 몇 번 등장하는지 세었다.

각 문자마다 count를 구하고,
그중 최댓값을 max에 저장했다.

[시간복잡도]
O(str1.length() * str2.length())

str1의 각 문자마다 str2 전체를 한 번씩 확인하므로
이중 반복문 구조이다.

문제의 입력 크기가 작기 때문에 이 방식으로도 충분히 통과 가능하다.

[핵심 포인트]
- str1은 검사할 문자들의 집합 역할을 한다.
- str2에서 해당 문자가 몇 번 등장하는지 세면 된다.
- 각 문자별 count 중 최댓값을 구한다.
- max의 초기값은 Integer.MIN_VALUE보다는 0이 더 자연스럽다.
  등장 횟수는 음수가 될 수 없기 때문이다.

[피드백]
내 풀이는 문제 의도에 맞게 잘 접근한 브루트포스 풀이이다.

str1의 문자 하나를 기준으로 str2를 전부 확인하는 방식이라
직관적이고 이해하기 쉽다.

다만 str1에 중복 문자가 있는 경우,
같은 문자를 여러 번 다시 검사할 수 있다.

예를 들어 str1이 "ABA"라면
A를 두 번 검사하게 된다.

정답에는 문제가 없지만,
더 효율적으로 풀려면 str2의 문자 개수를 미리 배열에 저장한 뒤,
str1의 문자에 해당하는 개수만 확인하면 된다.

개선 방향:
1. str2의 각 문자 빈도를 count 배열에 저장한다.
2. str1의 문자를 돌면서 count[문자] 값의 최댓값을 구한다.

현재 풀이는 정답 가능한 풀이이고,
입력 크기가 작은 SWEA D2 수준에서는 충분히 괜찮은 접근이다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_4865 {

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            String str1 = br.readLine();
            String str2 = br.readLine();
            int max = Integer.MIN_VALUE;
            for(int i =0; i< str1.length(); i++) {
                int count = 0;
                char c = str1.charAt(i);
                for(int j = 0; j < str2.length(); j++) {
                    if(c == str2.charAt(j)) {
                        count++;
                    }
                }
                max = Math.max(count, max);
            }
            sb.append("#").append(tc+1).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
}
