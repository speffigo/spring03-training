package com.exercise.DataServices;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbDataService implements DataService {

	@Override
	public int[] retrievedata() {
		return new int[] { 2, 4, 5, 79, 89 };
	}

}
