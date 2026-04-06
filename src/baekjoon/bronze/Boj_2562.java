/*
[문제]
BOJ 2562 - 최댓값

[분류]
구현

[접근]
9개의 정수를 입력 받으면서 숫자 한개 한개를 max값과 비교하고 max값 변경시 index값도 변경하였다.

[시간복잡도]
O(9) / O(N)으로 봐도 될것같다. 입력값이 9라서 O(9)라고 적었을 뿐이다.

[핵심 포인트]



[피드백]
처음에 입력을 받을 때 배열로 받을 생각을 하였는데 꼭 그럴필요가 없던 문제였다.
앞으로 입력 받는 값에 대한 자료형을 깊게 생각해봐야겠다.

*/

package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2562 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i<9; i++){
            int num = Integer.parseInt(br.readLine());
            if (num>max){
                max = num;
                index = i+1;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}
