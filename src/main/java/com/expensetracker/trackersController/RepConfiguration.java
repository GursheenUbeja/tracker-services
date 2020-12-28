package com.expensetracker.trackersController;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.expensetracker.trackerRepository.ExpenditureRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = ExpenditureRepository.class)
public class RepConfiguration {

}
