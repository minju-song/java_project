package co.yedam.generic;
import java.util.*;

class User{
	private String id;
	private String pw;
	
	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		
//	}
}

public class MapExe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Map: 키 & 값
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("송민주", 26);
		map.put("전재민", 25);
		map.put("손흥민", 32);
		
		List<User> users = new ArrayList<>();
		users.add(new User("user1","1234"));
		
		Map<String, String> userMap = new HashMap<>();
		userMap.put("user2", "2222");
		userMap.put("user3", "3333");
		userMap.put("user4", "4444");
		
		System.out.print("아이디 입력>> ");
		String id = sc.next();
		if(userMap.containsKey(id)) {
			System.out.print("비밀번호 입력>> ");
			String pw = sc.next();
			if(userMap.get(id).equals(pw)) System.out.println("로그인성공");
			else System.out.println("로그인 실패");
		}
		else System.out.println("없는 아이디");
		
		Set<String> keyset = userMap.keySet();
		for(String key : keyset) {
			System.out.println(key+": "+userMap.get(key));
		}
		
		//map
		Map<User, String> umap = new HashMap<>();
		umap.put(new User("user1","1111"), "홍길동");
		umap.put(new User("user2","2222"), "김길동");
		umap.put(new User("user3","3333"), "박길동");
		
		String name = umap.get(new User("user1","1111"));
		System.out.println("name: "+name);
	}
}
