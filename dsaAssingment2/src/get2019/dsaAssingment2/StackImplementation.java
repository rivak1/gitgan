package get2019.dsaAssingment2;

class Node {

	String data;
	Node next;
	int data1;

	Node(String data) {
		this.data = data;
		this.next = null;
	}

	Node(int data1) {
		// System.out.println(data1+"ds");
		this.data1 = data1;
		this.next = null;
	}
}

public class StackImplementation implements Stack {

	Node top;
	Node Operator;
	Node Operator1;
	Node Operand = null;

	StackImplementation() {
		this.top = null;
	}

	@Override
	public void push(String data) {
		Node newNode = new Node(data);
		if (this.isEmpty()) {
			this.top = newNode;
		} else {
			Node temp;
			temp = this.top;
			this.top = newNode;
			newNode.next = temp;
		}
	}

	public void pushOperator(String data) {
		Node newNode = new Node(data);
		if (this.isEmptyForOperator()) {
			this.Operator = newNode;
		} else {
			Node temp;
			temp = this.Operator;
			this.Operator = newNode;
			newNode.next = temp;
		}
	}

	public void pushOperator1(String data) {
		Node newNode = new Node(data);
		if (this.isEmptyForOperand()) {
			this.Operator1 = newNode;
		} else {
			Node temp;
			temp = this.Operator1;
			this.Operator1 = newNode;
			newNode.next = temp;
		}
	}

	public void pushOperand(int n) {
		Node newNode = new Node(n);
		if (this.isEmptyForOperand()) {
			this.Operand = newNode;
		} else {
			Node temp;
			temp = this.Operand;
			this.Operand = newNode;
			newNode.next = temp;
		}
	}

	@Override
	public void pop() {
		top = top.next;
	}

	public void popForOperator() {
		Operator = Operator.next;
	}

	public void popForOperator1() {
		Operator1 = Operator1.next;
	}

	public void popForOperand() {
		Operand = Operand.next;
	}

	@Override
	public String peak() {
		String data = this.top.data;
		return data;
	}

	public String peakForOperator() {
		String data = this.Operator.data;
		return data;
	}

	public String peakForOperator1() {
		String data = this.Operator1.data;
		return data;
	}

	public int peakForOperand() {
		int data = this.Operand.data1;
		return data;
	}

	@Override
	public boolean isEmpty() {
		return this.top == null;
	}

	public boolean isEmptyForOperand() {
		return this.Operand == null;
	}

	public boolean isEmptyForOperator() {
		return this.Operator == null;
	}

	public boolean isEmptyForOperator1() {
		return this.Operator1 == null;
	}

	@Override
	public void display() {
		Node temp = this.top;
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}

	public void display1() {
		Node temp = this.Operator;
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}

	public void display2() {
		Node temp = this.Operator1;
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}

	public void display3() {
		Node temp = this.Operand;
		while (temp != null) {
			System.out.print(temp.data1 + " ");
			temp = temp.next;
		}
	}

	int checkPriority(String data) {

		if (data == "^") {
			return 3;
		} else if (data == "+" || data == "-") {
			return 1;
		} else if (data == "*" || data == "/") {
			return 2;
		} else {
			return -1;
		}

	}

	int checkLetterOrDigitBracket(String data) {
		if (data.charAt(0) >= 42 && data.charAt(0) <= 47) {
			return 1;
		} else if (data.charAt(0) == '^') {
			return 1;
		} else if (data.charAt(0) >= 48 && data.charAt(0) <= 57) {
			return 2;
		} else if (data.charAt(0) == '(') {
			return 3;
		} else {
			return -1;
		}
	}

	void convertToPostfix() {
		Node temp = this.top;
		int max = -1;
		String result = "";
		while (temp != null) {
			if (this.checkLetterOrDigitBracket(temp.data) == 1) {
				if (this.isEmptyForOperator()) {
					System.out.println();
					this.pushOperator(temp.data);
				} else {

					while ((this.checkPriority(this.peakForOperator()) >= this.checkPriority(temp.data))) {
						result = result + this.peakForOperator() + " ";
						this.popForOperator();
						if (this.isEmptyForOperator()) {
							break;
						}
					}
					this.pushOperator(temp.data);
				}
			} else if (this.checkLetterOrDigitBracket(temp.data) == 2) {
				result = result + temp.data + " ";
			} else if (this.checkLetterOrDigitBracket(temp.data) == 3) {
				this.pushOperator(temp.data);
			} else if (this.checkLetterOrDigitBracket(temp.data) == -1) {
				while (!this.isEmptyForOperator() && this.peakForOperator() != "(") {

					result = result + this.peakForOperator() + " ";
					this.popForOperator();
				}
				this.popForOperator();
			}
			temp = temp.next;

		}
		System.out.println();
		result = result + this.peakForOperator()+" ";
		System.out.println(result);
		this.popForOperator();
		this.evalutionOperation(result);
	}

	private void evalutionOperation(String result) {
		int count = 0;
		String subString = "";
		String operand;
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) != ' ') {
				subString = subString + result.charAt(i);
			} else {
				int n = 0;
				if (subString.length() != 0) {
					for (int j = 0; j < subString.length(); j++) {
						n = n * 10 + (subString.charAt(j) - 48);
					}
					if ((n <= -3 && n >= -6) || n == 46) {
						this.operationOfExpression(subString);
					} else {

						this.pushOperand(n);

					}
				}
				subString = "";
			}
		}
		if(!this.isEmptyForOperator1()) {

			this.operationOfExpression( this.peakForOperator1());
		}
		this.display3();
	}

	private void operationOfExpression(String operand) {
		int val1;
		int val2;
		switch (operand) {
		case "/":
			System.out.println("div");
			val1 = this.peakForOperand();
			System.out.println(val1+"val1");
			this.popForOperand();
			val2 = this.peakForOperand();
			System.out.println(val2+"val2");
			this.popForOperand();
			this.pushOperand(val2 / val1);
			break;
		case "*":
			System.out.println("mul");
			val1 = this.peakForOperand();
			System.out.println(val1+"val1");
			this.popForOperand();
			val2 = this.peakForOperand();
			System.out.println(val2+"val2");
			this.popForOperand();
			this.pushOperand(val2 * val1);
			break;
		case "-":
			System.out.println("minus");
			val1 = this.peakForOperand();
			System.out.println(val1+"val1");
			this.popForOperand();
			val2 = this.peakForOperand();
			System.out.println(val2+"val2");
			this.popForOperand();
			this.pushOperand(val2 - val1);
			break;
		case "+":
			System.out.println("add");
			val1 = this.peakForOperand();
			System.out.println(val1+"val1");
			this.popForOperand();
			val2 = this.peakForOperand();
			System.out.println(val2+"val2");
			this.popForOperand();
			this.pushOperand(val2 + val1);
			break;
		case "^":
			System.out.println("power");
			val1 = this.peakForOperand();
			System.out.println(val1+"val1");
			this.popForOperand();
			val2 = this.peakForOperand();
			System.out.println(val2+"val2");
			this.popForOperand();
			int sum = 1;
			for (int j = 0; j < val1; j++) {
				sum = sum * val2;
			}
			this.pushOperand(sum);
			break;
		}

	}
}
