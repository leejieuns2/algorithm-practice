package boj.greedy;
import java.util.*;
import java.io.*;

/* �˰����� ���͵� - Greedy Algorithm
 * ���� 2262��. ��ʸ�Ʈ �����
 * https://www.acmicpc.net/problem/2262 */
public class Main_2262 {

	/* �������� ���� */
	static int[] rank = new int[257] ;
	
	static int solution(final int num, final int[] rank) {
		int i, j, rslt = 0;
		
		for (i = num; i > 1; i--) {
			for (j = 1; j <= num; j++) 
				if (rank[j] == i)
					break;
			
			rslt += rank[j] - Math.max(rank[j - 1], rank[j + 1]);
			
			while(j <= num) {
				rank[j] = rank[j + 1];
				j++;
			}	
		}
		
		return rslt;
	}
	public static void main(final String args[]) throws IOException {
		final Scanner scan = new Scanner(System.in);
		final int num = scan.nextInt();
		
		for(int i = 0; i < num; i++) {
			rank[i] = scan.nextInt();
		}
		
		System.out.println(solution(num, rank));
	}
}