package co.yedam.api;

import java.lang.reflect.Method;

public class ClassExe {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("co.yedam.api.Member");
			Method[] methods = cls.getDeclaredMethods();
			for(Method m : methods) {
				System.out.println(m.getName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		char[] arr = {'a','b','c','d','e'};
		String str = new String(arr);
		System.out.println(str);
	}
}
