package com.expensetracker.trackersController;

import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.expensetracker.trackerservice.ExpenditureDistributionService;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(ExpenditureDistributionController.class)
public class ExpenditureDistributionControllerTest {

	@Inject
	ExpenditureDistributionController expenditureController;

	@MockBean
	ExpenditureDistributionService expenditureService;

	@Test
	public void testExpenditureList() {
		Map<String, Long> eMap = new HashMap<String, Long>();
		eMap.put("Savings", 2L);

		Mockito.when(this.expenditureService.getAll()).thenReturn(eMap);
		String result = this.expenditureController.getDistributionData();
		assertFalse(result.isEmpty());

		assert (result.contains("Savings"));

	}

}
