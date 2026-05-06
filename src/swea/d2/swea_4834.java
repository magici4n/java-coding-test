/*
[문제]
SWEA 4834 - 숫자 카드

[분류]
구현 / 배열 / 카운팅

[접근]
0부터 9까지의 숫자 카드 개수를 저장할 수 있는 크기 10짜리 배열을 만든다.
입력받은 카드 문자열을 한 글자씩 확인하면서 해당 숫자의 개수를 증가시킨다.
이후 0부터 9까지 순회하면서 가장 많이 나온 숫자와 그 개수를 찾는다.
카드 개수가 같은 경우에는 더 큰 숫자를 선택해야 하므로 max <= nums[i] 조건을 사용한다.

[시간복잡도]
O(N)

카드 문자열을 한 번 순회하면서 개수를 세고,
숫자 0부터 9까지의 배열을 한 번 확인하므로 전체 시간복잡도는 O(N + 10), 즉 O(N)이다.

[핵심 포인트]
1. 숫자 문자를 정수로 바꿀 때는 num.charAt(i) - '0'을 사용한다.
2. 0부터 9까지 숫자 개수를 세기 위해 int[] nums = new int[10]을 사용한다.
3. 개수가 같을 때 더 큰 숫자를 선택해야 하므로 if (max <= nums[i])를 사용한다.

[피드백]
arr 배열을 따로 만들 필요는 없다.
입력받은 문자열을 바로 순회하면서 nums[num.charAt(i) - '0']++ 처리하면 더 간단하다.
또한 nums 배열은 {0,0,0,...}으로 직접 초기화하지 않고 new int[10]으로 선언해도 된다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_4834 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T; tc++) {

            int [] nums = {0,0,0,0,0,0,0,0,0,0};
            int N = Integer.parseInt(br.readLine());
            String num = br.readLine();

            int [] arr = new int[N];
            for(int i = 0; i< N; i++) {
                arr[i] = num.charAt(i)-'0';
            }

            for(int i = 0; i< arr.length; i++) {
                nums[arr[i]]++;
            }

            int max = Integer.MIN_VALUE;
            int flag = 0;
            for(int i = 0; i< nums.length; i++) {
                if(max <=nums[i]) {
                    max = nums[i];
                    flag = i;
                }
            }

            sb.append("#").append(tc+1).append(" ").append(flag).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
}