package get2019.dsaAssingment2;

public class Main {

	public static void main(String[] args) {
		
		StackImplementation Obj = new StackImplementation();
	

		Obj.push("9");
		Obj.push("-");
		Obj.push(")");
		Obj.push("4");
		Obj.push("-");
		Obj.push("3");
		Obj.push("^");
		Obj.push("2");
		Obj.push("(");
		Obj.push("*");
		Obj.push("2");
		Obj.push("+");
		Obj.push("1");
	
//		Obj.push(")");
//		Obj.push("2");
//		Obj.push("*");
//		Obj.push("1");
//		Obj.push("(");
//		Obj.push("+");
//		Obj.push("2");

		
		Obj.display();
		//System.out.println("Top Element->"+Obj.peak());
		Obj.convertToPostfix();
	}

}
