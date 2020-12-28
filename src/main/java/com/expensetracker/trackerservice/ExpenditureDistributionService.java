package com.expensetracker.trackerservice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.expensetracker.model.Expenditure;
import com.expensetracker.trackerRepository.ExpenditureRepository;

@Service
public class ExpenditureDistributionService {

	@Inject
	private ExpenditureRepository expenditureRepo;

	public Map<String, Long> getAll() {
		List<Expenditure> eList = expenditureRepo.findAll();
		Map<String, Long> eMap = eList.stream().collect(Collectors.groupingBy(Expenditure::getCategory, Collectors.counting()));
		return eMap; 
	}

}
