package boj.queue;

import java.io.*;
import java.util.*;

/*
 * 1966. 프린터 큐
 * https://www.acmicpc.net/problem/1966
 * */

public class Main_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int caseCnt = Integer.parseInt(reader.readLine());
		
		for(int i = 0; i < caseCnt; i++) {
			String[] qPos = reader.readLine().split(" ");
			String[] docs = reader.readLine().split(" ");
			
			int docLen = Integer.parseInt(qPos[0]);
			int printNum = Integer.parseInt(qPos[1]);
			
			Queue<int[]> printQ = print(docLen, docs, printNum);
			showResult(printQ, docLen);
		}
	}

	
	private static void showResult(Queue<int[]> printQ, int docLen) {
		for(int i = 1; i <= docLen; i++) {
			int[] doc = printQ.poll();
			if(doc[1] == 1) {
				System.out.println(i);
				break;
			}
		}
	}
	
	private static Queue<int[]> print(int docLen, String[] docs, int printNum) {
		Queue<int[]> printQ = new LinkedList<int[]>();
		Queue<int[]> docsQ = makeDocsQ(docLen, docs, printNum);
		
		while(true) {
			if(docsQ.size() == 0 ) break;
			int[] doc = docsQ.poll();
			if(checkQ(doc, docsQ)) {
				docsQ.add(doc);
			}else {
				printQ.add(doc);
			}
		}
		return printQ;
	}
	
	private static boolean checkQ(int[] chk, Queue<int[]> chkQ) {
		int len = chkQ.size();
		Queue<int[]> queue = new LinkedList<int[]>(chkQ);
		for(int i = 0; i < len; i++) {
			int[] tmp = queue.poll();
			if(tmp[0] > chk[0] ) {
				return true;
			}
		}
		return false;
	}

	private static Queue<int[]> makeDocsQ(int docLen, String[] docs, int printNum) {
		int mark = 0;
		Queue<int[]> docsQ = new LinkedList<int[]>();
		for(int i = 0; i < docLen; i++) {
			if(i == printNum)
				mark = 1;
			else
				mark = 0;
			docsQ.add(new int[]{Integer.parseInt(docs[i]), mark});
		}
		return docsQ;
	}
}
