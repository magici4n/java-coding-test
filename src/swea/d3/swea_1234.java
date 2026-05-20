/*
[문제]
SWEA 1234 - 비밀번호

[분류]
문자열 / 구현 / 반복 제거

[접근]
문자열에서 인접한 두 숫자가 같으면 해당 두 숫자를 제거한다.

두 숫자를 제거하면 앞뒤 문자가 새롭게 붙으면서 또 같은 숫자 쌍이 생길 수 있으므로,
한 번 제거할 때마다 다시 문자열의 처음부터 검사한다.

while문을 사용해 더 이상 제거할 수 있는 인접한 같은 숫자가 없을 때까지 반복한다.

문자열을 왼쪽부터 확인하다가 num.charAt(i)와 num.charAt(i + 1)이 같으면,
substring을 이용해 i번째 문자와 i+1번째 문자를 제외한 새 문자열을 만든다.

제거가 한 번이라도 발생하면 flag를 true로 바꾸고 for문을 빠져나온다.
한 번의 while 반복에서 제거가 발생하지 않으면 더 이상 지울 쌍이 없다는 뜻이므로 종료한다.

[시간복잡도]
O(N^2)

문자열을 검사하는 데 O(N)이 걸리고,
문자를 제거할 때 substring과 문자열 연결로 새로운 문자열을 만들기 때문에 O(N)이 걸릴 수 있다.

또한 제거가 여러 번 반복될 수 있으므로 전체적으로 O(N^2)에 가깝다.

[핵심 포인트]
1. 인접한 같은 숫자 두 개를 제거해야 한다.

if (cur == next) {
    // 제거
}

2. 문자열에서 i번째와 i+1번째 문자를 제거하려면 substring을 사용할 수 있다.

num = num.substring(0, i) + num.substring(i + 2, num.length());

3. 한 번 제거한 뒤에는 문자열 구조가 바뀐다.
따라서 바로 다음 인덱스로 넘어가지 말고, 다시 처음부터 검사하는 것이 안전하다.

if (cur == next) {
    num = num.substring(0, i) + num.substring(i + 2, num.length());
    flag = true;
    break;
}

4. flag는 이번 반복에서 제거가 발생했는지 확인하는 역할이다.

boolean flag = false;

제거가 발생하면 true로 바꾸고,
while문 한 바퀴를 돌았는데도 flag가 false라면 더 이상 제거할 숫자 쌍이 없는 것이다.

if (!flag) {
    break;
}

5. 문제는 총 10개의 테스트케이스가 주어진다.

for (int tc = 0; tc < 10; tc++) {
    ...
}

[피드백]
"스택 풀이를 생각했어야했다."

인접한 같은 숫자 쌍을 찾고,
해당 부분을 문자열에서 제거한 뒤,
다시 처음부터 검사하는 방식으로 문제를 정확히 해결했다.

특히 한 번 제거한 뒤 break를 사용해 다시 처음부터 검사하도록 한 점이 중요하다.
숫자를 제거하면 이전에는 인접하지 않았던 숫자들이 새롭게 붙을 수 있기 때문이다.

예를 들어 12344321에서 44를 제거하면 123321이 되고,
다시 33, 22, 11이 차례로 제거되어야 한다.

다만 이 풀이는 문자열을 계속 새로 만드는 방식이기 때문에
정석적인 풀이라기보다는 직접 구현 풀이에 가깝다.

이 문제의 정석 풀이는 스택을 사용하는 방식이다.
앞에서부터 문자를 하나씩 보면서,
스택의 맨 위 문자와 현재 문자가 같으면 pop,
다르면 push하는 방식으로 O(N)에 해결할 수 있다.

그래도 현재 코드는 문제 조건 안에서는 충분히 정답 가능한 풀이이며,
문제의 핵심 동작을 잘 이해하고 구현한 코드이다.

다음에 비슷한 문제가 나오면 다음 패턴을 기억하면 좋다.

인접한 값 제거
→ 최근에 들어온 값과 비교
→ 스택 사용 가능성 생각하기
*/
package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1234 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc<10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String num = st.nextToken();

            while(true) {
                boolean flag= false;
                for(int i = 0; i < num.length()-1; i++) {
                    char cur = num.charAt(i);
                    char next = num.charAt(i+1);
                    if(cur == next) {
                        num = num.substring(0,i) + num.substring(i+2,num.length());
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    break;
                }
            }
            sb.append("#").append(tc+1).append(" ").append(num).append("\n");
        }
        System.out.print(sb);
    }

}

