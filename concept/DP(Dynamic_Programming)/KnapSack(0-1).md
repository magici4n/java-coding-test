# KnapSack(0-1)
___

## KnapSack(0-1) 이란?
0/1 Knapsack은 DP(Dynamic Programming)의 대표 유형 중 하나.

배낭에 담을 수 있는 최대 무게가 정해져 있고, 
각 물건마다 `무게`와 `가치`가 주어질 때, 
제한 무게를 넘지 않으면서 얻을 수 있는 최대 가치를 구하는 문제.

여기서 0/1이라는 뜻은 각 물건을 선택할 수 있는 경우가 두 가지뿐이라는 의미이다.  

- 0: 물건을 선택하지 않는다.
- 1: 물건을 선택한다.

즉, 같은 물건을 여러 번 담을 수 없다.  

___
## 문제상황
예를 들어 배낭의 최대 무게가 `K = 7`이고, 물건들이 다음과 같이 주어진다고 하자.

| 물건 | 무게 | 가치 |
|---|---:|---:|
| 1번 | 6 | 13 |
| 2번 | 4 | 8 |
| 3번 | 3 | 6 |
| 4번 | 5 | 12 |

이때 제한 무게 7을 넘지 않으면서 가치가 최대가 되도록 물건을 골라야 한다.

예를 들어 2번과 3번 물건을 고르면 다음과 같다.

```text
무게 = 4 + 3 = 7
가치 = 8 + 6 = 14
```
___
## DP 사용 이유
이 문제는 모든 조합을 다 따져서 구할 수 있음.  
물건이 N개인 경우 물건을 넣거나 안 넣거나로 모든 경우의 수를 따지면  
-> 2^N   
N이 너무 커지면 오래 걸리기 때문에 DP사용.   
___
## DP 배열 정의
0/1 Knapsack의 기본 DP의 정의는 다음과 같다.
```text
dp[i][w] = i번째 물건까지 고려했을 때,
           배낭의 무게 제한이 w일 때 얻을 수 있는 최대 가치
```  
여기서 i는 현재까지 고려한 물건의 번호이고, w는 현재 배낭의 허용 무게.   
___
## 선택지   
i번째 물건을 볼 때 선택지는 두 가지이다.   

### 1. i번째 물건을 넣지 않는 경우
현재 물건을 넣지 않으면 이전 물건들만 고려한 결과를 그대로 가져옴.   
```text
dp[i][w] = dp[i - 1][w]
```

### 2. i번째 물건을 넣는 경우  
현재 물건의 무게가 weight[i], 가치가 value[i]라고 하자.   
현재 무게 제한 w가 weight[i]보다 크거나 같으면 이 물건을 넣을 수 있다.   
```text
w >= weight[i]
```

이 물건을 넣으면 남은 무게는 다음과 같다.
```text
w - weight[i]
```

따라서 현재 물건을 넣는 경우의 가치는 다음과 같다.   
```text
dp[i - 1][w - weight[i]] + value[i]
```
여기서 dp[i - 1]을 쓰는 이유는 0/1 Knapsack에서는 같은 물건을 한 번만 사용할 수 있기 때문이다.   
___

## 점화식
현재 물건을 넣을 수 없는 경우 :   
```text
dp[i][w] = dp[i - 1][w]
```

현재 물건을 넣을 수 있는 경우 :  
```text
dp[i][w] = max(
    dp[i - 1][w],
    dp[i - 1][w - weight[i]] + value[i]
)
```
정리하면 다음과 같음    
```text
if (w < weight[i]) {
    dp[i][w] = dp[i - 1][w];
} else {
    dp[i][w] = Math.max(
        dp[i - 1][w],
        dp[i - 1][w - weight[i]] + value[i]
    );
}
```

___

## 코드 템플릿

```text
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물건 개수
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                if (w < weight[i]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(
                        dp[i - 1][w],
                        dp[i - 1][w - weight[i]] + value[i]
                    );
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
```

### 코드 해석

```text
int[][] dp = new int[N + 1][K + 1];
```
dp[i][w]는 i번째 물건까지 고려했고, 무게 제한이 w일 때 얻을 수 있는 최대 가치를 의미.   
___
```text
for (int i = 1; i <= N; i++)
```  
1번 물건부터 N번 물건까지 차례대로 확인.   
___

```text
for (int w = 1; w <= K; w++)
```
무게 제한을 1부터 K까지 하나씩 늘려가며 확인  
___
```text
if (w < weight[i])
```
현재 무게 제한 w보다 현재 물건의 무게가 더 크면 이 물건은 넣을 수 없음.

그래서 이전 결과를 그대로 가져옴.   
```text
dp[i][w] = dp[i - 1][w];
```   
___

```text
dp[i][w] = Math.max(
    dp[i - 1][w],
    dp[i - 1][w - weight[i]] + value[i]
);
```
현재 물건을 넣을 수 있다면 두 경우 중 더 큰 값을 선택한다.

- 현재 물건을 넣지 않는 경우
- 현재 물건을 넣는 경우

___
## 1차원 DP
지금 위에서 본 코드는 2차원 DP이다.
1차원 DP도 있는데 나중에 살펴보겠다.

___
## 1차원 DP와 2차원 DP비교
| 방식     | 장점            | 단점            |
| ------ | ------------- | ------------- |
| 2차원 DP | 이해하기 쉽다       | 메모리를 많이 사용한다  |
| 1차원 DP | 메모리를 절약할 수 있다 | 처음에는 헷갈릴 수 있다 |    

처음 공부할 때는 2차원 DP로 개념을 이해한 뒤, 1차원 DP 최적화를 공부하는 것이 좋다.

### 시간 복잡도
물건 개수를 N, 최대 무게를 K라고 하면 모든 물건에 대해 모든 무게를 확인한다. 

시간복잡도: O(N * K)  

2차원 DP의 공간복잡도는 다음과 같다.  
공간복잡도: O(N * K)   

1차원 DP의 공간복잡도는 다음과 같다.
공간복잡도: O(K)


