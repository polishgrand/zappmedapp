package org.zappmed.app.gui.main;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.zappmed.app.core.ObjectFromXMLGenerator;
import org.zappmed.app.core.PDFFromObject;
import org.zappmed.app.core.products.ProductBase;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
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
        $$$setupUI$$$();
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
                fileChooser.setCurrentDirectory(new File("."));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON Files", "json");
                fileChooser.setFileFilter(filter);
                int returnVal = fileChooser.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
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
                fileChooser.setCurrentDirectory(new File("."));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
                fileChooser.setFileFilter(filter);
                int returnVal = fileChooser.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
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
        pathJSON.setText(new File("database.json").getAbsolutePath());

        pathXML = new JTextField();
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(3, 3, new Insets(10, 10, 10, 10), -1, -1));
        mainPanel.setOpaque(true);
        labelJSONPath = new JLabel();
        labelJSONPath.setText("Plik JSON:");
        mainPanel.add(labelJSONPath, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mainPanel.add(pathJSON, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        labelXMLPath = new JLabel();
        labelXMLPath.setText("Plik XML:");
        mainPanel.add(labelXMLPath, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mainPanel.add(pathXML, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        buttonJSONPath = new JButton();
        buttonJSONPath.setFocusPainted(false);
        buttonJSONPath.setText("...");
        mainPanel.add(buttonJSONPath, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonXMLPath = new JButton();
        buttonXMLPath.setFocusPainted(false);
        buttonXMLPath.setText("...");
        mainPanel.add(buttonXMLPath, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonGeneratePDF = new JButton();
        buttonGeneratePDF.setFocusPainted(false);
        buttonGeneratePDF.setText("Generuj listę wysyłkową");
        mainPanel.add(buttonGeneratePDF, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        labelAppVersion = new JLabel();
        labelAppVersion.setEnabled(false);
        Font labelAppVersionFont = this.$$$getFont$$$(null, -1, 10, labelAppVersion.getFont());
        if (labelAppVersionFont != null) labelAppVersion.setFont(labelAppVersionFont);
        labelAppVersion.setText("ver 1.0");
        mainPanel.add(labelAppVersion, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_SOUTHEAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
