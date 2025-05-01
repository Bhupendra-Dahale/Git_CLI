package o_date_pickers_hidden_options;

import java.util.Arrays;

public class FindSmallerNumberinArray {

	public static void main(String[] args) {
	
		//removing dollor sign
		
		String price="$200.98";
		String price1=price.replace("$","");  // remove the dollor sign
		System.out.println(Double.parseDouble(price1)); //converted to number
		
		//find smallest number in array
		
		int a[]= {500,400,100,200,700};
		
//		Arrays.sort(a);
		//OR
		int temp=0;
		for(int i=0; i<a.length ;i++) {
			for(int j=1; j<a.length; j++) {
				if(a[j-1]>a[j]) {
					temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
		}
		
		System.out.println("smallest number:"+a[0]);
		
		System.out.println("$"+a[0]);
		
	}

}
