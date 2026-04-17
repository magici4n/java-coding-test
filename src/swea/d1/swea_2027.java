/*
[문제]
SWEA 2027 - 대각선 출력하기

[분류]
구현 / 반복문 / 2차원 반복문

[접근]
#위치가 대각선인것 이용

[시간복잡도]
O(1)
- 항상 5 x 5 크기만 출력하므로 입력 크기에 따라 변하지 않는다.
- 반복문은 총 25번만 실행된다.

[핵심 포인트]
- 2중 for문 사용, i == j일 때 '#'을 출력하면 된다.


[피드백]

*/
package swea.d1;

public class swea_2027 {
    public static void main(String []args){

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if (i== j){
                    sb.append("#");
                }else {
                    sb.append("+");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
