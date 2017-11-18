package org.zappmed.app.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

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

    public Note() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Note{" +
                "transactionId='" + transactionId + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
