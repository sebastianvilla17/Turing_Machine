package model;

public class Head {

	private char value;
	private Head nextHead;

	public Head(char value) {

		this.value = value;
	}

	public char getValue() {
		return value;
	}

	public Head getNextHead() {
		return nextHead;
	}

	public void setNextHead(Head nextHead) {
		this.nextHead = nextHead;
	}
	
	public void insertAfter(Head insert) {
		
		insert.nextHead= nextHead;
		nextHead= insert;
	}
}
