/*
문제가 너무 쉬워서 생략
 */
package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1933 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =1; i<=N; i++){
            if(N%i ==0){
                sb.append(i);
                if(i != N){
                    sb.append(" ");
                }
            }
        }
        System.out.print(sb);
    }
}
