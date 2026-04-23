/*
[문제]
SWEA 2005 - 파스칼의 삼각형

[분류]
구현 / 배열

[접근]
각 줄의 양 끝은 항상 1이고,
가운데 값은 바로 윗줄의 왼쪽 값과 같은 위치 값을 더해서 만든다.
2차원 배열을 사용해서 이전 줄 값을 참고하며 삼각형을 채운 뒤, 각 줄마다 필요한 부분만 출력한다.

[시간복잡도]
O(N^2)

[핵심 포인트]
- 양 끝 값은 항상 1
- 가운데 값은 arr[i - 1][j - 1] + arr[i - 1][j]
- 2차원 배열에서 현재 줄 i는 0 ~ i 까지만 사용
- 출력도 j <= i 범위만 하면 됨
- 이 문제는 가변 자료구조보다 인덱스 접근이 더 중요해서 ArrayList보다 배열이 편함

[피드백]
처음에 줄마다 길이가 다르다는 점 때문에 2차원 ArrayList를 떠올렸는데,
이 문제는 원소 추가/삭제가 중요한 문제가 아니라 이전 위치를 인덱스로 참조하는 문제가 핵심이었다.
그래서 자료구조를 먼저 고민하기보다
"현재 값이 이전 값으로부터 어떻게 만들어지는가"를 먼저 봤어야 했다.
즉, 이 문제의 핵심은 가변 크기 자료구조가 아니라
배열에서 규칙을 식으로 옮기는 것이었다.
다음에는 문제를 보면 먼저
1) 크기가 고정인지
2) 이전 인덱스를 참조하는지
3) 추가/삭제가 필요한지
이 세 가지를 보고 배열/리스트를 결정하자.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2005 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        //테스트 케이스 반복
        for(int tc = 0; tc<T; tc++){

            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                arr[i][0] = 1;
                arr[i][i] = 1;

                for (int j = 1; j < i; j++) {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
            sb.append("#").append(tc+1).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
