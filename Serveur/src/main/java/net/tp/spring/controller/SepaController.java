package net.tp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.tp.spring.model.*;

@Controller
public class SepaController {
	
	private SEPA sepa;
	
	public SepaController(){
		sepa = new SEPA();
		
		sepa.addTransaction(new DrctDbtTxInf("REF OPE AAAA",1100.07, 
				new DrctDbtTx((new MndtRltdInf("MANDAT NO 55555","2009-09-01"))),
				new DbtrAgt(new FinInstnId("NOTPROVIDED")),new Dbtr("Mr Debiteur N1"), 
				new DbtrAcct(new Id("FR763004136210001234567811")),"Facture N1"));
		
		sepa.addTransaction(new DrctDbtTxInf("REF OPE BBBB",2150.08, 
				new DrctDbtTx((new MndtRltdInf("MANDAT NO 666666","1989-07-03"))),
				new DbtrAgt(new FinInstnId("BANKGBUL")),new Dbtr("Mr Debiteur N2"), 
				new DbtrAcct(new Id("GB29NWBK60161331926819")),"Facture reference ISO 654321"));
	}
	
	/*Renvoie un flux XML contenant la liste des transactions*/
	@RequestMapping(value="/resume", method = RequestMethod.GET)
	public @ResponseBody SEPA getSEPAInXML() {
		return this.sepa;
	}
	
	/*Renvoie un flux XML décrivant le détail de la transaction d’identifiant id 
	 * avec id = PmtId */
	@RequestMapping(value="/resume/{id}", method = RequestMethod.GET)
	public @ResponseBody DrctDbtTxInf getTransactionById(@PathVariable("id") String id) {
		for(DrctDbtTxInf drctDbtTxInf : sepa.getTransaction()){
			/*On supprime les espaces de PmtId et du paramètre id, et on compare avec les paramètre id*/
			if(drctDbtTxInf.getId().replaceAll("\\s+","").equals(id.replaceAll("\\s+",""))){
				return drctDbtTxInf;
			}
		}
		return null;
	}
	
	/*Reçoit un flux XML décrivant une transaction, 
	 * crée l'objet correspondant et retourne la valeur PmtId*/
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public @ResponseBody String addTransaction(@RequestBody DrctDbtTxInf drctDbtTxInf) {
		
		sepa.addTransaction(drctDbtTxInf);
		return drctDbtTxInf.getId();
	}
	
	
}