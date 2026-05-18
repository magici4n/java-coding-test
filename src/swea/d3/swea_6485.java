/*
[문제]
SWEA 6485 - 삼성시의 버스 노선

[분류]
구현 / 배열 / 완전탐색

[접근]
각 버스 노선의 시작 정류장 A와 끝 정류장 B를 저장한다.
이후 확인해야 하는 정류장 번호가 들어올 때마다 모든 노선을 검사하면서,
해당 정류장이 A 이상 B 이하인지 확인하고 개수를 센다.

[시간복잡도]
기본 풀이: O(N * P)

N개의 노선과 P개의 정류장을 비교한다.

[핵심 포인트]
버스 노선 A B는 A번 정류장부터 B번 정류장까지 모두 포함한다.
따라서 특정 정류장 C가 해당 노선에 포함되는 조건은 다음과 같다.

A <= C <= B

[피드백]
풀이 로직은 맞다.
다만 각 노선은 시작과 끝 두 값만 가지므로 ArrayList<Integer>[]보다는
int[][] route 또는 int[] start, int[] end 배열을 쓰는 편이 더 깔끔하다.

또한 입력받는 P개의 값은 버스 번호가 아니라 정류장 번호이므로,
변수명을 bus보다는 station으로 쓰는 것이 더 명확하다.

정류장 번호 범위가 작기 때문에 stationCount 배열을 만들어
각 정류장에 몇 개의 버스가 지나는지 미리 저장하는 방식도 가능하다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_6485 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            sb.append("#").append(tc+1).append(" ");
            int N =  Integer.parseInt(br.readLine());

            ArrayList<Integer>[] list = new ArrayList[N];

            for(int i = 0; i<N; i++) {
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                list[i].add(A);
                list[i].add(B);
            }

            int P = Integer.parseInt(br.readLine());
            for(int i = 0; i < P; i++) {
                int bus = Integer.parseInt(br.readLine());
                int count = 0;
                for(int j = 0; j < N; j++) {
                    int A = list[j].get(0);
                    int B = list[j].get(1);

                    if(bus >= A && bus <=B) {
                        count++;
                    }

                }
                sb.append(count).append(" ");
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}

