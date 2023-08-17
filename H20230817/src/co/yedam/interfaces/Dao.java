package co.yedam.interfaces;

public interface Dao {
	//규칙선언
	static final double pi = 3.14;
	
	abstract void insert();
	void update();
	void delete();
	void select();
}
