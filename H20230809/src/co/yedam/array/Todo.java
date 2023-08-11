package co.yedam.array;

public class Todo {
	int no; //몇번째인지
	String todo;
	String dueDate; //0823
	boolean done; //true면 완료 false면 완료안함
	
	Todo(int no, String todo, String dueDate) {
		this.no = no;
		this.todo = todo;
		this.dueDate = dueDate;
		this.done = false;
	}
}
