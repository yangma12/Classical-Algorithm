package DP;

import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner snScanner=new Scanner(System.in);
		
		
		//测试     2. B站教程例1（工作时间组合求赚钱最多）
		/*  int[][] time= {{1,4},{3,5},{0,6},{4,7},{3,8},{5,9},{6,10},{8,11}};
		  int[] money= {5,1,8,4,6,3,2,4};
		  System.out.print(maxMoney(time,money));*/
		 

	}
	
	//1,斐波那锲数列（下一项等于前两项之和）
	public int feibonaqie(int n) {
		if(n==0) {
			return 1;
		}
		else if(n==1) {
			return 2;
		}
		else {
			int[] result=new int[n];//用来存储每一次的状态
			result[0]=1;
			result[1]=2;
			for(int i=2;i<n;i++) {
				result[i]=result[i-1]+result[i-2];
			}
			return result[n];
		}
		
	}
	
	
	//2. B站教程例1（工作时间组合求赚钱最多）
	public static int maxMoney(int[][] time,int[] money) {
		//先找出时间上合理的最近的那个前置节点保存到数组中
		int[] prev=new int[money.length];
		prev[0]=money.length;//代表前面没有前置的节点
		for(int i=1;i< money.length;i++) {
			prev[i]=money.length;//初始化为0
			for(int j=i-1;j>=0;j--) {
				if(time[j][1]<=time[i][0]) {
					prev[i]=j;//时间不相交
					break;
				}
			}
		}
		//然后从一开始计算每一个阶段的最优状态并保存到数组中
		int[] max=new int[money.length+1];
		max[0]=money[0];
		max[money.length]=0;
		for(int i=1;i< money.length;i++) {
			//判断选和不选那个值大
			//先判断有无前置
			if(max[i-1]>(money[i]+max[prev[i]])) {//如果不选大于选
				max[i]=max[i-1];
			}
			else {
				max[i]=money[i]+max[prev[i]];
			}
			
		}
		
		return max[money.length-1];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	

}
