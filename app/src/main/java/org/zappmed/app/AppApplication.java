package org.zappmed.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zappmed.app.core.ObjectFromXMLGenerator;
import org.zappmed.app.core.PDFFromObject;
import org.zappmed.app.core.products.ProductBase;
import org.zappmed.app.gui.main.MainForm;

import javax.swing.*;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		ObjectFromXMLGenerator objectFromXMLGenerator = new ObjectFromXMLGenerator();
//		objectFromXMLGenerator.generateModelFromXML();
//		objectFromXMLGenerator.displayModel();
//
//		ProductBase productBase = new ProductBase();
//		productBase.generateMap();
//
//		PDFFromObject pdfFromObject = new PDFFromObject();
//		pdfFromObject.generatePDFFromObject(objectFromXMLGenerator, productBase.getBaseProductMap());

		MainForm mainForm = new MainForm();

	}
}