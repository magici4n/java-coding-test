package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class swea_1244 {
    static char[] numbers;
    static int chance;
    static int answer;
    static HashSet<String>[] visited;

    static void dfs(int count) {
        String current = new String(numbers);

        if (visited[count].contains(current)) {
            return;
        }
        visited[count].add(current);

        if (count == chance) {
            answer = Math.max(answer, Integer.parseInt(current));
            return;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                swap(i, j);
                dfs(count + 1);
                swap(i, j); // 원상복구
            }
        }
    }

    static void swap(int i, int j) {
        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            chance = Integer.parseInt(st.nextToken());

            numbers = num.toCharArray();
            answer = 0;

            visited = new HashSet[chance + 1];
            for (int i = 0; i <= chance; i++) {
                visited[i] = new HashSet<>();
            }

            dfs(0);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
