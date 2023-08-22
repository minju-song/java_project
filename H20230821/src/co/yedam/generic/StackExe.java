package co.yedam.generic;

import java.util.*;

//Stack: LastInFirstOut - LIFO
public class StackExe {
	public static void main(String[] args) {
		
		System.out.println("STACK");
		Stack<String> stack = new Stack<>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		int idx=1;
		while(!stack.isEmpty()) {
			String str = stack.pop();
			System.out.println(idx+") "+str);
			idx++;
		}
		
		System.out.println();
		System.out.println("QUEUE");
		Queue<String> que = new LinkedList<>();
		que.offer("A");
		que.offer("B");
		que.offer("C");
		
		idx=1;
		while(!que.isEmpty()) {
			String str = que.poll();
			System.out.println(idx+") "+str);
			idx++;
		}
		
	}
}
