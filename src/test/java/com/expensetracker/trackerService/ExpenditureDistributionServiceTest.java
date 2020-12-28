package com.expensetracker.trackerService;

import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.expensetracker.trackerRepository.ExpenditureRepository;
import com.expensetracker.trackerservice.ExpenditureDistributionService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.expensetracker.trackersController.TrackerServicesApplication.class)
public class ExpenditureDistributionServiceTest {

	@Inject
	private ExpenditureDistributionService service;

	@MockBean
	private ExpenditureRepository repo;

	@Test
	public void testExpenditureList() {
		Map<String, Long> eMap = new HashMap<String, Long>();
		eMap.put("Savings", 2L);

		Mockito.doReturn(eMap).when(repo.findAll());
		Map<String, Long> all = this.service.getAll();
		assertFalse(all.isEmpty());

		assert (all.get("Savings").equals(2L));

	}

}
