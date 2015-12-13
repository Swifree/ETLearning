package cn.etl.test;

public class MethodTest {
	public static void main(String [] args)
	{
		System.out.println(new MethodTest().firstLetterToLowerCase("Teacher"));
	}
	private String firstLetterToLowerCase(String s) 
	{
		char[] charArray=s.toCharArray();
		if(charArray[0]<97) charArray[0]+='a'-'A';
		System.out.println(charArray);
		return String.valueOf(charArray);
	}
}
