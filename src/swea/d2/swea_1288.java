/*
[문제]
SWEA 1288 - 새로운 불면증 치료법

[분류]
구현 / 수학 / Set / 자리수 분리

[접근]
N의 배수를 하나씩 확인하면서 각 자리 숫자를 Set에 저장한다.
set.size() 값이 10이 되면 출력.

[시간복잡도]
각 반복마다 N * count의 자릿수를 확인한다.

숫자의 자릿수를 D라고 하면 한 번 확인하는 데 O(D)가 걸린다.
반복 횟수를 K라고 하면 전체 시간복잡도는 O(K * D)이다.

문제 제한에서는 충분히 빠르다.

[핵심 포인트]
중복된 숫자는 여러 번 세면 안 되므로 Set 사용
각 자리 숫자는 % 10과 / 10을 이용해서 분리.
set.size()가 10이 되면 모든 숫자가 등장.


[피드백]
이 문제는 배열 boolean[10]을 써도 풀 수 있음.
쉬운문제



*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class swea_1288 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc< T; tc++){
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            Set<Integer> set = new HashSet<>();

            while(set.size() < 10) {
                count++;
                int num = N*count;
                while(num>=10){
                    set.add(num % 10);
                    num /= 10;
                }
                set.add(num);
            }
            sb.append("#").append(tc+1).append(" ").append(N*count).append("\n");
        }
        System.out.print(sb);
    }
}
