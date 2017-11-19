package org.zappmed.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zappmed.app.core.ObjectFromXMLGenerator;
import org.zappmed.app.core.PDFFromObject;
import org.zappmed.app.model.xml.Transaction;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

		ObjectFromXMLGenerator objectFromXMLGenerator = new ObjectFromXMLGenerator();
		objectFromXMLGenerator.generateModelFromXML();

		objectFromXMLGenerator.displayModel();

		PDFFromObject pdfFromObject = new PDFFromObject();
		pdfFromObject.generatePDFFromObject(objectFromXMLGenerator);

	}
}