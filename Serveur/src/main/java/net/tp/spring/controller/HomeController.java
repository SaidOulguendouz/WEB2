package net.tp.spring.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 
 * @author www.tp.net
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView homePage(ModelAndView model) throws IOException{
		
            String url = "http://localhost:8085/SEPA/depot";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type",
                    "application/xml;charset=utf-8");
            String urlParameters = "<DrctDbtTxInf><PmtId>REF OPE XXXX</PmtId><InstdAmt>180.38</InstdAmt>"
    				+ "<DrctDbtTx><MndtRltdInf><MndtId>MANDAT NO 111128</MndtId>"
    				+ "<DtOfSgntr>2016-01-01</DtOfSgntr></MndtRltdInf></DrctDbtTx><DbtrAgt><FinInstnId>"
    				+ "<BIC>ABNRTRPP</BIC></FinInstnId></DbtrAgt><Dbtr><Nm>Mr Debiteur N13</Nm></Dbtr><DbtrAcct><Id>"
    				+ "<IBAN>FR7630001007941234567856379</IBAN></Id></DbtrAcct><RmtInf>Facture N17</RmtInf>"
    				+ "</DrctDbtTxInf>";
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("response:" + response.toString());
        
		model.setViewName("home");
		
		return model;
	}
}
