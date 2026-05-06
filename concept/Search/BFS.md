# BFS(Breadth-First Search)
___
## 1. BFS란?
BFS는 Breadth-First Search, 즉 너비 우선 탐색.   

예를 들어 이런 그래프가 있다고 해보자.
```text
1 - 2 - 4
|
3 - 5
```
1번에서 시작하면 BFS는 이렇게 탐색한다.
```text
거리 0: 1
거리 1: 2, 3
거리 2: 4, 5
```
즉, 한 뱡향으로 깊게 들어가는 게 아니라
현재 위치에서 가까운 애들부터 먼저 보는 방식.

### BFS는 다음과 같은 문제에 적합
->  간선의 가중치가 없다.   
    최단 거리 또는 최소 이동 횟수를 구해야 한다
1. 최단 거리
2. 최소 이동 횟수
3. 몇 단계 만에 도착하는지
4. 가장 가까운 목표 지점 찾기

#### 문제예시
```text
1번 노드에서 5번 노드까지 최소 몇 개의 간선을 지나야 하는가?
미로에서 출발점에서 도착점까지 최소 몇 칸 이동해야 하는가?
컴퓨터 바이러스가 몇 대까지 퍼지는가?
```


___
## 2. DFS와 BFS 차이
- DFS : 한 길을 끝까지 들어가본다. 
- BFS : 현재 위치에서 한 칸 떨어진 곳들을 먼저 본다.   
        그다음 두 칸 떨어진 곳들을 본다.   
        그다음 세 칸 떨어진 곳들을 본다.

-> 따라서 최단거리 문제에는 BFS가 강함.

___
## 3. BFS는 Queue를 사용  
DFS는 보통 재귀나 Stack을 쓰고, BFS는 Queue를 사용.    

Queue는 먼저 들어온 게 먼저 나가는 구조(First in First Out)   

자바에서의 선언
```text
Queue<Integer> queue = new ArrayDeque<>();
```

- add() : 값 넣을때
- poll() : 값 꺼낼때
- isEmpty() : 비었는지 확인  
___
## 4. BFS 기본 구조
```text
Queue<Integer> queue = new ArrayDeque<>();

visited[start] = true;
queue.add(start);

while (!queue.isEmpty()) {
    int current = queue.poll();

    for (int next : graph[current]) {
        if (!visited[next]) {
            visited[next] = true;
            queue.add(next);
        }
    }
}
```
### 흐름
1. 시작 노드를 큐에 넣는다
2. 큐에서 하나 꺼낸다
3. 그 노드와 연결된 노드들을 확인한다
4. 아직 방문 안 했으면 방문 처리하고 큐에 넣는다
5. 큐가 빌 때까지 반복한다

### 방문 처리를 큐에 넣을때 하는게 중요  
보통 BFS에서는 방문 처리를 큐에서 꺼낼 때가 아니라, 큐에 넣을 때 한다.  
```text
visited[next] = true;
queue.add(next);
```
이유는 같은 노드가 큐에 여러 번 들어가는 걸 막기 위해서.

예를 들어 4번 노드로 가는 길이 여러 개 있으면,
방문 처리를 늦게 하면 4번이 큐에 중복으로 들어갈 수 있음

-> 발견하는 순간 방문 처리.

### 예시
그래프가 이렇게 있다고 가정하자.  
```text
1 - 2
1 - 3
2 - 4
3 - 5
```
인접리스트로는 이런 느낌.  
```text
graph[1] = [2, 3]
graph[2] = [1, 4]
graph[3] = [1, 5]
graph[4] = [2]
graph[5] = [3]
```

1번에서 BFS 시작.  

처음 상태 
```text
queue = [1]
visited[1] = true
```
1을 꺼냄  
```text
current = 1
연결된 노드: 2, 3
```
2,3을 큐에 넣음
```text
queue = [2, 3]
visited[2] = true
visited[3] = true
```
2를 꺼냄  
```text
current = 2
연결된 노드: 1, 4
```
1은 이미 방문했으니 패스.
4는 방문 안 했으니 큐에 넣음.
```text
queue = [3, 4]
visited[4] = true
```
3을 꺼냄
```text
current = 3
연결된 노드: 1, 5
```  
5를 큐에 넣음 
```text
queue = [4, 5]
visited[5] = true
```
___
## 최단 거리 구하기

BFS에서 최단 거리를 구하려면 distance 배열을 추가.   

```text
int[] distance = new int[V + 1];
```

시작점 거리는 0.  
```text
distance[start] = 0;
```

다음 노드로 이동할 때는 현재 거리 + 1.
```text
distance[next] = distance[current] + 1;
```
___
## 최단 거리 BFS 기본 코드
```text
static int bfs(int start, int end) {
    Queue<Integer> queue = new ArrayDeque<>();

    visited[start] = true;
    distance[start] = 0;
    queue.add(start);

    while (!queue.isEmpty()) {
        int current = queue.poll();

        if (current == end) {
            return distance[current];
        }

        for (int next : graph[current]) {
            if (!visited[next]) {
                visited[next] = true;
                distance[next] = distance[current] + 1;
                queue.add(next);
            }
        }
    }

    return 0;
}
```

## BFS의 시간복잡도
BFS의 시간 복잡도는 O(V + E) 이다.  
여기서 V: 정점의 개수 ,E: 간선의 개수  

-> BFS는 각 정점을 한 번씩 방문하고,
각 간선도 한 번씩 확인하기 때문에 O(V + E)이다.
