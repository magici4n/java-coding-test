package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1244 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            sb.append("#").append(tc+1).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num =st.nextToken();
            int N = Integer.parseInt(st.nextToken());
            int [] arr = new int [num.length()];

            for(int i =0; i<num.length(); i++){
                arr[i] = num.charAt(i) - '0';
            }

            for(int i =0; i < arr.length-1; i++){
                if (N== 0){
                    break;
                }
                int maxIndex = i;

                for(int j = i+1; j<arr.length; j++){
                    if(arr[j] >= arr[maxIndex]){
                        maxIndex = j;
                    }
                }
                if (maxIndex == i){
                    if(i == arr.length-2){
                        int tmp = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = tmp;
                        N--;
                    }else{
                        continue;
                    }
                }
                if(N > 0) {
                    int tmp = arr[i];
                    arr[i] = arr[maxIndex];
                    arr[maxIndex] = tmp;
                    N--;
                }else{
                    break;
                }
            }
            for(int i = 0; i< arr.length; i++){
                sb.append(arr[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
