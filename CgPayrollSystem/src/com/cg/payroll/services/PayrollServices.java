package com.cg.payroll.services;
import java.util.List;

import com.cg.payroll.bean.Associate;
import com.cg.payroll.exceptions.AssociateDetailNotfoundException;
public interface PayrollServices 
{
int acceptAssociateDetails(String firstName,String lastName,String emailId,String department,String designation,String pancard,int yearlyinvestmentunder80C,int basicSalary,int epf,int companyPf,int accountNumber,String bankName,String ifscCode);
int calculateNetSalary(int associateId) throws  AssociateDetailNotfoundException;
Associate getAssociateDetails(int associateId) throws AssociateDetailNotfoundException;
List<Associate>getAllAssociateDetails();
}
