/*
[문제]
SWEA 1989 - 초심자의 회문 검사

[분류]
구현 / 문자열 / 덱

[접근]
문자열의 각 문자를 덱에 넣고,
앞쪽 문자와 뒤쪽 문자를 하나씩 꺼내 비교하는 방식으로 회문 여부를 판별했다.
중간 지점까지만 비교하고, 하나라도 다르면 결과를 0으로 처리했다.

[시간복잡도]
O(N)

[핵심 포인트]
- 회문은 양 끝 문자를 비교하면서 확인할 수 있음
- 전체 길이의 절반만 비교하면 충분함
- 덱을 사용하면 앞/뒤 문자 비교가 가능함
- 하나라도 다르면 바로 종료 가능

[피드백]
회문 판별 로직 자체는 정확하게 잘 구현했다.
다만 이 문제는 덱까지 사용할 필요 없이
문자열의 앞 인덱스와 뒤 인덱스를 직접 비교하는 방식이 더 간단하고 효율적이다.
현재 풀이는 O(N) 시간으로 맞지만, 덱을 사용해서 추가 공간 O(N)이 필요하다.
다음에는 "이 문제에 자료구조가 꼭 필요한가?"를 한 번 더 생각해보고,
가능하면 charAt()으로 양 끝을 바로 비교하는 더 단순한 풀이도 떠올려보자.
*/
package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class swea_1989 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            String word = br.readLine();
            int result = 1;
            Deque<Character> dq = new ArrayDeque<>();

            for(int i = 0; i<word.length(); i++){
                dq.push(word.charAt(i));
            }

            for(int j = 0; j<word.length()/2; j++){
                if(dq.pollLast() != dq.pollFirst()){
                    result = 0;
                    break;
                }
            }
            sb.append("#").append(tc+1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}
