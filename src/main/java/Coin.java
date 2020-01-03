package com.test;

import java.util.Scanner;

public class Coin {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int A = sc.nextInt();
		int R = sc.nextInt();
		double[] dp = new double[A+R+1];
		dp[0]=1;
		for(int i=0;i<A;i++){
			for(int j=1;j<=R;j++){
				dp[i+j]=dp[i+j]+dp[i]/R;
			}
		}
		double res=0;
		for(int i=A;i<=M;i++){
			res+=dp[i];
		}
		System.out.printf("%.5f",res);
	}
	

}
