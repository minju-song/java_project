package co.yedam.interfaces;
import java.util.*;

public class MainExe implements Dao {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Dao dao = new OracleDao();
		boolean run = true;
		while(run) {	
			System.out.println();
			System.out.println("-------------[연락처]-------------");
			System.out.println("1.추가  2.조회  3.수정  4.삭제  5.종료");
			System.out.println("---------------------------------");
			System.out.print(">> ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				dao.insert();
				break;
			case 2:
				dao.select();
				break;
			case 3:
				dao.update();
				break;
			case 4:
				dao.delete();
				break;
			case 5:
				System.out.println("프로그램 종료");
				run = false;
				break;
			default:
					System.out.println("잘못 선택하였습니다.");
			}
	
		}
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}
}
