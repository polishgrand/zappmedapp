package org.zappmed.app.core;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.zappmed.app.model.xml.Note;
import org.zappmed.app.model.xml.Subtransaction;
import org.zappmed.app.model.xml.Transaction;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class PDFFromObject {
    private Document documentPDF = new Document(PageSize.A4, 50, 50, 25, 25);
    private LocalDateTime today = LocalDateTime.now();

    private String filePath = today.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"))+ ".pdf";
    private String baseFontPath = "font/arial.ttf";

    private static BaseFont font;
    private static Font titleFont;
    private static Font defaultFont;

    public Document generatePDFFromObject(ObjectFromXMLGenerator objectFromXMLGenerator, Map<String,Object> baseProductMap) {

        try {
            fontGenerator();
            PdfWriter.getInstance(documentPDF, new FileOutputStream("lista_wysylkowa_" + objectFromXMLGenerator.getModel().getRange().getSection().toLowerCase() + "_" + filePath));
            addMeta();
            documentPDF.open();
            addContent(objectFromXMLGenerator, baseProductMap);
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

    private void addContent(ObjectFromXMLGenerator objectFromXMLGenerator, Map<String,Object> baseProductMap) {
        try {
            documentPDF.add(new Paragraph("Lista wysyłkowa: " +
                    objectFromXMLGenerator.getModel().getRange().getSection(), titleFont));
            documentPDF.add(addLineSeparator());
            documentPDF.add(Chunk.NEWLINE);

            for (Transaction transaction : objectFromXMLGenerator.getModel().getTransaction()) {
                Paragraph transactionParagraph = new Paragraph();
                transactionParagraph.setLeading(15);
                transactionParagraph.setFont(defaultFont);
                transactionParagraph.add(addTransactionToPDF(transaction));
                if (transaction.getSubtransactions() != null) {
                    transactionParagraph.add(addDottedLineSeparator());
                    for (Subtransaction subtransaction : transaction.getSubtransactions().getSubtransaction()) {
                        transactionParagraph.add(addSubtransactionToPDF(subtransaction));
                        String orderDescription = "produkt nieznany";
                        if (baseProductMap.get(subtransaction.getOrderId()) != null){
                            orderDescription = baseProductMap.get(subtransaction.getOrderId()).toString();
                        }
                        transactionParagraph.add(orderDescription);
                        transactionParagraph.add(Chunk.NEWLINE);
                    }
                }
                if (transaction.getNotes() != null) {
                    transactionParagraph.add(addDottedLineSeparator());
                    for (Note note : transaction.getNotes().getNote()) {
                        transactionParagraph.add(addNoteToPDF(note));
                    }
                }
                transactionParagraph.add(new LineSeparator());
                transactionParagraph.setKeepTogether(true);
                documentPDF.add(transactionParagraph);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private Paragraph addTransactionToPDF(Transaction transaction) {
        return transaction.toPDFString();
    }

    private Paragraph addSubtransactionToPDF(Subtransaction subtransaction) {
        return subtransaction.toPDFString();
    }

    private Paragraph addNoteToPDF(Note note) {
        return note.toPDFString();
    }

    private Paragraph addLineSeparator() {
        Paragraph paragraph = new Paragraph();
        paragraph.add(new LineSeparator());
        return paragraph;
    }

    private Paragraph addDottedLineSeparator() {
        Paragraph paragraph = new Paragraph();
        paragraph.add(new DottedLineSeparator());
        return paragraph;
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
