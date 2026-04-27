# DFS(Depth-First Search, 깊이 우선 탐색)
___

## DFS란?
DFS는 **한 방향으로 끝까지 깊게 들어가 본 뒤**,  
더 이상 갈 곳이 없으면 **이전 지점으로 돌아와 다른 길을 탐색하는 방식**.  

쉽게 설명하면
- 갈 수 있으면 계속 간다
- 막히면 돌아온다
- 돌아와서 다른 길을 간다   
-> **깊이 우선 탐색**

### 트리 예시

```text
1
├─ 2
│  ├─ 4
│  └─ 5
└─ 3
   ├─ 6
   └─ 7
```
DFS 방문순서  
```text
1 → 2 → 4 → 5 → 3 → 6 → 7
```
**자식 방향으로 끝까지 내려가는 것**이 핵심
___
## DFS의 기본 구조
DFS는 보통 다음 흐름으로 동작.

1. 현재 위치 방문 처리
2. 현재 위치에서 갈 수 있는 다음 위치 확인
3. 아직 방문하지 않았다면 그쪽으로 들어감
4. 더 갈 곳이 없으면 돌아옴
___
## 그래프 DFS 기본 템플릿(재귀)  
```text
static ArrayList<Integer>[] graph;
static boolean[] visited;

static void dfs(int now) {
    visited[now] = true; // 현재 노드 방문 처리

    for (int next : graph[now]) {
        if (!visited[next]) {
            dfs(next);
        }
    }
}
```
- visited[now] = true;   
  현재 노드를 방문했다고 표시
- for (int next : graph[now])   
  현재 노드와 연결된 다음 노드 확인
- if (!visited[next])  
  아직 방문하지 않은 곳이면
- dfs(next);  
  그 노드로 깊게 들어감
___
## visited의 중요성
그래프가 다시 돌아오는 길이 있는 경우

예를 들어
```
1 - 2
|   |
3 - 4
```  
이런 그래프에서 방문 체크가 없으면   
같은 곳을 계속 반복 방문하면서 무한 루프에 빠질 수 있음.

그래서 보통 DFS에서는 visited 배열이 매우 중요 .
___
## 스택 DFS 기본 템플릿  
```text
static void dfs(int start) {
    Stack<Integer> stack = new Stack<>();
    stack.push(start);

    while (!stack.isEmpty()) {
        int now = stack.pop();

        if (visited[now]) continue;
        visited[now] = true;

        for (int next : graph[now]) {
            if (!visited[next]) {
                stack.push(next);
            }
        }
    }
}
```
코테에서는 보통 재귀 DFS를 먼저 익히는 편
___
## DFS는 언제 쓸까
- 그래프 탐색
- 트리 탐색
- 연결 요소 개수 세기
- 2차원 배열(격자)에서 덩어리 찾기
- 가능한 모든 경우 탐색
- 순열 / 조합 / 백트래킹 문제    
-> 현재 상태에서 다음 상태로 계속 들어가며 탐색하는 문제에 자주 등장.   
___
## 자주쓰는 2차원 배열(격자) DFS 템플릿   
예시 : 상하좌우로 연결된 1의 덩어리 찾기   
```text
static int[][] map;
static boolean[][] visited;
static int N, M;

static int[] dx = {-1, 1, 0, 0};
static int[] dy = {0, 0, -1, 1};

static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        // 범위 밖이면 건너뜀
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

        // 이미 방문했으면 건너뜀
        if (visited[nx][ny]) continue;

        // 갈 수 없는 칸이면 건너뜀
        if (map[nx][ny] == 0) continue;

        dfs(nx, ny);
    }
}
```
### 설명 
- dx, dy는 상하좌우 이동용
- nx, ny는 다음 좌표
- 범위 체크 → 방문 체크 → 조건 체크 후 재귀 호출
___

## DFS와 백트래킹
백트래킹이란?   
탐색하다가 답이 안 될 것 같으면 돌아가는 기법
   
즉,   
DFS는 탐색 방법.
백트래킹은 그 탐색 중 불필요한 길을 줄이는 방법.   
___
## DFS와 백트래킹이 자주 같이 나오는 이유
**백트래킹의 문제 구조**
1. 현재 상태에서 하나 선택
2. 다음 단계로 들어감
3. 또 선택
4. 또 들어감
5. 답이 아니면 돌아옴
6. 다른 선택 시도

이러한 흐름이 깊게 들어가는 DFS 구조랑 잘 맞음.  
->DFS로 탐색하면서 백트래킹으로 되돌아온다
___
## DFS만 있으면 되는 문제
그냥 다 방문만 하면 되는 문제
- 그래프 순회
- 트리 순회
- 연결 요소 찾기
  
이런 문제는 보통
- 방문 체크
- 다음 노드 방문

정도면 끝.

## DFS + 백트래킹이 필요한 문제
경우의 수를 만들어야 하는 문제   
- 순열
- 조합
- N-Queen
- 스도쿠

이런 문제는 단순 방문이 아니라

- 선택
- 재귀
- 복구
가 필요.
___
## DFS와 백트래킹 전형적인 틀
```text
void dfs(현재상태) {
    if (종료조건) {
        정답처리;
        return;
    }

    for (선택 가능한 모든 경우) {
        if (불가능한 선택) continue;

        상태 변경;     // 선택
        dfs(다음상태); // 깊게 탐색
        상태 복구;     // 백트래킹
    }
}
``` 

## 백트래킹에서 중요한 개념 2개
### 1) 원상복구
탐색 후 돌아올 때 상태를 원래대로 되돌려야 함.   
ex)
- 방문 체크 해제
- swap 복구
- 리스트에서 마지막 원소 제거

### 2) 가지치기
어차피 답이 안 되는 길이면 더 안 내려가는 것   
ex)
- 합이 이미 목표보다 큼
- 조건 위반
- 중복 상태
- 현재 값이 최적해보다 나쁨

탐색량을 줄이기 위해 필요.
___
### DFS + 백트래킹 예시 
예를 들어 1, 2, 3 중 2개를 뽑는 순열을 만든다고 하자.
```text
static int[] result = new int[2];
static boolean[] used = new boolean[4];

static void dfs(int depth) {
    if (depth == 2) {
        System.out.println(result[0] + " " + result[1]);
        return;
    }

    for (int i = 1; i <= 3; i++) {
        if (used[i]) continue;

        used[i] = true;          // 선택
        result[depth] = i;

        dfs(depth + 1);          // 더 깊게 들어감 (DFS)

        used[i] = false;         // 돌아오면서 원상복구 (백트래킹)
    }
}
```

### dfs 부분

***dfs(depth + 1);***

이 줄이 DFS.
현재 상태에서 다음 단계로 더 깊게 들어가는 것.

### 백트래킹 부분  

***used[i] = false;***  

이 줄이 백트래킹의 핵심.  
선택하고 들어갔다가, 돌아오면서 다시 원래 상태로 복구.  

- used[i] = true → 선택
- dfs(...) → 깊게 탐색
- used[i] = false → 되돌리기

이 3단계가 백트래킹 문제의 대표 구조