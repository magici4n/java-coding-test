/*
[문제]
SWEA 5207 - 이진 탐색

[분류]
이진 탐색 / 정렬 / 구현 / 상태 관리

[접근]
A 배열을 정렬한 뒤, B 배열의 각 원소가 A 배열에 존재하는지 이진 탐색으로 확인한다.

단, 이 문제는 일반적인 이진 탐색과 다르게
탐색 과정에서 같은 방향으로 두 번 연속 이동하면 조건을 만족하지 않는다.

따라서 이진 탐색 중 이전에 이동한 방향을 same 변수로 기록한다.

same == 0 : 아직 이동한 방향 없음
same == 1 : 직전에 왼쪽으로 이동
same == 2 : 직전에 오른쪽으로 이동

찾는 값이 현재 mid 값보다 작으면 왼쪽으로 이동해야 한다.
이때 직전에도 왼쪽으로 이동했다면 조건 위반이므로 탐색을 중단한다.

찾는 값이 현재 mid 값보다 크면 오른쪽으로 이동해야 한다.
이때 직전에도 오른쪽으로 이동했다면 조건 위반이므로 탐색을 중단한다.

탐색 중 값을 찾으면 true를 반환하고,
조건 위반이 발생하거나 끝까지 찾지 못하면 false를 반환한다.

[시간복잡도]
O(N log N + M log N)

A 배열을 정렬하는 데 O(N log N)이 걸린다.
이후 B 배열의 M개 원소에 대해 각각 이진 탐색을 수행하므로 O(M log N)이 걸린다.

따라서 전체 시간복잡도는 O(N log N + M log N)이다.

[핵심 포인트]
1. A 배열은 반드시 정렬해야 이진 탐색을 사용할 수 있다.

   Arrays.sort(A);

2. 이 문제는 단순히 값이 존재하는지만 확인하는 문제가 아니다.
   이진 탐색 과정에서 왼쪽, 오른쪽 탐색 방향이 번갈아야 한다.

3. 이전 탐색 방향을 same 변수로 저장한다.

   same == 0 : 이동 없음
   same == 1 : 왼쪽 이동
   same == 2 : 오른쪽 이동

4. 왼쪽으로 가야 하는데 직전에도 왼쪽이었다면 실패한다.

   if (same == 1) {
       break;
   }

5. 오른쪽으로 가야 하는데 직전에도 오른쪽이었다면 실패한다.

   if (same == 2) {
       break;
   }

6. 값을 찾은 경우에만 flag를 true로 바꾸고 반복문을 종료한다.

[피드백]
처음 작성한 코드는 일반적인 이진 탐색으로,
B의 원소가 A 안에 존재하는지만 확인하는 구조였다.

하지만 SWEA 5207번은 값의 존재 여부뿐만 아니라
이진 탐색 과정에서 같은 방향으로 연속 이동하지 않는지도 확인해야 한다.

수정한 코드에서는 same 변수를 추가해서
직전에 이동한 방향을 기억하도록 만들었다.

A[m] > value이면 왼쪽으로 이동하고,
A[m] < value이면 오른쪽으로 이동한다.

이때 이전 방향과 현재 방향이 같으면 조건을 만족하지 않으므로 break한다.
값을 찾은 경우에만 flag가 true가 되므로 answer를 증가시킬 수 있다.

전체적으로 문제 조건을 잘 반영한 풀이이다.
다만 자바 메서드 이름은 관례상 BinarySearch보다 binarySearch처럼
소문자로 시작하는 것이 더 자연스럽다.
*/
package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_5207 {
    static int [] A;
    static boolean BinarySearch(int value) {
        int left = 0;
        int right = A.length-1;

        boolean flag = false;
        int same = 0;

        while(left <=right) {
            int m = (left+right)/2;

            if(A[m] == value) {
                flag = true;
                break;
            }else if(A[m] > value) {
                if(same == 1) {
                    break;
                }
                right = m-1;
                same = 1;
            }else if(A[m] < value) {
                if(same == 2) {
                    break;
                }
                left = m+1;
                same = 2;
            }
        }
        return flag;
    }

    public static void main(String[] args)throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            A = new int[N];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st1.nextToken());
            }
            Arrays.sort(A);
            int answer =0;
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                if(BinarySearch(Integer.parseInt(st2.nextToken()))) {
                    answer++;
                }
            }
            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
