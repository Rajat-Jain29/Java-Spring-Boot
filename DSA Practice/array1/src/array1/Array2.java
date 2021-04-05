package array1;

import java.util.Scanner;

//Q . Given an array of integers nums, sort the array in ascending order.
public class Array2 {
	public static int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
            }
        }
        return nums;
    
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
		int b[]=new int[n];
		b=sortArray(a);
		for(int i=0;i<n;i++) {
			System.out.println(b[i]);
		}

	}

}
