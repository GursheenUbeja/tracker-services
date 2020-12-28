package com.expensetracker.trackersController;

import java.util.Map;

import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.trackerservice.MonthlyReportService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/monthlyReportService")

public class MonthlyReportController {
	@Inject
	private MonthlyReportService monthlyReportService;

	@GetMapping("/getMonhtlyReport")
	public String getDistributionData() {
		String result = "";
		try {
			result = formatIntoJson(monthlyReportService.getReport());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}

	private String formatIntoJson(Map<String, Integer> all) throws JSONException {

		JSONArray jsonArr = new JSONArray();

		JSONArray jArrTitle = new JSONArray();

		jArrTitle.put("Month");
		jArrTitle.put("Expenses");
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
