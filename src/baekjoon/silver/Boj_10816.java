package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10816 {

    static int upper_binarySearch(int [] arr, int target){
        int left = 0;
        int right = arr.length-1;

        while(left<=right){
            int mid = (left + right)/2;

            if(arr[mid] == target){
                while(arr[mid] == target){
                    mid++;
                }
                return mid;
            }else if(arr[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return 0;
    }
    static int lower_binarySearch(int [] arr, int target){
        int left = 0;
        int right = arr.length-1;

        while(left<=right){
            int mid = (left + right)/2;

            if(arr[mid] == target){
                while(arr[mid] == target){
                    mid--;
                }
                return mid;
            }else if(arr[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return 0;
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int []Nnums = new int[N];
        StringTokenizer stN = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            Nnums[i] = Integer.parseInt(stN.nextToken());
        }
        Arrays.sort(Nnums);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer stM = new StringTokenizer(br.readLine());

        while(stM.hasMoreTokens()){
            int k = Integer.parseInt(stM.nextToken());
            int s = 0;
            if ( upper_binarySearch(Nnums,k) ==lower_binarySearch(Nnums,k) ){
                s = 1;
            }else if(upper_binarySearch(Nnums,k) == 0 &&  lower_binarySearch(Nnums,k) == 0){
                s = 0;
            }else{
                s = upper_binarySearch(Nnums,k) - lower_binarySearch(Nnums,k) + 2;
            }
            sb.append(s).append(" ");

        }
        System.out.print(sb);
    }
}
