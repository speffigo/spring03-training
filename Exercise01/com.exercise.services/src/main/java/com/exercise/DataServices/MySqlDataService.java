package com.exercise.DataServices;

import org.springframework.stereotype.Component;

@Component
public class MySqlDataService implements DataService {

	@Override
	public int[] retrievedata() {
		return new int[] { 1, 3, 6, 9, 22 };
	}

}
