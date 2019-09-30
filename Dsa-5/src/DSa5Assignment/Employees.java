package DSa5Assignment;

class EmpNode{
	String name;
	int age;
	int salary;
	EmpNode nextEmployee;
	EmpNode(String name , int age ,int salary){
		this.age = age;
		this.salary = salary;
		this.name = name;
		this.nextEmployee = null;
	}
}

public class Employees {
	
	EmpNode headEmloye = null;
	
	void insertIntoEmployee(String name , int salary , int age){
		EmpNode newNode = new EmpNode(name , age , salary);
		if(headEmloye == null){
			headEmloye = newNode;
		}
		else{
			EmpNode Temp = headEmloye;
			while(Temp.nextEmployee != null){
				Temp = Temp.nextEmployee;
			}
			Temp.nextEmployee = newNode;
		}
	}
	
	void printList(){
		EmpNode temp = this.headEmloye;
		while(temp!=null){
			System.out.println(temp.name+" = name" + " - age = " + temp.age + " - salary = "+temp.salary);
			temp = temp.nextEmployee;
		}
	}
	
	void SortTheList(){
		EmpNode i = this.headEmloye.nextEmployee;
		EmpNode j = this.headEmloye;
		while(i!=null){
			int age = i.age;
			int salary = j.salary;
			while(j!=null){
				
			}
			
			i = i.nextEmployee;
		}
		
	}
	
	public static void main(String args[]){
		Employees E = new Employees();
		E.insertIntoEmployee("R", 1, 12);
		E.insertIntoEmployee("i", 2, 12);
		E.insertIntoEmployee("v", 1, 10);
		E.insertIntoEmployee("a", 3, 14);
		E.insertIntoEmployee("k", 4, 13);
		E.insertIntoEmployee("s", 5, 15);
		E.printList();
	}
}

