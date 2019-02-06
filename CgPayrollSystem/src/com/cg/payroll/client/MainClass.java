package com.cg.payroll.client;

import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class MainClass 
{
	public static void main(String[] args)
	{

	PayrollServices services = new PayrollServicesImpl();
	
	int associateId1=services.acceptAssociateDetails("sb", "bd", "sb@gmail", "internship","intern", "sbd", 56789, 5000000, 500, 600, 114, "sbi", "ghj");
	
	System.out.println("Associate Id:"+associateId1);
int associateId2=services.acceptAssociateDetails("rd", "dz", "rd@gmail", "student","intern", "rdz", 56781, 1000000, 200, 300, 414, "pnb", "gij");
	
	System.out.println("Associate Id:"+associateId2);
	try
	{
		System.out.println(services.getAssociateDetails(102));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
	
	}
}
