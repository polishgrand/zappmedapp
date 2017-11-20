package org.zappmed.app.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;
import org.zappmed.app.model.xml.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ObjectFromXMLGenerator {

    private Transactions model;

    public Transactions getModel() {
        return model;
    }

    public void generateModelFromXML() {
        ObjectMapper objectMapper = new XmlMapper();
        try {
            model = objectMapper.readValue(
                    StringUtils.toEncodedString(Files.readAllBytes(Paths.get("C:\\Users\\polishgrand\\Documents\\GitHub\\zappmedapp\\app\\src\\main\\resources\\test_data.xml")), StandardCharsets.UTF_8),
                    Transactions.class);
            completeModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void completeModel() {
        for (Transaction transaction : model.getTransaction()) {
            if (transaction.getSubtransactions() == null) {
                Subtransactions subtransactions = new Subtransactions();
                Subtransaction subtransaction = new Subtransaction();

                subtransaction.setName(transaction.getName());
                subtransaction.setOrderId(transaction.getOrderId());
                subtransaction.setTransactionID(transaction.getId());

                List<Subtransaction> subtransactionList = new ArrayList<>();
                subtransactionList.add(subtransaction);

                subtransactions.setSubtransaction(subtransactionList);
                transaction.setSubtransactions(subtransactions);
            }

            if (transaction.getPositions() != null && transaction.getSubtransactions() != null) {
                List<Subtransaction> subtransactionList = transaction.getSubtransactions().getSubtransaction();
                List<Position> positionList = transaction.getPositions().getPosition();

                for (int i = 0; i<subtransactionList.size(); i++) {
                    subtransactionList.get(i).setQuantity(positionList.get(i).getQuantity());
                }
            }
        }
    }

    public void displayModel() {
        System.out.println(model.getRange().toString());

        int counterTransaction=1;
        for (Transaction transaction : model.getTransaction()) {
            System.out.println(counterTransaction + ": " + transaction.toString());
            transaction.setTransactionID(counterTransaction);
            if (transaction.getSubtransactions() != null) {
                System.out.println();
                for (Subtransaction subtransaction : transaction.getSubtransactions().getSubtransaction()) {
                    System.out.println(subtransaction.toString());
                }
            }
            if (transaction.getPositions() != null) {
                System.out.println();
                for (Position position : transaction.getPositions().getPosition()) {
                    System.out.println(position.toString());
                }
            }
            if (transaction.getNotes() != null) {
                System.out.println();
                for (Note note : transaction.getNotes().getNote()) {
                    System.out.println(note.toString());
                }
            }
            counterTransaction++;
            System.out.println();
        }
    }
}
