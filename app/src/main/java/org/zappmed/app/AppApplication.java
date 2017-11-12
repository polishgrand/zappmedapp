package org.zappmed.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zappmed.app.core.ObjectFromXMLGenerator;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

		ObjectFromXMLGenerator objectFromXMLGenerator = new ObjectFromXMLGenerator();

		objectFromXMLGenerator.generateModelFromXML();

		System.out.println(objectFromXMLGenerator.getModel().getRange().toString());
	}
}
