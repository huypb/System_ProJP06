package jsoft.j2se;

/**
 * <p>
 * Title: JP project
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2012
 * </p>
 *
 * <p>
 * Company:
 * </p>
 *
 * @author Huy
 * @version 1.0
 */
@SuppressWarnings("serial")
public class MyExceptions extends ArithmeticException {

	// constructor
	public MyExceptions() {
		super();
	}

	public MyExceptions(String message) {
		super(message);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MyExceptions myexceptions = new MyExceptions();
	}
}
