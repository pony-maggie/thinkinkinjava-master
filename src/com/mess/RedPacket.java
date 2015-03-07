package com.mess;

import java.text.*;
import java.util.*;

/*
 * �����������ԭ��:
 * 1 ָ��������ÿ���˶����ֵ�
 * 2 ��С�����0.01Ԫ
 * 3 ÿ�����쵽�Ľ��һ�㲻��ͬ�����������̫��
 */
public class RedPacket 
{
	double totalMoney = 0.0;
	int peopleDistributingNum = 0;
	double[] arrayForEveryonesMoney;
	final static double MIN_MONEY = 0.01;
	
	private void calculateRedPacketScheme()
	{
		double moneyLimit = 0;
		double moneyCurrentDistributing = 0;
		Random random = new Random();
		int i = 0;
		
		System.out.print("Enter Money you want to distribute: ");
		Scanner scanner = new Scanner(System.in);
	
		totalMoney = scanner.nextDouble();
		
		System.out.print("How many people you want to distribute: ");
		peopleDistributingNum = scanner.nextInt();
		arrayForEveryonesMoney = new double[peopleDistributingNum];
		
		
		for(i = 1; i < peopleDistributingNum; i++)
		{
			moneyLimit = (totalMoney - (peopleDistributingNum - i)*MIN_MONEY)/(peopleDistributingNum - i);
			moneyCurrentDistributing = random.nextInt((int)(moneyLimit*100))%((int)((moneyLimit-MIN_MONEY)*100)+1) + (MIN_MONEY*100);//[1, moneyLimit]
			moneyCurrentDistributing /= 100;
			arrayForEveryonesMoney[i-1] = moneyCurrentDistributing;
			totalMoney -= moneyCurrentDistributing;
		}
		arrayForEveryonesMoney[i-1] = totalMoney;
	}
	
	private void showRedPacketScheme()
	{
		DecimalFormat decimaFormat = new DecimalFormat(".##");
		decimaFormat.applyPattern("0.00");
		
		for(int i = 1; i <= peopleDistributingNum; i++)
		{
			System.out.println("�� " + i + "�����: " + decimaFormat.format(arrayForEveryonesMoney[i-1]) + "Ԫ");
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		RedPacket redPacket = new RedPacket();
		redPacket.calculateRedPacketScheme();
		redPacket.showRedPacketScheme();
	}

}
