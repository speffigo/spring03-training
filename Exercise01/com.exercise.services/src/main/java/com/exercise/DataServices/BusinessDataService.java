package com.exercise.DataServices;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class BusinessDataService {

	private DataService dataService;

	public BusinessDataService(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findmax() {
		return Arrays.stream(dataService.retrievedata()).max().orElse(0);
	}

}
