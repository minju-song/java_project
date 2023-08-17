package co.yedam.inheritance;

public class MainExe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CellPhone cell = new CellPhone();
		cell.setModel("cellphone");
		cell.setColor("black");
		cell.turnOn();
		cell.turnOff();
		
		DmbCellPhone dmb = new DmbCellPhone();
		dmb.setModel("DMB1100");
		dmb.setColor("white");
		dmb.turnOn();
		dmb.turnOnBmb();
		dmb.turnOff();
	
		
		CellPhone cell2 = new DmbCellPhone();
		cell2.turnOn(); 
//		cell2.turnOnBmb(); 불가능
		
		if(cell2 instanceof DmbCellPhone) {			
			DmbCellPhone dmb2 = (DmbCellPhone) cell2;
			dmb2.turnOnBmb();
		}
		
		if(cell instanceof DmbCellPhone) {			
			DmbCellPhone dmb3 = (DmbCellPhone) cell;
			dmb3.turnOnBmb();
		}
		
		CellPhone[] phones = new CellPhone[5];
		phones[0] = cell;
		phones[1] = dmb;
		phones[0].turnOn(); // CellPhone 인스턴스
		phones[1].turnOn(); // DmbCellPhone 인스턴스
		
		
		System.out.println(phones[0].getModel());
		System.out.println(phones[1].getColor());
		
	}

}
