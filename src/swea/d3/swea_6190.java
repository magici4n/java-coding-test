/*
[문제]
SWEA 6190 - 정곤이의 단조 증가하는 수

[분류]
브루트포스 / 구현 / 숫자 자릿수 처리

[접근]
- N개의 수 중 서로 다른 두 수를 골라 곱한다.
- 모든 i, j 조합을 확인해야 하므로 이중 반복문을 사용한다.
- 곱한 값이 단조 증가하는 수인지 확인한다.
- 단조 증가하는 수라면 후보에 저장하고, 그중 최댓값을 구한다.
- 단조 증가하는 수가 하나도 없다면 -1을 출력한다.

[시간복잡도]
- 두 수의 조합 확인: O(N^2)
- 각 곱의 자릿수 검사: O(log M)
- 전체 시간복잡도: O(N^2 log M)
  여기서 M은 두 수를 곱한 값이다.

[핵심 포인트]
- 단조 증가 수는 각 자릿수가 왼쪽에서 오른쪽으로 갈수록 작아지면 안 된다.
  예: 123, 135, 222는 가능 / 321, 132는 불가능
- 숫자를 오른쪽부터 검사할 경우,
  현재 자릿수(tmp)가 그 왼쪽 자릿수(n % 10)보다 작으면 단조 증가가 아니다.
- flag는 곱 하나를 검사할 때마다 새로 true로 초기화해야 한다.
- 이전 곱의 검사 결과가 다음 곱에 영향을 주면 안 된다.

[피드백]
- 처음에는 두 자리 수 기준으로만 검사해서 3자리 이상의 단조 증가 수를 놓쳤다.
- 이후 자릿수 전체를 검사하도록 수정한 점은 좋다.
- flag 위치를 j 반복문 안으로 옮긴 것도 핵심 수정이다.
- 현재 풀이도 정답 풀이로 볼 수 있다.
- 다만 danzo 배열에 저장한 뒤 다시 최댓값을 찾기보다는,
  단조 증가 수를 발견할 때마다 result를 바로 갱신하면 더 깔끔하다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_6190 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for(int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int [] nums = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i< N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            int [] danzo = new int[N*(N-1)];
            int count = 0;

            for(int i = 0; i< N-1; i++) {
                int a = nums[i];
                for(int j = i+1; j < N; j++) {
                    boolean flag = true;
                    int b = nums[j];
                    int n = a*b;

                    while(true) {
                        int tmp = n%10;
                        n = n/10;
                        if(tmp < n%10) {
                            flag= false;
                            break;
                        }
                        if(n <10) {
                            break;
                        }

                    }
                    if(flag) {
                        danzo[count] = a*b;
                        count++;
                    }

                }
            }
            int result=0;

            if(count == 0) {
                result = -1;
            }else {
                for(int i = 0; i<N*(N-1); i++) {
                    result = Math.max(result, danzo[i]);
                }
            }
            sb.append("#").append(tc+1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}
