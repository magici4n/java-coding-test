package swea.d3;

/*
[문제]
SWEA 4843 - 특별한 정렬

[분류]
정렬 / 배열 / 구현

[접근]
입력받은 숫자 배열을 오름차순으로 정렬한다.

문제에서 요구하는 특별한 정렬은
가장 큰 수, 가장 작은 수, 두 번째 큰 수, 두 번째 작은 수 ...
순서로 출력하는 것이다.

따라서 정렬된 배열에서
뒤쪽 인덱스는 큰 수부터,
앞쪽 인덱스는 작은 수부터 번갈아 출력한다.

N개의 숫자 중 앞에서 10개만 출력하면 되므로,
큰 수 5개와 작은 수 5개를 번갈아 출력한다.

[시간복잡도]
O(N log N)

Arrays.sort(nums)를 사용해 배열을 정렬하므로 O(N log N)이다.
출력은 10개만 하므로 O(1)에 가깝다.

[핵심 포인트]
1. Arrays.sort(nums)를 사용하면 배열이 오름차순으로 정렬된다.

예:
nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}

2. 가장 큰 값은 nums[N - 1]이다.
두 번째로 큰 값은 nums[N - 2]이다.

3. 가장 작은 값은 nums[0]이다.
두 번째로 작은 값은 nums[1]이다.

4. 따라서 i를 0부터 4까지 돌면서 다음과 같이 출력한다.

nums[N - 1 - i]  // 큰 값
nums[i]          // 작은 값

5. 문제에서 앞의 10개만 출력하라고 했으므로,
반복문은 5번만 돌면 된다.

for (int i = 0; i < 5; i++) {
    sb.append(nums[N - 1 - i]).append(" ");
    sb.append(nums[i]).append(" ");
}

[피드백]
이번 풀이는 문제 요구사항을 정확히 반영한 정석 풀이이다.

배열을 정렬한 뒤,
큰 값과 작은 값을 양쪽 끝에서 하나씩 가져오는 방식으로 구현했다.

특별한 정렬이라고 해서 실제로 배열을 새롭게 재배치할 필요는 없다.
문제에서 요구하는 것은 출력 순서이므로,
정렬된 배열에서 필요한 순서대로 바로 출력하면 된다.

현재 코드는 다음 흐름이 깔끔하다.

1. 입력 배열 저장
2. Arrays.sort로 오름차순 정렬
3. 큰 값과 작은 값을 번갈아 5쌍 출력

주의할 점은 문제에서 "10개만 출력"한다는 조건이다.
전체 N개를 모두 출력하는 문제가 아니므로,
반복문을 N/2까지 돌리는 것이 아니라 5번만 돌리는 것이 맞다.

이번 문제는 접근도 좋고 구현도 깔끔했다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_4843 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {

            int N = Integer.parseInt(br.readLine());
            int []nums = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i =0; i<N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums);

            sb.append("#").append(tc+1).append(" ");
            for(int i = 0; i<5; i++) {
                sb.append(nums[N-1-i]).append(" ").append(nums[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
