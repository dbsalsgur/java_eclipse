package org.exception;

class ExceptionEx14 {

	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println("main�޼ҵ忡�� ���ܰ� ó���Ǿ����ϴ�.");
			e.printStackTrace();
		}
	}
	static void method1 () throws Exception {
		throw new Exception();
	}

}
