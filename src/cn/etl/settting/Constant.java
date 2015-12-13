package cn.etl.settting;

public class Constant {
	public static final int []PAGE_SIZE={3,6,3,3,3,3};
	   public static final String[] TABLE={"News","Teacher","Admin"};
	   public static int getTable(String className)
	   {
		   for(int i=0;i<TABLE.length;i++)
			   if(TABLE[i].equals(className)) return i;
		   return -1;
	   }
}
