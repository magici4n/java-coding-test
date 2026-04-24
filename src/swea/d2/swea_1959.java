/*
[문제]
SWEA 1959 - 두 개의 숫자열

[분류]
구현 / 배열 / 완전탐색

[접근]
길이가 더 짧은 배열을 긴 배열 위에서 한 칸씩 이동시키면서,
겹치는 원소끼리 곱한 합을 구했다.
각 위치에서 나온 곱의 합들 중 최댓값을 정답으로 구했다.

[시간복잡도]
O((N-M+1) * M) 또는 O((M-N+1) * N)
- 결국 짧은 배열 길이만큼 곱셈을 하면서 가능한 시작 위치를 모두 탐색

[핵심 포인트]
- 더 짧은 배열을 긴 배열에 맞춰 한 칸씩 이동
- 각 위치마다 겹치는 원소끼리 곱한 합 계산
- 최댓값을 구하는 문제이므로 매번 max 갱신 가능
- 배열 길이가 같을 때도 한 번만 계산하면 됨
- 범위는 시작 위치가 0부터 (긴 배열 길이 - 짧은 배열 길이)까지

[피드백]
각 위치의 결과를 value 배열에 모두 저장할 필요는 없고,
계산하면서 바로 최댓값을 갱신하면 더 간단하게 구현할 수 있다.
->  max = Math.max(max, sum); 이런 코드를 앞으로 쓰면 좋을 것 같음.

또한 if/else 내부 로직이 거의 동일하므로,
긴 배열과 짧은 배열을 먼저 정리해두면 중복을 줄일 수 있다.
전체적으로는 잘 푼 풀이이고, 중간 저장과 코드 중복을 줄이면 더 좋은 코드가 된다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1959 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int [] A = new int[N];
            int [] B = new int[M];

            StringTokenizer stA = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                A[i] = Integer.parseInt(stA.nextToken());
            }

            StringTokenizer stB = new StringTokenizer(br.readLine());
            for(int i = 0; i<M; i++){
                B[i] = Integer.parseInt(stB.nextToken());
            }

            sb.append("#").append(tc+1).append(" ");
            if(A.length >= B.length){
                int [] value = new int[A.length - B.length+1];
                for(int i =0; i<=A.length-B.length; i++){
                    int sum  = 0;
                    for(int j = 0 ; j<B.length; j++){
                        sum+= B[j]*A[i+j];
                    }
                    value[i] = sum;
                }
                int Max= Integer.MIN_VALUE;
                for(int i =0; i<value.length; i++){
                    if(value[i]>Max){
                        Max=value[i];
                    }
                }
                sb.append(Max);
            }else{
                int [] value = new int[B.length - A.length+1];
                for(int i =0; i<=B.length-A.length; i++){
                    int sum  = 0;
                    for(int j = 0 ; j<A.length; j++){
                        sum+= A[j]*B[i+j];
                    }
                    value[i] = sum;
                }
                int Max= Integer.MIN_VALUE;
                for(int i =0; i<value.length; i++){
                    if(value[i]>Max){
                        Max=value[i];
                    }
                }
                sb.append(Max);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
