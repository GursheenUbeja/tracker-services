package com.expensetracker.trackerRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.expensetracker.model.Expenditure;

@Repository
@Component
public interface ExpenditureRepository extends MongoRepository<Expenditure, String> {
	

}
