package com.chapter4;

public class PrimitiveOverloading 
{

	static void prt(String s)
	{
		System.out.println(s);
	}
	
	void f1(char x) {prt("f1(char)");}
	void f1(byte x) {prt("f1(byte)");}
	void f1(short x) {prt("f1(short)");}
	void f1(int x) {prt("f1(int)");}
	void f1(long x) {prt("f1(long)");}
	
	void f2(byte x) {prt("f2(byte)");}
	void f2(short x) {prt("f2(short)");}
	void f2(int x) {prt("f2(int)");}
	void f2(long x) {prt("f2(long)");}
	
	void f3(short x) {prt("f3(short)");}
	void f3(int x) {prt("f3(int)");}
	void f3(long x) {prt("f3(long)");}
	
	void f4(int x) {prt("f4(int)");}
	void f4(long x) {prt("f4(long)");}
	
	void f5(int x) {prt("f5(int)");}
	void f5(long x) {prt("f5(long)");}
	
	void testConstVal()
	{
		prt("Testing with 5");
		f1(5);f2(5);f3(5);f4(5);f5(5);
	}
	
	void testChar()
	{
		char x = 'x';
		prt("char argument:");
		f1(x);f2(x);f3(x);f4(x);f5(x);
	}
	
	void testByte()
	{
		byte x = 0;
		prt("byte argument:");
		f1(x);f2(x);f3(x);f4(x);f5(x);
	}
	
	void testShort()
	{
		short x = 0;
		prt("short argument:");
		f1(x);f2(x);f3(x);f4(x);f5(x);
	}
	
	void testInt()
	{
		int x = 0;
		prt("int argument:");
		f1(x);f2(x);f3(x);f4(x);f5(x);
	}
	
	void testLong()
	{
		long x = 0;
		prt("long argument:");
		f1(x);f2(x);f3(x);f4(x);f5(x);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		PrimitiveOverloading p = new PrimitiveOverloading();
		p.testConstVal();
		p.testChar();
		p.testByte();
		p.testShort();
		p.testInt();
		p.testLong();

	}

}
