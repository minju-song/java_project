package co.yedam.inheritance;

public class DmbCellPhone extends CellPhone{
	private int channel;
	
	
	
	public void turnOnBmb() {
		System.out.println("DMB폰을 켭니다.");
	}
	

	@Override
	public void turnOn() {
		System.out.println(getModel()+"의 전원을 켭니다.");
	}
	
	
}
