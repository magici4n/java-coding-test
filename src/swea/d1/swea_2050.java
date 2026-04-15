/*
[문제]
SWEA 2050 - 알파벳을 숫자로 변환

[분류]
구현 / 문자열 / 문자 연산

[접근]
입력받은 문자열을 한 글자씩 확인한다.
A부터 Z까지 리스트에 저장한 뒤, 현재 문자의 indexOf() 값을 찾아 +1 해서 출력한다.

[시간복잡도]
O(N * 26)
N: 입력 문자열 길이

[핵심 포인트]
문자 하나 꺼내기:
words.charAt(i)

ArrayList에서 값의 위치 찾기:
list.indexOf(words.charAt(i))

알파벳 번호는 인덱스 + 1이다.

[피드백]
또한 알파벳은 문자 코드가 순서대로 되어 있어서
리스트를 만들지 않고 다음처럼 바로 계산할 수 있다.
words.charAt(i) - 'A' + 1

.charAt()과.indexOf() 기억하기
*/

package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class swea_2050 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char a = 'a';
        List<Character> list = new ArrayList<>();
        for(int i= 0; i<26; i++){
            list.add(a);
            a++;
        }

        String words = br.readLine().toLowerCase();

        for(int i = 0; i<words.length(); i++){
            sb.append(list.indexOf((words.charAt(i)))+1);
            if(i != words.length()-1){
                sb.append(" ");
            }
        }
        System.out.print(sb);

    }
}
