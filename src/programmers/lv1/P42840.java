/*
[문제]
프로그래머스 42840 - 모의고사

[분류]
완전탐색 / 배열 / 반복 패턴 / 나머지 연산(%)

[접근]
- 각 수포자의 찍기 패턴이 반복되므로 전체 길이만큼 배열을 만들지 않고 최소 반복 패턴만 저장한다.
- i번째 문제에서 각 수포자의 답은 pattern[i % pattern.length]로 구한다.
- answers[i]와 각 수포자의 답을 비교해서 맞힌 개수를 score 배열에 저장한다.
- 가장 높은 점수를 구한 뒤, 해당 점수를 가진 수포자의 번호를 결과에 담는다.
- 수포자 번호를 1번부터 3번까지 순서대로 확인하므로 결과는 자동으로 오름차순이 된다.

[시간복잡도]
- answers의 길이를 N이라고 하면 모든 문제를 한 번 순회하므로 O(N)
- 최고 점수 확인 및 결과 생성은 수포자가 3명뿐이므로 O(1)
- 전체 시간복잡도: O(N)

[핵심]
- 일정한 패턴이 반복될 때는 % 연산을 사용하면 된다.
- 길이가 L인 패턴은 pattern[i % L]로 계속 반복할 수 있다.
- 반복 패턴 전체를 미리 만들어두는 것보다 최소 패턴만 저장하는 것이 코드가 간단하고 실수도 줄어든다.
- 점수를 저장하는 배열과 실제 반환할 answer 배열의 역할을 구분해서 변수명을 짓는 것이 좋다.

[피드백]
- 처음 풀이에서는 각 수포자의 답을 10000개짜리 배열로 직접 생성했는데, 정답은 만들 수 있지만 코드가 복잡해지고 패턴 생성 과정에서 버그가 발생하기 쉽다.
- 특히 3번 수포자의 패턴을 count, flag, flag2, rule로 직접 생성하면서 로직이 복잡해졌다.
- 이 문제에서는 패턴 자체를 배열로 저장하고 % 연산으로 반복시키는 것이 더 정석적인 접근이다.
- 최고 점수를 구하고 공동 1등을 찾는 로직은 기존 풀이도 올바르게 작성했다.

[기억할 점]
반복되는 배열 패턴을 보면
→ "최소 패턴 배열 + i % pattern.length"
를 먼저 떠올린다.

 */

package programmers.lv1;

import java.util.Arrays;

public class P42840 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = {1,3,2,4,2};
        System.out.println(Arrays.toString(s.solution(answer)));
    }


    static class Solution {
        public int[] solution(int[] answers) {

            int[] student1 = new int[10000];
            int[] student2 = new int[10000];
            int[] student3 = new int[10000];

            int count = 1;
            for(int i = 0; i< 10000; i++){
                student1[i] = count++;
                if(count > 5){
                    count = 1;
                }
            }
            count = 1;
            for(int i = 0; i < 10000; i++){
                if(i % 2 == 0){
                    student2[i] = 2;
                }else{
                    student2[i] = count++;
                    if(count== 2){
                        count++;
                    }
                    if(count > 5){
                        count = 1;
                    }
                }
            }

            count = 3;
            int flag = 0;
            int flag2 = 0;
            int [] rule = {-2,1,2,1,-2};
            for(int i = 0; i < 10000; i++){
                student3[i] = count;
                flag++;
                if(flag == 2){
                    count += rule[flag2++];
                    flag = 0;
                    if(flag2 > 4){
                        flag2 = 0;
                    }
                }
            }

            int [] answer = new int[3];
            for(int i = 0; i< answers.length; i++){
                if(answers[i] == student1[i]){
                    answer[0]++;
                }
                if(answers[i] == student2[i]){
                    answer[1]++;
                }
                if(answers[i] == student3[i]){
                    answer[2]++;
                }
            }


            int max_num = Math.max(answer[0], Math.max(answer[1],answer[2]));
            int answer_count = 0;
            for(int i = 0; i < 3; i++){
                if(max_num == answer[i]){
                    answer_count++;
                }
            }

            int [] real_answer = new int[answer_count];

            count = 0;
            for(int i = 0; i < 3; i++){
                if(max_num == answer[i]){
                    real_answer[count] = i+1;
                    count++;
                }
            }
            return real_answer;
        }
    }
}
