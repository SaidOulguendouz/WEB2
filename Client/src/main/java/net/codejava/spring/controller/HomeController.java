package net.codejava.spring.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Controller
public class HomeController {
	
	@RequestMapping(value={"/","/home"})
	public ModelAndView homePage(ModelAndView model) throws IOException{
		
		model.setViewName("home");
		
		return model;
	}
	
	@RequestMapping(value="/detail")
	public ModelAndView transactionDetails(ModelAndView model) throws IOException, SAXException, ParserConfigurationException{
        
		model.addObject("listTransactions", getRequest("https://sepabank.herokuapp.com/detail"));
		model.setViewName("transactionDetail");
		
		return model;
	}
	
	@RequestMapping(value="/resume")
	public ModelAndView transactionResume(ModelAndView model) throws IOException, SAXException, ParserConfigurationException{
        
		model.addObject("listTransactions", getRequest("https://sepabank.herokuapp.com/resume"));
		model.setViewName("transactionResume");
		
		return model;
	}
	
	@RequestMapping(value="/stats")
	public ModelAndView transactionStats(ModelAndView model) throws IOException, SAXException, ParserConfigurationException{
        
		model.addObject("statistiques", getRequest("https://sepabank.herokuapp.com/stats"));
		model.setViewName("transactionStats");
		
		return model;
	}
	
	@RequestMapping(value="/search")
	public ModelAndView searchTransaction(ModelAndView model) throws IOException{
		
		model.setViewName("searchTransaction");
		
		return model;
	}
	
	@RequestMapping(value="/depot")
	public ModelAndView depotTransaction(ModelAndView model) throws IOException{
		
		model.setViewName("depotTransaction");
		
		return model;
	}
	
	public Document getRequest(String url) throws IOException, SAXException, ParserConfigurationException{
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

        return (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder()
	            .parse(new InputSource(new StringReader(response.toString())));
	}
	
	public Document postRequest(String url, String xml) throws IOException, SAXException, ParserConfigurationException{
		
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type",
                "application/xml;charset=utf-8");
        String urlParameters = xml;
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
        return (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder()
	            .parse(new InputSource(new StringReader(response.toString())));
	}
	
	
}
