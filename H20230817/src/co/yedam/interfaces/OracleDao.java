package co.yedam.interfaces;

public class OracleDao implements Dao{

	public void add() {
		
	}
	
	

	@Override
	public void update() {
		System.out.println("Oracle 수정기능");
		
	}

	@Override
	public void delete() {
		System.out.println("Oracle 삭제기능");
		
	}

	@Override
	public void select() {
		System.out.println("Oracle 조회기능");
		
	}

	@Override
	public void insert() {
		System.out.println("Oracle 추가기능");
		
	}


	
}
