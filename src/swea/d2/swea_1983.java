/*
[문제]
SWEA 1983 - 조교의 성적 매기기

[분류]
구현 / 배열 / 정렬

[접근]
각 학생의 중간, 기말, 과제 점수를 비율에 맞게 반영한 총점으로 계산했다.
K번째 학생의 총점을 따로 저장한 뒤, 전체 총점 배열을 정렬하고 해당 점수의 위치를 찾아
전체 구간을 10등분하여 학점을 판별했다.

[시간복잡도]
O(N log N)

[핵심 포인트]
- 총점은 중간 35%, 기말 45%, 과제 20% 반영
- K번째 학생의 총점은 정렬 전에 따로 저장해야 함
- 전체 학생 점수를 정렬한 뒤 K 학생의 위치를 찾음
- 학점은 전체를 10구간으로 나누어 판별
- 이 문제는 동점이 없다는 조건이 중요함

[피드백]
다만 scores 2차원 배열은 없이 입력받으면서 바로 총점을 계산해도 된다.
또 binarySearch 또한 과함.
이제 문제푸는 능력은 생겼지만 최적풀이도 생각하면서 풀어보는게 좋을 것 같다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1983 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int [][] scores = new int[N][3];

            //학생들 점수 넣기
            for(int i = 0 ; i<N; i++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for(int j = 0; j<3; j++){
                    scores[i][j] = Integer.parseInt(st1.nextToken());
                }
            }

            int []student = new int[N];
            for(int i = 0; i<N; i++){
                student[i] = scores[i][0]*35+scores[i][1]*45 + scores[i][2]*20;
            }
            int value = student[K-1];
            Arrays.sort(student);
            int Index = Arrays.binarySearch(student,value);
            Index = (int)Math.ceil(((Index+1)/(double)N * 10));

            sb.append("#").append(tc+1).append(" ");
            switch(Index){
                case 1:
                    sb.append("D0");
                    break;
                case 2:
                    sb.append("C-");
                    break;
                case 3:
                    sb.append("C0");
                    break;
                case 4:
                    sb.append("C+");
                    break;
                case 5:
                    sb.append("B-");
                    break;
                case 6:
                    sb.append("B0");
                    break;
                case 7:
                    sb.append("B+");
                    break;
                case 8:
                    sb.append("A-");
                    break;
                case 9:
                    sb.append("A0");
                    break;
                case 10:
                    sb.append("A+");
                    break;
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
