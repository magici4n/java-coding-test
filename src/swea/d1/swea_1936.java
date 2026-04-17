/*
[문제]
SWEA 1936 - 1대1 가위바위보

[분류]
구현 / 조건문 / switch-case

[접근]
switch-case문 사용하여 조건 비교

[시간복잡도]
O(1)
- 입력값 2개만 비교하므로 입력 크기와 관계없이 일정한 시간이 걸린다.

[핵심 포인트]
- 문자열 비교는 ==가 아니라 equals()를 사용해야 한다.


[피드백]
- 출력이 한 글자뿐이므로 StringBuilder는 필수는 아니다.

더 깔끔한 풀이는 숫자로 입력 받은 뒤
if ((A == 1 && B == 3) ||
    (A == 2 && B == 1) ||
    (A == 3 && B == 2)) {
        System.out.print("A");
        } else {
            System.out.print("B");
        }
 이런식으로 가능.

*/

package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1936 {
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        //switch case문 또는 if-else문  //1:가위 2:바위 3:보
        String A = st.nextToken();
        String B = st.nextToken();
        switch(A){
            case "1":
                if(B.equals("2")){
                    sb.append("B");
                }else{
                    sb.append("A");
                }
                break;
            case "2":
                if(B.equals("1")){
                    sb.append("A");
                }else{
                    sb.append("B");
                }
                break;
            case "3":
                if(B.equals("1")){
                    sb.append("B");
                }else{
                    sb.append("A");
                }
                break;
        }
        System.out.print(sb);
    }
}
