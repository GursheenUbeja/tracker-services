package com.expensetracker.trackerservice;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.expensetracker.model.Expenditure;
import com.expensetracker.trackerRepository.ExpenditureRepository;

@Service
public class AddTransactionService {

	@Inject
	private ExpenditureRepository expenditureRepo;

	public String saveTransaction(Expenditure exp) {
		try {
			Expenditure save = expenditureRepo.save(exp);
			System.out.println(save.getTransactionId());
			return "Transaction added!!";
		} catch (Exception e) {
			System.out.println("Exception caught");
			return "Transaction failed";
		}

	}

}
