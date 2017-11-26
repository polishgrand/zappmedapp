package org.zappmed.app.gui.main;

import org.zappmed.app.core.ObjectFromXMLGenerator;
import org.zappmed.app.core.PDFFromObject;
import org.zappmed.app.core.products.ProductBase;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MainForm {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 150;

    private String imageIconPath = "/img/zappmed_icon.jpg";

    private JPanel mainPanel;
    private JLabel labelJSONPath;
    private JTextField pathJSON;
    private JTextField pathXML;
    private JButton buttonJSONPath;
    private JButton buttonXMLPath;
    private JButton buttonGeneratePDF;
    private JLabel labelXMLPath;
    private JLabel labelAppVersion;

    private ProductBase productBase;
    private ObjectFromXMLGenerator objectFromXMLGenerator;
    private PDFFromObject pdfFromObject;

    public MainForm() {

        JFrame frame = new JFrame("Zapp-Med");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        InputStream imgStream = MainForm.class.getResourceAsStream(imageIconPath);
        BufferedImage imageIcon = null;
        try {
            imageIcon = ImageIO.read(imgStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setIconImage(imageIcon);
        frame.setContentPane(mainPanel);
        frame.setVisible(true);

        //listeners
        buttonJSONPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON Files", "json");
                fileChooser.setFileFilter(filter);
                int returnVal = fileChooser.showOpenDialog(frame);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " +
                            fileChooser.getSelectedFile().getName());
                    pathJSON.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        buttonXMLPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
                fileChooser.setFileFilter(filter);
                int returnVal = fileChooser.showOpenDialog(frame);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " +
                            fileChooser.getSelectedFile().getName());
                    pathXML.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }


        });

        buttonGeneratePDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productBase = new ProductBase();
                productBase.setFileJSON(new File(pathJSON.getText()));
                productBase.generateMapFromFile();

                objectFromXMLGenerator = new ObjectFromXMLGenerator();
                objectFromXMLGenerator.setFileXML(new File(pathXML.getText()));
                objectFromXMLGenerator.generateModelFromXMLFile();

                pdfFromObject = new PDFFromObject();
                pdfFromObject.generatePDFFromObject(objectFromXMLGenerator, productBase.getBaseProductMap());

            }
        });
    }

    private void createUIComponents() {
        pathJSON = new JTextField();
        pathJSON.setText(new java.io.File("database.json").getAbsolutePath());

        pathXML = new JTextField();
        //pathXML.setText(new java.io.File("").getAbsolutePath());
    }

}
