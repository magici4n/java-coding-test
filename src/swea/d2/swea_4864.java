/*
[문제]
SWEA 4864 - 문자열 비교

[분류]
문자열 / 구현 / 완전탐색

[접근]
str2 안에 str1이 포함되어 있는지 확인하는 문제이다.
str2의 각 인덱스를 시작 위치로 잡고, str1의 문자들과 하나씩 비교한다.
str1의 모든 문자가 현재 위치에서 연속으로 일치하면 answer를 1로 바꾸고 탐색을 종료한다.
끝까지 일치하는 구간을 찾지 못하면 answer는 0으로 유지된다.

[시간복잡도]
O(N * M)

N = str2의 길이
M = str1의 길이

str2의 각 시작 위치마다 str1의 길이만큼 비교할 수 있으므로 O(N * M)이다.

[핵심 포인트]
1. 마지막 가능한 시작 위치까지 검사해야 하므로
   i <= str2.length() - str1.length() 조건을 사용한다.

2. 문자열 전체가 일치했을 때만 answer = 1로 바꾼다.

3. charAt()으로 문자를 하나씩 비교할 수 있다.

4. str1.charAt(j)와 str2.charAt(i + j)를 비교한다.

[피드백]
처음 풀이에서는 반복문 조건이 i < str2.length() - str1.length()라서
마지막 시작 위치를 검사하지 못하는 문제가 있었다.

str2.contains(str1)을 사용할 수도 있었다.
*/
package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_4864 {

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            String str1 = br.readLine();
            String str2 = br.readLine();


            int answer = 0;

            for(int i = 0; i<= str2.length()- str1.length(); i++) {
                int count = str1.length();
                if(str1.charAt(0) == str2.charAt(i)) {
                    for(int j = 0; j<str1.length(); j++) {
                        if(str1.charAt(j) == str2.charAt(i+j)) {
                            count--;
                        }
                    }
                    if(count == 0) {
                        answer = 1;
                        break;
                    }
                }
            }
            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
