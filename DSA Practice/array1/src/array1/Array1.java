package array1;

import java.util.Scanner;

//Q.1 An array is monotonic if it is either monotone increasing or monotone decreasing.

//An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

//Return true if and only if the given array A is monotonic.

public class Array1 {
	
	public static boolean isMonotonic(int[] A) {
        int f=0,a=0;
        for(int i=0;i<A.length-1;i++){
                if(A[i] <=A[i+1]   ){
                    f++;
                }
            if(A[i] >=A[i+1])
                {
                    a++;
                }
        }
        if(f==A.length-1 || a==A.length-1){
           return true;
        }
        else{
            return false;
        }
        
    }

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter values");
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		System.out.println(isMonotonic(a));

	}

}
