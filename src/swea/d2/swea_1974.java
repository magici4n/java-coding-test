/*
[문제]
SWEA 1974 - 스도쿠 검증

[분류]
구현 / 배열 / 완전탐색

[접근]
- 9x9 스도쿠 판을 입력 뒤 map[9][9]로 만든다.
  1. 각 가로줄에 1~9가 중복 없이 나와야 하고
  2. 각 세로줄에 1~9가 중복 없이 나와야 하고
  3. 각 3x3 칸에 1~9가 중복 없이 나와야 한다.
- 각 검사마다 boolean[] check 배열을 새로 만들어
  숫자가 이미 등장했는지 확인한다.
- 중복이 발견되면 flag = 0으로 처리한다.

[시간복잡도]
- 테스트케이스마다 9x9 범위를 몇 번 검사하므로 O(1)에 가깝다.
- 고정 크기 배열이라 사실상 상수 시간 처리

[핵심 포인트]
- 중복 검사는 boolean[] check 사용
- 가로 / 세로 / 3x3을 각각 독립적으로 검사
- 3x3 검사는 시작점을 (0,0), (0,3), (0,6), (3,0) ... 처럼 잡아서 탐색

[피드백]
- 이번 문제는 혼자 풀지 못했다.
- boolean[] check를 이용한 중복 검사 아이디어를 스스로 떠올리지 못했다.
- 가로 / 세로 / 3x3을 각각 검사하는 구조도 해설을 참고했다.
- 따라서 이 문제는 '힌트를 보고 이해한 문제'로 분류하는 것이 맞다.
- 그치만 해설을 보고 내가 충분히 할 수있었는데 이게 맞나? 라는 생각 때문에 실행에 옮기지 못했다.
- 어차피 못 풀거면 그냥 코드로 적어보자. 그리고 후회하자.
*/
package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1974 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        //테스트 케이스 수만큼 반복
        for(int i = 0; i<T; i++){
            int flag = 1;
            int map[][] = new int[9][9];

            //스도쿠 만들기
            for(int j = 0; j<9; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k<9; k++){
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            //가로줄 검사
            for(int a = 0; a<9; a++){
               boolean[] check = new boolean[10];
               for(int b = 0; b<9; b++){
                   int num = map[a][b];
                   if(check[num]){
                       flag = 0;
                       break;
                   }
                   check[num] = true;
               }
               if(flag==0) break;
            }



            //세로줄 검사
            if(flag==1 ) {
                for (int b = 0; b < 9; b++) {
                    boolean[] check = new boolean[10];
                    for(int a=0; a<9; a++){
                        int num = map[a][b];
                        if(check[num]){
                            flag=0;
                            break;
                        }
                        check[num] = true;
                    }
                    if(flag==0) break;
                }

            }

            if(flag == 1){
                for(int a = 0; a<9; a+=3){
                    for(int b = 0; b<9; b+=3){
                        boolean[] check = new boolean[10];

                        for(int x = a; x < a+3; x++){
                            for(int y = b; y< b+3; y++){
                                int num = map[x][y];
                                if(check[num]){
                                    flag=0;
                                    break;
                                }
                                check[num] = true;
                            }
                            if (flag == 0) break;
                        }
                        if (flag == 0) break;
                    }
                    if (flag == 0) break;
                }
            }
            sb.append("#").append(i+1).append(" ").append(flag).append("\n");
        }
        System.out.print(sb);
    }
}
