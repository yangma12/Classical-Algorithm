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
		 
		
		//测试     3，B站教程例3（数字组合相加为要求值，求这个组合）
		int[] a= {3,34,4,12,5,2};
		System.out.print(jioacheng3(a,9));
		

	}
	
	//1, 斐波那锲数列（下一项等于前两项之和）
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
	
	
	//3. B站教程例3（数字组合相加为要求值，求这个组合）
	public static boolean jioacheng3(int[] arr,int num) {
		//定义用来存储状态的二维数组，行代表arr中的数字，列代表0到num个状态
		//arr.length个阶段，每个阶段有num个状态，下一个阶段要用到上一个阶段的状态但是不一定是最优状态（这里是和贪心的区别）
		boolean[][] subset=new boolean[arr.length][num+1];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<num+1;j++) {
				subset[i][j]=false;
			}
		}
		//第一列初始化，因为每一列都可以不选等于0
		for(int j=0;j<arr.length;j++) {
			subset[j][0]=true;
		}
		subset[0][arr[0]]=true;
		
		//初始化完毕，开始一个一个给数组赋值吧
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<num+1;j++) {
				if(arr[i]>j) {
					subset[i][j]=subset[i-1][j];
				}
				else {
					subset[i][j]=(subset[i-1][j-arr[i]]||subset[i-1][j]);
				}
			}
		}
		return subset[arr.length-1][num];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	

}
