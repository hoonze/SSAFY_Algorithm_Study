# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="30"> [12865] 평범한배낭
## 문제 링크
> https://www.acmicpc.net/problem/12865
## 알고리즘 분류
> DP

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N, K;
	static Product[] products;
	
	static class Product {
		int weight, value;

		public Product(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		products = new Product[N];
		
		int w, v;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			products[i] = new Product(w, v);
		}
		
		//1차원 배열을 사용한 0/1knapsack
		int[] dp = new int[K+1];
		for(int i = 0; i < N; i++) {
			for(int j = K; j-products[i].weight >= 0; j--) {
				if(dp[j] < dp[j - products[i].weight] + products[i].value) {
					dp[j] = dp[j - products[i].weight] + products[i].value;
				}
			}
		}
		System.out.println(dp[K]);
	}
}

```

## 문제 풀이
* 1차원 배열 dp를 사용했다.
	* 이전 값들을 사용하기 위해서 배열의 뒷부분부터 확인.
	* 뒷부분부터 자신의 위치까지보며 (현재value) + (K-현재의 value)가 더 높다면 초기화
