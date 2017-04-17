package net.tp.spring.controller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import net.tp.spring.model.DrctDbtTxInf;

import java.util.Map;

public class MyClient {
    private Service service;
    private JAXBContext jc;

    private static final QName qname = new QName("", "");
    private static final String url = "http://127.0.0.1:8085";

    public MyClient() {
        try {
            jc = JAXBContext.newInstance(DrctDbtTxInf.class);
        } catch (JAXBException je) {
            System.out.println("Cannot create JAXBContext " + je);
        }
    }

    /*La fonction qui permet de Crée l’animal identifié par {id}*/
    public void addTransaction(String trans) throws JAXBException {
        service = Service.create(qname);
        service.addPort(qname, HTTPBinding.HTTP_BINDING, url + "/depot");
        Dispatch<Source> dispatcher = service.createDispatch(qname, Source.class, Service.Mode.MESSAGE);
        Map<String, Object> requestContext = dispatcher.getRequestContext();
        requestContext.put(MessageContext.HTTP_REQUEST_METHOD, "POST");
        Source result = dispatcher.invoke(new JAXBSource(jc, trans));
        printSource(result);
    }
    
    public void printSource(Source s) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.transform(s, new StreamResult(System.out));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) throws Exception {
        MyClient client = new MyClient();
        client.addTransaction("<DrctDbtTxInf><PmtId>REF OPE PPPP</PmtId><InstdAmt>180.38</InstdAmt>"
				+ "<DrctDbtTx><MndtRltdInf><MndtId>MANDAT NO 111123</MndtId>"
				+ "<DtOfSgntr>2015-01-01</DtOfSgntr></MndtRltdInf></DrctDbtTx><DbtrAgt><FinInstnId>"
				+ "<BIC>ABNRTRPP</BIC></FinInstnId></DbtrAgt><Dbtr><Nm>Mr Debiteur N13</Nm></Dbtr><DbtrAcct><Id>"
				+ "<IBAN>FR7630001007941234567856490</IBAN></Id></DbtrAcct><RmtInf>Facture N13</RmtInf>"
				+ "</DrctDbtTxInf>");
    }
}
