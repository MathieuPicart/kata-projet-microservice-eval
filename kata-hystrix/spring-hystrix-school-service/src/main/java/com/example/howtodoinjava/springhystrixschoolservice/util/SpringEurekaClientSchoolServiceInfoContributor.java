package com.example.howtodoinjava.springhystrixschoolservice.util;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class SpringEurekaClientSchoolServiceInfoContributor implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("details",
				Collections.singletonMap(
						"description",
						"This is the my-finder service, which is discovery server aware, and this service will Call my-movie Microservice, for movies and actors details, which is again dicovery server aware!!! "));
	}

}
