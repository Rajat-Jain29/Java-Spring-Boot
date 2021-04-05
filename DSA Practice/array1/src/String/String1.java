package String;

import java.util.Scanner;

//Q.Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
//
//Given a balanced string s, split it in the maximum amount of balanced strings.
//
//Return the maximum amount of split balanced strings.

public class String1 {
	
	 public static int balancedStringSplit(String s) {
	        int i = 0, diff = 0, answer = 0;
	        while(i < s.length()){
	            if(s.charAt(i) == 'L') diff++;
	            else diff--;
	            if(diff == 0) answer++;
	            i++;
	        }
	        return answer;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		String n=sc.next();
		System.out.println(balancedStringSplit(n));
		

	}

}
