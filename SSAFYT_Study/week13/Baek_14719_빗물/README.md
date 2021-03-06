# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="30"> [14719] 빗물
## 문제 링크
> https://www.acmicpc.net/problem/14719
## 알고리즘 분류
> 구현, 시뮬레이션

## 코드
```java
package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14719_빗물 {
	static int H, W, ans = 0;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int leftMax, rightMax;
		for(int i = 1; i < W-1; i++) {
			leftMax = rightMax = 0;
			
			for(int j = 0; j < i; j++) {
				leftMax = Math.max(leftMax, arr[j]);
			}
			
			for(int j = i+1; j < W; j++) {
				rightMax = Math.max(rightMax, arr[j]);
			}
			
			if(Math.min(leftMax, rightMax) > arr[i]) 
				ans += Math.min(leftMax, rightMax)-arr[i];
		}
		System.out.println(ans);
	}
}
```

## 문제 풀이
* 2020년 하반기 NHN 코딩테스트때 나온 문제이다.
* 빗물이 고일 수 없는 첫번째와 마지막 인덱스를 제외한 다른 인덱스들의 왼쪽 최대치와 오른쪽 최대치를 구한다.
* 왼쪽 최대치와 오른쪽 최대치의 중의 작은 값을 기준으로 빗물이 채워지게 된다.

