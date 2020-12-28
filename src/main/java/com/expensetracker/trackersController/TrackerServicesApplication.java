package com.expensetracker.trackersController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.expensetracker.trackerRepository.ExpenditureRepository;


@SpringBootApplication(scanBasePackages = { "com.expensetracker.trackerRepository",
		"com.expensetracker.trackersController", "com.expensetracker.trackerservice" })
public class TrackerServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackerServicesApplication.class, args);
	}

}
