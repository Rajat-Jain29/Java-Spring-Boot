package String;

import java.util.Scanner;

//Q. Given a string s and an integer array indices of the same length.

//The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.

//Return the shuffled string.

public class String2 {
	public static String restoreString(String s, int[] indices) {
	    char [] str = s.toCharArray();
	        for(int i=0; i < s.length(); i++){
	            str[indices[i]] = s.charAt(i);
	        }
	        return new String(str);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] indices = { 4,5,6,7,0,2,1,3 };
		System.out.println(  restoreString("codeleet",  indices)    );
		

	}

}
