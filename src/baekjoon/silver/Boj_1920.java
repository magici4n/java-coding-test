/*
[문제]
BOJ 1920 - 수 찾기

[분류]
배열 / 정렬 / 이분 탐색

[접근]
N개의 수를 배열에 저장한 뒤 오름차순 정렬.
M개의 수를 하나씩 읽으면서 Arrays.binarySearch() - 이분탐색으로 존재 여부를 확인.

[시간복잡도]
정렬: O(N log N)
탐색: O(M log N)
전체: O(N log N + M log N)

[핵심 포인트]
Arrays.binarySearch()를 사용하려면 배열이 정렬되어 있어야 한다.

Arrays.binarySearch(arr, target)의 반환값:
- 0 이상: target이 존재함, 해당 인덱스 반환
- 음수: target이 존재하지 않음

존재 여부만 확인할 때는:
if (Arrays.binarySearch(arr, target) >= 0)

[피드백]
처음에는 contains()나 이중 for문으로 접근했지만,
N과 M이 최대 100,000이라 O(N * M)은 시간초과가 난다.

이 문제의 핵심 신호는 “여러 개의 수가 배열 안에 존재하는지 반복해서 확인한다”는 점이다.
이런 문제는 정렬 + 이분 탐색 또는 HashSet을 먼저 떠올리자.
*/
package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1920 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] Nnums = new int[N];
        StringTokenizer stN = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<N; i++){
            Nnums[i] = Integer.parseInt(stN.nextToken());
        }
        Arrays.sort(Nnums);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer stM = new StringTokenizer(br.readLine());

        for(int i = 0; i<M; i++){
            int Mnumber = Integer.parseInt(stM.nextToken());
            if(Arrays.binarySearch(Nnums,Mnumber)>=0){
                sb.append("1").append("\n");
            }else{
                sb.append("0").append("\n");
            }
        }
        System.out.print(sb);
    }
}
