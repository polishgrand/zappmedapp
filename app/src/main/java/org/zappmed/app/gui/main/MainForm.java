package org.zappmed.app.gui.main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;
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

    public MainForm() {

        JFrame frame = new JFrame("ZappMed");
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
    }

}
