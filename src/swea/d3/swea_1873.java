/*
[문제]
SWEA 1873 - 상호의 배틀필드

[분류]
구현 / 시뮬레이션 / 2차원 배열

[접근]
전차의 현재 위치를 x, y로 저장해두고, 명령어를 하나씩 처리한다.

명령어가 U, D, L, R인 경우에는 먼저 현재 위치의 전차 방향을 해당 방향 문자로 바꾼다.
그다음 이동하려는 위치가 맵 범위 안이고 평지('.')라면 전차를 이동시킨다.
이동할 수 없는 경우에는 위치는 그대로 두고 방향만 바뀐 상태를 유지한다.

명령어가 S인 경우에는 현재 전차가 바라보는 방향을 기준으로 포탄을 발사한다.
포탄은 맵 밖으로 나가거나 강철 벽('#')을 만나면 멈춘다.
벽돌 벽('*')을 만나면 해당 칸을 평지('.')로 바꾸고 멈춘다.
평지('.')나 물('-')은 그대로 통과한다.

[시간복잡도]
O(N * max(H, W))

N은 명령어의 개수이다.
이동 명령은 한 번에 O(1)로 처리된다.
발사 명령은 포탄이 한 방향으로 최대 H칸 또는 W칸까지 이동할 수 있으므로 O(max(H, W))이다.
따라서 전체 시간복잡도는 O(N * max(H, W))이다.

[핵심 포인트]
1. 전차의 위치를 찾으면 x, y에 저장해두고 명령어 처리 때 계속 갱신한다.
2. 이동 명령이 들어오면 실제 이동 여부와 상관없이 전차의 방향은 먼저 바꿔야 한다.
3. 전차는 평지('.')로만 이동할 수 있다.
4. 포탄은 평지('.')와 물('-')은 통과한다.
5. 포탄이 벽돌 벽('*')을 만나면 해당 칸을 평지('.')로 바꾸고 종료한다.
6. 포탄이 강철 벽('#')을 만나면 아무 변화 없이 종료한다.
7. 맵 밖으로 포탄이 나가면 그대로 종료한다.

[피드백]
방향별 코드가 반복되는 구조라서 코드가 길어졌다.
현재 풀이도 정답 로직으로 충분하지만,
나중에는 dx, dy 배열을 사용하면 이동과 포탄 발사 코드를 더 짧고 깔끔하게 만들 수 있다.

또한 x, y라는 변수명도 사용할 수 있지만,
2차원 배열에서는 행과 열을 의미하는 r, c를 사용하면 가독성이 더 좋아질 수 있다.
*/

package swea.d3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1873 {

    static char [][] map;
    static int H;
    static int W;
    static int x;
    static int y;
    public static void act(char c) {
        switch(c){
            case 'U':
                map[x][y] = '^';
                if(x-1 <0) {
                    return;
                }
                if(map[x-1][y] == '.') {
                    map[x-1][y] = '^';
                    map[x][y] = '.';
                    x--;
                }
                break;
            case 'D':
                map[x][y] = 'v';
                if(x+1 >H-1) {
                    return;
                }
                if(map[x+1][y] == '.') {
                    map[x+1][y] = 'v';
                    map[x][y] = '.';
                    x++;
                }
                break;
            case 'L':
                map[x][y] = '<';
                if(y-1 < 0) {
                    return;
                }
                if(map[x][y-1] == '.') {
                    map[x][y-1] = '<';
                    map[x][y] = '.';
                    y--;
                }
                break;
            case 'R':
                map[x][y] ='>';
                if(y+1 > W-1) {
                    return;
                }
                if(map[x][y+1] == '.') {
                    map[x][y+1] = '>';
                    map[x][y] = '.';
                    y++;
                }
                break;
            case 'S':
                int shot_x = x;
                int shot_y = y;
                switch(map[x][y]) {
                    case '^' :
                        while(true) {
                            if(shot_x-1 < 0 || map[shot_x - 1][shot_y] =='#') {
                                break;
                            }else if(map[shot_x - 1][shot_y] == '*') {
                                map[shot_x -1][shot_y] = '.';
                                break;
                            }else {
                                shot_x--;
                            }
                        }
                        break;
                    case 'v' :
                        while(true) {
                            if(shot_x + 1 > H-1 || map[shot_x + 1][shot_y] == '#') {
                                break;
                            }else if(map[shot_x + 1][shot_y] == '*') {
                                map[shot_x + 1][shot_y] = '.';
                                break;
                            }else {
                                shot_x++;
                            }
                        }
                        break;
                    case '<' :
                        while(true) {
                            if(shot_y - 1 < 0 || map[shot_x][shot_y - 1] == '#') {
                                break;
                            }else if(map[shot_x][shot_y-1] == '*') {
                                map[shot_x][shot_y-1] = '.';
                                break;
                            }else {
                                shot_y--;
                            }
                        }
                        break;
                    case '>' :
                        while(true) {
                            if(shot_y + 1 > W-1 || map[shot_x][shot_y+1] == '#') {
                                break;
                            }else if(map[shot_x][shot_y+1] == '*') {
                                map[shot_x][shot_y+1] = '.';
                                break;
                            }else {
                                shot_y++;
                            }
                        }
                }
        }

    }
    public static void main(String[] args)throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];

            for(int i = 0; i < H; i++) {
                String m = br.readLine();
                for(int j = 0; j < W; j++) {
                    map[i][j]=m.charAt(j);

                    if(map[i][j] == '^' ||map[i][j] ==  'v' ||map[i][j] ==  '<' ||map[i][j] ==  '>') {
                        x = i;
                        y = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String command = br.readLine();

            for(int i = 0; i < N; i++) {
                char c = command.charAt(i);
                act(c);
            }
            sb.append("#").append(tc+1).append(" ");
            for(int i = 0; i<H; i++) {
                for(int j = 0; j<W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
