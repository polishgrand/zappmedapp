package org.zappmed.app.core;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transaction {
    private String customerLogin;
    private String customerEmail;
    private String customerName;
}
