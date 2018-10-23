package com.universita.corsica.nomadaccomodationfinder;

import com.universita.corsica.nomadaccomodationfinder.enums.TypeProperty;
import com.universita.corsica.nomadaccomodationfinder.model.Property;
import com.universita.corsica.nomadaccomodationfinder.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class NomadaccomodationfinderApplication {

	@Autowired
	private PropertyService propertyService;

	public static void main(String[] args) {

		SpringApplication.run(NomadaccomodationfinderApplication.class, args);

		/**
		 * TESTS
		 */

	}

}
