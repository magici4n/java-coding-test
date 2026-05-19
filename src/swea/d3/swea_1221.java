/*
[문제]
SWEA 1221 - GNS

[분류]
구현 / 문자열 / 카운팅 정렬

[접근]
문제에서 주어진 숫자 문자열의 순서는 다음과 같다.

ZRO ONE TWO THR FOR FIV SIX SVN EGT NIN

일반 문자열 정렬을 사용하면 사전순으로 정렬되기 때문에 문제에서 원하는 순서가 나오지 않는다.
따라서 각 숫자 문자열이 몇 번 등장했는지 count 배열에 저장한 뒤,
정해진 순서대로 개수만큼 출력한다.

num 배열에는 문제에서 정한 숫자 문자열 순서를 저장한다.

String[] num = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

입력받은 문자열 n이 num[j]와 같으면 count[j]를 증가시킨다.
모든 입력을 확인한 뒤, count 배열을 0번부터 9번까지 순회하면서
각 문자열을 저장된 개수만큼 출력한다.

[시간복잡도]
O(N)

입력받은 N개의 문자열을 확인한다.
각 문자열마다 num 배열 10개를 비교하므로 정확히는 O(10N)이지만,
10은 고정된 상수이므로 O(N)으로 볼 수 있다.

[핵심 포인트]
1. 이 문제는 일반 정렬 문제가 아니라 카운팅 정렬 문제로 볼 수 있다.

2. 문자열의 순서가 문제에서 따로 정해져 있으므로 Arrays.sort()를 사용하면 안 된다.

3. int[] count = new int[10]; 으로 배열을 만들면 모든 값은 자동으로 0으로 초기화된다.

4. count[i]는 num[i] 문자열이 몇 번 등장했는지를 의미한다.

   count[0] → ZRO의 개수
   count[1] → ONE의 개수
   count[2] → TWO의 개수
   ...

5. 출력할 때는 num 배열 순서대로 count[i]번 반복해서 출력하면 된다.

[피드백]
전체적인 풀이 방향은 좋다.
문제에서 요구하는 특수한 숫자 순서를 num 배열로 직접 관리하고,
각 문자열의 등장 횟수를 count 배열에 저장한 뒤 출력하는 방식은 이 문제의 정석적인 풀이이다.

처음 보면 정렬 문제처럼 보일 수 있지만,
실제로는 숫자 종류가 10개로 고정되어 있기 때문에 카운팅 방식이 더 적절하다.

이번 문제에서 기억할 점은
정렬 기준이 일반 오름차순이나 사전순이 아니라 문제에서 직접 주어진 순서라면,
그 순서를 배열로 만들어 카운팅하거나 매핑해서 처리할 수 있다는 것이다.
*/
package swea.d3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1221 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            String[] num = {"ZRO", "ONE", "TWO", "THR", "FOR","FIV","SIX","SVN","EGT","NIN"};
            int [] count = new int[10];

            StringTokenizer nums = new StringTokenizer(br.readLine());

            for(int i = 0; i< N; i++) {
                String n = nums.nextToken();
                for(int j = 0; j<10; j++) {
                    if(n.equals(num[j])) {
                        count[j]++;
                        break;
                    }
                }
            }
            sb.append(t).append("\n");
            for(int i = 0; i< 10; i++) {
                int c = count[i];
                for(int j = 0;  j <c; j++) {
                    sb.append(num[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
