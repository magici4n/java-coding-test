package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        int[] Mnums = new int[M];
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
