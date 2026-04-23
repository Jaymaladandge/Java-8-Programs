package com.functionalPrograms;

public class ArmstrongNumber {

    public static void main(String[] args) {

    		
    		int num = 1635, sum = 0;
    		String[] arr = String.valueOf(num).split("");
    		int len = arr.length;
    		
    		for(int i = 0; i<len; i++) {
    			int n = Integer.valueOf(arr[i]);
    			int a = 1; 
    			for(int j = 0; j<len; j++) {
    				a = a*n;
    			}
    			sum = sum + a;
    		}
    		if(num==sum)
    			System.out.println("Armstrong");
    		else
    			System.out.println("Not Armstrong");
    	
    	System.out.println("-------------------------");
    	
    	
        int num1 = 164;
        int a = 0;
        String s = String.valueOf(num1);
        char[] ch = s.toCharArray();

        for (int i = 0; i <= ch.length - 1; i++) {
        	
            int b = Integer.valueOf(String.valueOf(ch[i]));
            System.out.println("======"+b);
            int n = b;

            for (int j = 1; j <= ch.length - 1; j++) {
                b = b * n;
            }
            a = a + b;
        }
        String result = (num1 == a) ? "Armstrong number : " + s : "Not Armstrong number : " + s;
        System.out.println(result);

        System.out.println("--------------------------------------------------");

        int number = 9474;
        String s1 = String.valueOf(number);
        int sum1 = 0;

        for (int i = 1; i <= s1.length(); i++) {
            int c = number % 10;
            int d = c;

            for (int j = 1; j <= ch.length - 1; j++) {
                d = d * c;
            }
            sum1 = sum1 + d;
            number = number / 10;
        }
        result = (number == sum1 ) ? "Armstrong number : " + number : "Not Armstrong number : " + number;
        System.out.println(result);

    }

}
