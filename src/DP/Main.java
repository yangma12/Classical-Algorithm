package DP;

import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner snScanner=new Scanner(System.in);
		
		
		//����     2. Bվ�̳���1������ʱ�������׬Ǯ��ࣩ
		/*  int[][] time= {{1,4},{3,5},{0,6},{4,7},{3,8},{5,9},{6,10},{8,11}};
		  int[] money= {5,1,8,4,6,3,2,4};
		  System.out.print(maxMoney(time,money));*/
		 
		
		//����     3��Bվ�̳���3������������ΪҪ��ֵ���������ϣ�
		int[] a= {3,34,4,12,5,2};
		System.out.print(jioacheng3(a,9));
		

	}
	
	//1, 쳲��������У���һ�����ǰ����֮�ͣ�
	public int feibonaqie(int n) {
		if(n==0) {
			return 1;
		}
		else if(n==1) {
			return 2;
		}
		else {
			int[] result=new int[n];//�����洢ÿһ�ε�״̬
			result[0]=1;
			result[1]=2;
			for(int i=2;i<n;i++) {
				result[i]=result[i-1]+result[i-2];
			}
			return result[n];
		}
		
	}
	
	
	//2. Bվ�̳���1������ʱ�������׬Ǯ��ࣩ
	public static int maxMoney(int[][] time,int[] money) {
		//���ҳ�ʱ���Ϻ����������Ǹ�ǰ�ýڵ㱣�浽������
		int[] prev=new int[money.length];
		prev[0]=money.length;//����ǰ��û��ǰ�õĽڵ�
		for(int i=1;i< money.length;i++) {
			prev[i]=money.length;//��ʼ��Ϊ0
			for(int j=i-1;j>=0;j--) {
				if(time[j][1]<=time[i][0]) {
					prev[i]=j;//ʱ�䲻�ཻ
					break;
				}
			}
		}
		//Ȼ���һ��ʼ����ÿһ���׶ε�����״̬�����浽������
		int[] max=new int[money.length+1];
		max[0]=money[0];
		max[money.length]=0;
		for(int i=1;i< money.length;i++) {
			//�ж�ѡ�Ͳ�ѡ�Ǹ�ֵ��
			//���ж�����ǰ��
			if(max[i-1]>(money[i]+max[prev[i]])) {//�����ѡ����ѡ
				max[i]=max[i-1];
			}
			else {
				max[i]=money[i]+max[prev[i]];
			}
			
		}
		
		return max[money.length-1];
	}
	
	
	//3. Bվ�̳���3������������ΪҪ��ֵ���������ϣ�
	public static boolean jioacheng3(int[] arr,int num) {
		//���������洢״̬�Ķ�ά���飬�д���arr�е����֣��д���0��num��״̬
		//arr.length���׶Σ�ÿ���׶���num��״̬����һ���׶�Ҫ�õ���һ���׶ε�״̬���ǲ�һ��������״̬�������Ǻ�̰�ĵ�����
		boolean[][] subset=new boolean[arr.length][num+1];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<num+1;j++) {
				subset[i][j]=false;
			}
		}
		//��һ�г�ʼ������Ϊÿһ�ж����Բ�ѡ����0
		for(int j=0;j<arr.length;j++) {
			subset[j][0]=true;
		}
		subset[0][arr[0]]=true;
		
		//��ʼ����ϣ���ʼһ��һ�������鸳ֵ��
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
