package com.cg.banking.services;

import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.AccountDAOImpl;
import com.cg.banking.exception.AccountBlockedException;
import com.cg.banking.exception.AccountNotFoundException;
import com.cg.banking.exception.BankingServiceDownException;
import com.cg.banking.exception.InsufficientAmountException;
import com.cg.banking.exception.InvalidAccountTypeException;
import com.cg.banking.exception.InvalidAmountException;
import com.cg.banking.exception.InvalidPinNumberException;

public class BankingServicesImpl implements BankingServices {
AccountDAO service = new AccountDAOImpl();
Transaction transaction =new Transaction();
Account account;
	@Override
	public Account openAccount(String accountType, float initBalance)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServiceDownException {
		// TODO Auto-generated method stub
		Account account = new Account(accountType,initBalance);
		account=service.save(account);
		return account;
	}

	

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
			AccountNotFoundException, InvalidPinNumberException, BankingServiceDownException, AccountBlockedException {
		Account account = service.findOne(accountNo);
		if(pinNumber==account.getPinNumber())
		{
			account = service.findOne(accountNo);
			float finalAmount=account.getAccountBalance()-amount;
			account.setAccountBalance(finalAmount);
			return finalAmount;
		}
		else
			throw new InvalidPinNumberException();
		
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServiceDownException, AccountBlockedException {
		withdrawAmount(accountNoFrom,transferAmount,pinNumber);
		depositAmount(accountNoFrom,transferAmount);
		return true;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServiceDownException {
		Account account=service.findOne(accountNo);
		
		return account;
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServiceDownException {
		// TODO Auto-generated method stub
		
		return service.findAll();
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws AccountNotFoundException, BankingServiceDownException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String accountStatus(long accountNo)
			throws AccountNotFoundException, BankingServiceDownException, AccountNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public float depositAmount(long accountNumber, float amount)
			throws AccountNotFoundException, BankingServiceDownException, AccountBlockedException {
		Account account = service.findOne(accountNumber);
		float finalAmount=account.getAccountBalance()+amount;
		account.setAccountBalance(finalAmount);
		return finalAmount;
	}

}
