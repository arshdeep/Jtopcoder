package com.topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class TOPOSORT {
	public static void main (String[] args) throws java.lang.Exception
	{
//		class solve {
//			class node implements Comparable<node> {
//				ArrayList<Integer> adj = new ArrayList<Integer>();
//				int incout;
//				int idx;
//				public node(){}
//				public void add(int v) {
//					adj.add(v);
//				}
//				@Override
//				public int compareTo(node arg0) {
//					// TODO Auto-generated method stub
//					return this.incout - arg0.incout;
//				}
//			}
//			ArrayList<Integer> dfs(node[] list, LinkedList<Integer> res, boolean[] visit) {
//				ArrayList<Integer> result = new ArrayList<Integer>();
//				while (!res.isEmpty()) {
//					int idx = res.pollFirst();
//					if (visit[idx]) {
//						continue;
//					}
//					visit[idx] = true;
//					result.add(idx);
//					for (int v : list[idx].adj) {
//						list[v].incout--;
//						if (list[v].incout == 0) {
//							res.add(v);
//						}
//					}
//				}
//				
//				return result;
//			}
//			public void go()
//			{
//				Scanner sc = new Scanner(System.in);
//
//				int n = sc.nextInt();
//				int m = sc.nextInt();
//				node[] list = new node[n];
//
//				boolean[] visit = new boolean[m];
//				for (int i = 0; i < n; ++i) {
//					list[i] = new node();
//					list[i].idx = i;
//				}
//				for (int i = 0; i < m; ++i) {
//					int v1 = sc.nextInt() - 1;
//					int v2 = sc.nextInt() - 1;
//					
//					list[v1].add(v2);
//					list[v2].incout++;
//				}
//				LinkedList<Integer> res = new LinkedList<Integer>();
//				for (int i = 0; i < n; ++i) {
//					if (list[i].incout == 0) {
//						res.add(list[i].idx);
//					}
//				}				
//				ArrayList<Integer> r = dfs(list, res, visit);
//				if (r.size() != n) {
//					System.out.println("Sandro fails");
//				}
//				else {
//					for (int i : r) {
//						System.out.print(i + 1 + " ");
//					}
//				}
//				sc.close();
//			}
//		}
		class solve2 {
			class node implements Comparable<node> {
				ArrayList<Integer> adj = new ArrayList<Integer>();
				int start;
				int end;
				int idx;
				public void add(int v) {
					adj.add(v);
				}
				@Override
				public int compareTo(node arg0) {
					// TODO Auto-generated method stub
					return arg0.end - this.end;
				}
			}
			boolean[] visit;
			int time;
			boolean dfs(int v, node[] list) {
				visit[v] = true;
				list[v].start = time++;
				for (int i : list[v].adj) {
					if (!visit[i]) {
						if (!dfs(i, list)) {
							return false;
						}
					}
					else {
						if (list[i].end == 0) {
							return false;
						}
					}
				}
				list[v].end = time++;
				return true;
			}
			public void go()
			{
				Scanner sc = new Scanner(System.in);

				int n = sc.nextInt();
				int m = sc.nextInt();
				node[] list = new node[n];
				this.time = 1;
				visit = new boolean[m];
				for (int i = 0; i < n; ++i) {
					list[i] = new node();
					list[i].idx = i;
				}
				for (int i = 0; i < m; ++i) {
					int v1 = sc.nextInt() - 1;
					int v2 = sc.nextInt() - 1;
					
					list[v1].add(v2);
				}
				for (int i = 0; i < n; ++i) {
					if (!visit[i]) {
						if (!dfs(i, list)) {
							System.out.println("Sandro fails");
							sc.close();
							return;
						}
					}
				}
				Arrays.sort(list);
				for (node i : list) {
					System.out.print(i.idx + 1 + " ");
				}
				sc.close();
			}
		}
		solve2 s = new solve2();
		s.go();
	}
}
