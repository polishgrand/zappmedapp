package org.zappmed.app.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.itextpdf.text.Paragraph;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Note {
    @JacksonXmlProperty(localName = "transactionId")
    private String transactionId;

    @JacksonXmlProperty(localName = "Author")
    private String author;

    @JacksonXmlProperty(localName = "Date")
    private String date;

    @JacksonXmlProperty(localName = "Note")
    private String note;

    public String getTransactionId() {
        return transactionId;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "\tNote {" +
                "transactionId = '" + transactionId + '\'' +
                ",\n\t\tauthor = '" + author + '\'' +
                ",\n\t\tdate = '" + date + '\'' +
                ",\n\t\tnote = '" + note + "\' }";
    }

    public Paragraph toPDFString() {

        Paragraph noteParagraph = new Paragraph();
        if (author != null) {
            noteParagraph.add(date + " " + author + ":\n");
        }

        noteParagraph.add(note);
        return noteParagraph;
    }
}
