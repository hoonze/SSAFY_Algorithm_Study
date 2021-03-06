package week13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_10942_팰린드롬2 {
	static int N, M;
	static int[] arr;
	static boolean[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new boolean[N+1][N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start, end;
		for(int i = 1; i <= N; i++) {
			for(int j = N; j >=	1; j--) {
				if(!dp[i][j] && arr[i] == arr[j]) {
					if(!palindrome(i, j)) 
						continue;
					
					start = i;
					end = j;
					while(start <= end) {
						dp[start++][end--] = true;
					}
				}
			}
		}
		
		M = Integer.parseInt(br.readLine());
		
		int s, e;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			if(dp[s][e])
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
				
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static boolean palindrome(int s, int e) {
		while(s < e) {
			if(arr[s++] != arr[e--])
				return false;
		}
		return true;
	}
}
