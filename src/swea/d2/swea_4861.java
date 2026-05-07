/*
[문제]
SWEA 4861 - 회문

[분류]
구현 / 문자열 / 배열 / 완전탐색

[접근]
N x N 글자판에서 길이가 M인 회문을 찾는 문제이다.
가로 방향에서 가능한 모든 시작 위치를 검사하고,
찾지 못하면 세로 방향에서 가능한 모든 시작 위치를 검사한다.

회문 검사는 양끝 문자부터 서로 비교한다.
길이가 M인 문자열에서 앞쪽 k번째 문자와 뒤쪽 k번째 문자를 비교하여
모든 쌍이 같으면 회문으로 판단한다.

가로에서 회문을 찾으면 행과 시작 열을 저장하고,
세로에서 회문을 찾으면 열과 시작 행을 저장한 뒤
길이 M만큼 출력한다.

[시간복잡도]
O(N^2 * M)

가로 검사에서 최대 N * (N - M + 1)개의 후보를 확인하고,
각 후보마다 최대 M / 2번 비교한다.
세로도 같은 방식으로 검사하므로 전체 시간복잡도는 O(N^2 * M)이다.

[핵심 포인트]
- 길이가 M인 부분 문자열만 검사해야 한다.
- 시작 위치 j의 범위는 0부터 N - M까지이다.
- 회문 검사는 전체 문자를 다 볼 필요 없이 양끝부터 M / 2번만 비교하면 된다.
- count는 후보 문자열 하나를 검사할 때마다 초기화해야 한다.
- 출력할 때는 N까지가 아니라 M글자만 출력해야 한다.
- 가로일 때는 x = 행, y = 시작 열
- 세로일 때는 x = 열, y = 시작 행

[피드백]
풀이 방식 자체는 모든 가능한 위치를 확인하는 완전탐색 방식으로,
SWEA 4861 문제의 정석적인 풀이이다.
다만 count를 세는 방식보다 boolean isPalindrome을 사용하면
문자가 하나라도 다를 때 바로 중단할 수 있어 더 깔끔하게 작성할 수 있다.
*/

package swea.d2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4861 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char [][]map = new char[N][N];

            for(int i = 0; i<N; i++) {
                String sentence = br.readLine();
                sentence = sentence.toUpperCase();
                for(int j = 0; j < N; j++) {
                    map[i][j] = sentence.charAt(j);
                }
            }

            int x = 0;
            int y = 0;
            int v = 0;
            boolean flag = false;
            // 가로 검사
            for(int i = 0; i<N; i++) {
                for(int j = 0; j <= N-M; j++) {
                    int count = 0;
                    for(int k =0; k < M/2; k++) {
                        if(map[i][j+k] == map[i][j+M-1-k]) {
                            count++;
                        }
                    }
                    if(count == M/2) {
                        x = i;
                        y = j;
                        v = 1;
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    break;
                }
            }


            // 세로 검사
            for(int i = 0; i<N; i++) {
                if(flag) {
                    break;
                }
                for(int j = 0; j <= N-M; j++) {
                    int count = 0;
                    for(int k =0; k < M/2; k++) {
                        if(map[j+k][i] == map[j+M-1-k][i]) {
                            count++;
                        }
                    }
                    if(count == M/2) {
                        x = i;
                        y = j;
                        flag = true;
                        break;
                    }
                }
            }
            sb.append("#").append(tc+1).append(" ");


            if(v==1) {
                for(int i = y; i <y +M; i++) {
                    sb.append(map[x][i]);
                }

            }else {
                for(int i = y; i <y + M; i++) {
                    sb.append(map[i][x]);
                }
            }
            sb.append("\n");

        }
        System.out.print(sb);
    }
}

