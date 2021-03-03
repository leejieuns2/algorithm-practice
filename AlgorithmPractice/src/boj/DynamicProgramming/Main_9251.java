package boj.DynamicProgramming;

import java.util.Scanner;

/* �˰��� ���͵� - Dynamic Programming Algorithm
 * ���� 9251��. LCS 
 * https://www.acmicpc.net/problem/9251 */

public class Main_9251 {

	public static int[][] dp;
	public static String str1;
	public static String str2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		str1 = scan.next();
		str2 = scan.next();
		// ���� ����� ���� 2���� �迭�� �����Ѵ�.
		dp = new int[str1.length() + 1][str2.length() + 1];
		System.out.println(solution(str1.length(), str2.length()));
		
		for(int i = 0; i <= str1.length(); i++) {
			for(int j = 0; j <= str1.length(); j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		// ���� �� ���ڿ��� �� ���ڿ��� ���̸� �Ű������� �����Ѵ�.
	}

	public static int solution(int len1, int len2) {
		// ������ ó�� ������ ���̹Ƿ� 0���� �ʱ�ȭ���ش�.
		for(int i = 0; i <= len1; i++) {
			dp[i][0] = 0;
		}
		for(int j = 0; j <= len2; j++) {
			dp[0][j] = 0;
		}
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					// ���ϴ� �� ���ڿ��� ���� ��� 1 ���������ش�.
					// �̶�, �� ������ ������ ���ڿ��� �־��� ��� �ջ������ �ϹǷ�
					// str1 - 1�϶� ���Ҵ� ���ڿ��� str2 - 1 �϶� ���Ҵ� ���ڿ� �� ū ������ 1�� �����ش�.
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					// ���� ���� ���� ��쿣 ���� ���� ���� ���� ���� ���� �����Ѵ�.
				}
			}
		}
		return dp[len1][len2];
	}
}
