package org.zappmed.app.core;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.xml.simpleparser.NewLineHandler;
import org.zappmed.app.model.xml.Note;
import org.zappmed.app.model.xml.Subtransaction;
import org.zappmed.app.model.xml.Transaction;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class PDFFromObject {
    private Document documentPDF = new Document(PageSize.A4, 50, 50, 25, 25);
    private LocalDateTime today = LocalDateTime.now();
    private String filePath = "C:\\Users\\polishgrand\\Documents\\GitHub\\zappmedapp\\app\\src\\main\\resources\\test_" +
            today.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"))+ ".pdf";
    private String baseFontPath = "C:\\Users\\polishgrand\\Documents\\GitHub\\zappmedapp\\app\\src\\main\\resources\\arial.ttf";
    private static BaseFont font;
    private static Font titleFont;
    private static Font defaultFont;

    public Document generatePDFFromObject(ObjectFromXMLGenerator objectFromXMLGenerator) {

        try {
            fontGenerator();
            PdfWriter.getInstance(documentPDF, new FileOutputStream(filePath));
            addMeta();
            documentPDF.open();
            addContent(objectFromXMLGenerator);
            documentPDF.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void  addMeta() {
        documentPDF.addAuthor("ZAPP-MED");
        documentPDF.addCreator("Dynamically generated from Allegro XML file");
        documentPDF.addTitle("Lista wysyłkowa " + today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    private void addContent(ObjectFromXMLGenerator objectFromXMLGenerator) {
        try {
            documentPDF.add(new Paragraph("Lista wysyłkowa: " +
                    objectFromXMLGenerator.getModel().getRange().getSection(), titleFont));
            addLineSeparator();

            for (Transaction transaction : objectFromXMLGenerator.getModel().getTransaction()) {
                addTransactionToPDF(transaction);
                if (transaction.getSubtransactions() != null) {
                    addDottedLineSeparator();
                    for (Subtransaction subtransaction : transaction.getSubtransactions().getSubtransaction()) {
                        addSubtransactionToPDF(subtransaction);
                    }
                }
                if (transaction.getNotes() != null) {
                    addDottedLineSeparator();
                    for (Note note : transaction.getNotes().getNote()) {
                        addNoteToPDF(note);
                    }
                }
                addLineSeparator();
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void addTransactionToPDF(Transaction transaction) {
        try {
            Paragraph recipientData = new Paragraph();
            recipientData.setFont(defaultFont);
            recipientData.add(transaction.toPDFString());
            documentPDF.add(recipientData);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void addSubtransactionToPDF(Subtransaction subtransaction) {
        try {
            Paragraph subtransactionData = new Paragraph();
            subtransactionData.setFont(defaultFont);
            subtransactionData.add(subtransaction.toPDFString());
            documentPDF.add(subtransactionData);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void addNoteToPDF(Note note) {
        try {
            Paragraph noteData = new Paragraph();
            noteData.setFont(defaultFont);
            noteData.add(note.toPDFString());
            documentPDF.add(noteData);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void addLineSeparator() {
        Paragraph paragraph = new Paragraph();
        paragraph.add(new LineSeparator());
        paragraph.add(Chunk.NEWLINE);

        try {
            documentPDF.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void addDottedLineSeparator() {
        Paragraph paragraph = new Paragraph();
        paragraph.add(new DottedLineSeparator());
        paragraph.add(Chunk.NEWLINE);

        try {
            documentPDF.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void addEmptyLine(int number) {
        Paragraph paragraph = new Paragraph();
        for (int i = 0; i < number; i++) {
            paragraph.add(Chunk.NEWLINE);
        }
        try {
            documentPDF.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void fontGenerator() {
        try {
            font = BaseFont.createFont(baseFontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        titleFont = new Font(font, 18, Font.NORMAL);
        defaultFont = new Font(font, 10, Font.NORMAL);
    }
}
