package com.test;


public class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] list = new int [101];

        int n = sc.nextInt();

        int k = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            for(int j = start; j <= end; j++) {
                list[j + 50] ++;
            }
        }
        sc.close();
        int minIndex = -1;
        int maxIndex = -1;
        for(int i = 0; i < list.length; i++) {
            if(list[i] >= k) {
                minIndex = i - 50;
                break;
            }
        }
        for(int i = list.length - 1; i >= 0; i--) {
            if(list[i] >= k) {
                maxIndex = i - 50;
                break;
            }
        }
        if(minIndex == -1)
            System.out.println("error");
        else 
            System.out.println(minIndex + " " + maxIndex);
    }
}
