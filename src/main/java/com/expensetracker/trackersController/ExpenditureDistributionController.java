package com.expensetracker.trackersController;

import java.util.Map;

import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.trackerservice.ExpenditureDistributionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/expenditureDistributionService")

public class ExpenditureDistributionController {

	@Inject
	private ExpenditureDistributionService expenditureService;

	@GetMapping("/getDistributionData")
	public String getDistributionData() {
		String result = "";
		try {
			result = formatIntoJson(expenditureService.getAll());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}

	private String formatIntoJson(Map<String, Long> all) throws JSONException {

		JSONArray jsonArr = new JSONArray();

		JSONArray jArrTitle = new JSONArray();

		jArrTitle.put("Cateory");
		jArrTitle.put("Total");
		jsonArr.put(jArrTitle);
		all.entrySet().stream().forEach(ele -> {
			JSONArray jArr = new JSONArray();
			jArr.put(ele.getKey());
			jArr.put(ele.getValue());
			jsonArr.put(jArr);
		});

		return jsonArr.toString();
	}

}
