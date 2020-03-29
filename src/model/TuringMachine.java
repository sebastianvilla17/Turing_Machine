package model;

public class TuringMachine {

	private Head c0=null;
	private Head c1;
	private Head c2;

	public TuringMachine() {
		c0 = getC0();
		c1 = medium();
		c2 = locateLast();
	}
	
	public Head getC0() {
		return c0;
	}

	public void setC0(Head c0) {
		this.c0 = c0;
	}

	

	public Head medium() {
		int half = halfPosition();
		Head medium = getC0();
		int conter = 0;
		if (half == 0) {
			medium = getC0();
		} else {
			while (conter < half) {
				medium = medium.getNextHead();
				conter++;
			}
		}

		return medium;
	}

	public int halfPosition() {

		Head current = c0;
		int length = 0;
		int half = 0;
		while (current != null) {
			length++;
			current = current.getNextHead();
		}
		half = (length) / 2;
		return half;
	}

	public Head locateLast() {

		Head current = c0;

		if (current != null) {

			while (current.getNextHead() != null) {
				current = current.getNextHead();
			}
		}

		return current;
	}
//methods responsible for inserting elements

	public char addFirst(char valor) {
		char result;
		Head tmp = new Head(valor);

		if (c0 == null) {
			setC0(tmp);
			c0 = getC0();
			result = c0.getValue();
		} else {
			tmp.setNextHead(c0);
			setC0(tmp);
			c0 = getC0();
			result = c0.getValue();
		}

		c0 = getC0();
		c1 = medium();
		c2 = locateLast();

		return result;
	}

	public char addLast(char valor) {
		char result;
		Head tmp = new Head(valor);
		if (c0 == null) {
			setC0(tmp);
			c0 = getC0();
			result = c0.getValue();
		} else {
			c2.setNextHead(tmp);
			c2=c2.getNextHead();
			result = c2.getValue();
			
		}
		c0 = getC0();
		c2 = locateLast();

		return result;
	}

	public char addMedium(char valor) {
		char result;
		Head tmp = new Head(valor);
		if (c0 == null) {
			setC0(tmp);
			c0 = getC0();
			result = c0.getValue();
		} else {
			
			
			c1.insertAfter(tmp);
			result = c1.getValue();
			
		}
		c0 = getC0();
		c1 = medium();
		c2 = locateLast();

		return result;
	}

//method responsible for reading elements

	public char read(char action) {

		char info = '#';

		if (action == '0') {
			if(c0==null) {
				info='#';
			}else {
			info = c0.getValue();
			}
		} else if (action == '1') {
			info = c1.getValue();
		} else if (action == '2') {
			info = c2.getValue();
		}


		return info;

	}

//method responsible for removing elements

	public char remove(char action) {
		char result = 'n';

		if (action == '0') {
			result = c0.getValue();
			c0 = c0.getNextHead();
		} else if (action == '1') {
			result = c1.getValue();
			c1 = c1.getNextHead();
		} else if (action == '2') {
			result = c2.getValue();
			c2 = c2.getNextHead();
		}

		c0 = getC0();
		c1 = medium();
		c2 = locateLast();
		return result;
	}

}
