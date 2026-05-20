/*
[문제]
SWEA 1240 - 단순 2진 암호코드

[분류]
구현 / 문자열 / 배열 / 암호 해독 / 패턴 매칭

[접근]
입력으로 N x M 크기의 2진 코드 배열이 주어진다.
암호코드는 총 56자리이며, 7자리씩 끊으면 총 8개의 숫자로 해독할 수 있다.

각 숫자는 정해진 7비트 패턴을 가진다.

0 -> 0001101
1 -> 0011001
2 -> 0010011
3 -> 0111101
4 -> 0100011
5 -> 0110001
6 -> 0101111
7 -> 0111011
8 -> 0110111
9 -> 0001011

암호코드가 있는 행에서 마지막 1의 위치를 찾는다.
암호코드는 56자리이므로, 마지막 1의 위치 index를 기준으로
index - 55부터 index까지 substring으로 잘라낸다.

잘라낸 56자리 문자열을 7자리씩 나누고,
각 7자리 패턴이 nums 배열의 어느 값과 같은지 비교해서 숫자로 변환한다.

이후 검증식을 계산한다.

(홀수 번째 자리의 합 * 3) + (짝수 번째 자리의 합)

문제에서 말하는 홀수 번째 자리는 1-based 기준이므로,
자바 배열에서는 index 0, 2, 4, 6에 해당한다.

검증식 결과가 10의 배수라면 정상 암호코드이므로
해독한 8개 숫자의 합을 출력한다.

정상 암호코드가 아니라면 0을 출력한다.

[시간복잡도]
O(N * M + 8 * 10)

암호코드가 있는 행을 찾기 위해 N개의 행과 M개의 열을 확인하므로 O(N * M)이다.
이후 56자리 암호코드를 7자리씩 8번 나누고,
각 패턴을 10개의 숫자 패턴과 비교하므로 O(8 * 10)이 걸린다.

따라서 전체 시간복잡도는 O(N * M)으로 볼 수 있다.

[핵심 포인트]
1. 암호코드는 총 56자리이다.

2. 각 숫자는 7자리 이진 문자열로 표현된다.

3. 암호코드는 오른쪽 끝이 1로 끝나므로,
   한 행에서 마지막 1의 위치를 찾으면 암호코드의 끝을 알 수 있다.

4. 마지막 1의 위치가 index라면 암호코드는 다음 범위이다.

   bit.substring(index - 55, index + 1)

5. substring(a, b)는 a 이상 b 미만 범위를 자른다.
   따라서 index 위치까지 포함하려면 index + 1을 써야 한다.

6. 문제의 홀수 번째 자리는 1-based 기준이다.
   자바 배열 기준으로는 0, 2, 4, 6번 인덱스가 홀수 번째 자리에 해당한다.

7. 검증식은 다음과 같다.

   (decode[0] + decode[2] + decode[4] + decode[6]) * 3
   + decode[1] + decode[3] + decode[5] + decode[7]

8. 검증식 결과가 10으로 나누어떨어지면 정상 암호코드이다.

[피드백]
전체적인 풀이 흐름은 좋다.
암호코드가 있는 행을 찾고, 마지막 1의 위치를 기준으로 56자리를 잘라낸 뒤,
7자리씩 해독하는 방식은 이 문제의 정석적인 접근이다.

처음 코드에서는 index를 행마다 초기화하지 않아서,
암호코드가 있는 행을 찾은 뒤 다음 행이 모두 0이어도 이전 index 값으로 인해
code가 잘못 덮어씌워질 수 있었다.

수정한 코드에서는 각 행마다 int index = -1로 초기화했기 때문에
이 문제가 해결되었다.

검증식에서도 문제의 홀수 번째 자리를 자바 배열 인덱스 기준으로
0, 2, 4, 6으로 처리한 부분이 정확하다.

1. 암호코드가 있는 행 찾기
2. 마지막 1의 위치 찾기
3. 56자리 암호코드 추출하기
4. 7자리씩 나누어 숫자로 변환하기
5. 검증식 계산하기
6. 정상 여부에 따라 출력하기
*/
package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1240 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        String [] nums = {
                "0001101", //0
                "0011001", //1
                "0010011", //2
                "0111101", //3
                "0100011", //4
                "0110001", //5
                "0101111", //6
                "0111011", //7
                "0110111", //8
                "0001011"  //9
        };

        for(int tc = 0; tc <T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int [] decode = new int[8];
            int decode_count = 0;

            String code = "";
            for(int i = 0; i < N; i++) {
                String bit = br.readLine();
                int index = -1;
                for(int j = 0; j < M; j++) {
                    if(bit.charAt(j) == '1') {
                        index = j;
                    }
                }
                if(index != -1) {
                    code = bit.substring(index-55, index+1);
                }
            }

            for(int i = 0; i < 56; i+=7) {
                for(int j = 0; j < 10; j++) {
                    if(nums[j].equals(code.substring(i,i+7))) {
                        decode[decode_count] = j;
                        decode_count++;
                        break;
                    }
                }
            }
            int sum = 0;
            for(int i = 0; i< 8; i+=2) {
                sum+=decode[i];
            }
            sum*=3;
            for(int i = 1; i < 8; i+=2) {
                sum+=decode[i];
            }
            sb.append("#").append(tc+1).append(" ");
            if(sum%10 == 0) {
                sum = 0;
                for(int i = 0; i< 8; i++) {
                    sum+= decode[i];
                }
                sb.append(sum).append("\n");
            }else {
                sb.append(0).append("\n");
            }

        }
        System.out.print(sb);
    }
}

