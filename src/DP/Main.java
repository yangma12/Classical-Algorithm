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
		 

	}
	
	//1,쳲��������У���һ�����ǰ����֮�ͣ�
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	

}
