/*
[문제]
BOJ 1157 - 단어 공부

[분류]
구현 / 문자열 / 배열

[접근]
입력받은 문자열을 대문자로 통일한 뒤, 알파벳의 등장 횟수를 카운트 하기 위해 킉가 26인 배열을 만들었다.
이후 배열을 순회하면서 알파벳에 해당하는 index에 ++를 해주고 마지막에 알파벳 등장 횟수 비교를 위해 순회를 한 뒤 출력하였다.
[시간복잡도]
O(N) - 입력 문자열 길이가 N이라고 했을 때 O(N)

[핵심 포인트]
문자열을 전부 대문자로 바꾸는 .toUpperCase()
알파벳 개수는 int [] = new int[26]으로 관리

[피드백]
알파벳의 등장 횟수를 어떻게 처리해야할지 고민이 많았던 것 같다.
조금 더 단순하게 생각하는 방식도 필요한 것 같다.
*/

package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1157 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();

        int [] count = new int[26];

        for(int i = 0; i< word.length(); i++){
           char ch = word.charAt(i);
           count[ch - 'A']++;
        }

        int max = -1;
        char result = '?';

        for(int i = 0; i<26; i++){
            if (count[i] > max){
                max = count[i];
                result = (char)(i+'A');
            }else if(count[i] == max){
                result = '?';
            }
        }
        System.out.println(result);
    }
}
