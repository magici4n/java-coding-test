## BufferedReader
_____________________
문자를 읽을 때 버퍼를 이용해서 더 효율적으로 읽게 해주는 도구.   
- Reader 계열은 글자 단위로 읽음.  
- BufferedReader는 그 위에 붙어서 한 번에 조금씩 모아놓고 읽음. 
- 그 결과 매번 한 글자씩 바로바로 읽는 것보다 빠르고 편리.   
-> 코테에서 쓰게되는 이유.   

<pre><code>
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine(); // 한 줄 입력 받기
        System.out.println(s);
    }
}
</code></pre>

-System.in : 키보드 입력
-InputStreamReader : 바이트 입력을 문자로 바꿔줌
-BufferedReader : 그 문자를 버퍼에 담아 효율적으로 읽음

**핵심 메서드**   
-readLine() : 한 줄 전체를 문자열로 읽음

**주로 같이 쓰는 메서드**   
- split()
<pre><code>
String[] arr = br.readLine().split(" ");
//10 20 을 입력으로 넣었을 경우
int a = Integer.parseInt(arr[0]);
int b = Integer.parseInt(arr[1]);
// a에는 10 ,b에는 20
</code></pre>

- StringTokenizer   
StringTokenizer는 문자열을 구분자 기준으로 잘게 나눠주는 도구.
<pre><code>
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

//입력이 10 20 30 이면
//출력
//10
//20
//30
</code></pre>

**간단한 설명**
StringTokenizer st = new StringTokenizer(br.readLine());   
-> 토큰으로 나누기(기본적으로 공백 기준으로 나눔.)    
st.nextToken();   
-> 하나씩 꺼내기(이걸 호출할 때마다 다음 조각을 꺼냄.)    
첫 번째 호출 → "10"  
두 번째 호출 → "20"  
세 번째 호출 → "30"

