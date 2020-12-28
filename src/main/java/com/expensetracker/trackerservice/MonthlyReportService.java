package com.expensetracker.trackerservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.expensetracker.model.Expenditure;
import com.expensetracker.trackerRepository.ExpenditureRepository;

@Service
public class MonthlyReportService {

	@Inject
	private ExpenditureRepository expenditureRepo;

	public Map<String, Integer> getReport() {
		List<Expenditure> eList = expenditureRepo.findAll();
		Map<String, Integer> purchase = new HashMap<String, Integer>();
		eList.stream().forEach(ele -> {
			String pDate = ele.getPrurchaseDate();
			String[] split = pDate.split("-");
			if (purchase.containsKey(split[1])) {
				purchase.put(split[1], ele.getAmount() + purchase.get(split[1]));

			} else {
				purchase.put(split[1], ele.getAmount());
			}

		});
		return purchase;
	}

}
