package com.interview;

public class Test1 {
	 public static void main(String[] args) {
	        System.out.println("Try programiz.pro");
	         //  StringBuffer str = new StringBuffer("Scaler by");  
	           String str = "abcba";  
	           fun(str);
	             
	     }
	     static void fun(String str1)
	     {
	         String str2="";
	       for(int i=str1.length()-1;i>=0;i--)
	       {
	          str2=str2+str1.charAt(i); 
	       }
	       System.out.println("Try programiz:"+str2);
	       if(str1.equals(str2))
	       {
	            System.out.println("Plan");
	       }
	     }
}
