package net.tp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.tp.spring.dao.ITransactionDAO;
import net.tp.spring.model.*;

@Controller
public class SepaController {
	
	@Autowired
	protected ITransactionDAO transactionDAO;
	
	private SEPA sepa;
	
	private SEPAResume sepaResume;
	
	public SepaController(){
		sepa = new SEPA();
		
		sepaResume = new SEPAResume();
		
	}
	
	/*Renvoie un flux XML contenant la liste des transactions détaillées*/
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public @ResponseBody SEPA getSEPAInXML() {
		this.sepa.setTransactions(transactionDAO.list());
		return this.sepa;
	}
	
	/*Renvoie un flux XML contenant la liste des transactions résumées*/
	@RequestMapping(value="/resume", method = RequestMethod.GET)
	public @ResponseBody SEPAResume getSEPAInXMLResume() {
		this.sepaResume.setTransactions(transactionDAO.listResume());
		return this.sepaResume;
	}
	
	/*Affiche une synthèse des transactions stockées, avec les informations suivantes :
	 * Nombre de transactions, montant total des transactions*/
	@RequestMapping(value="/stats", method = RequestMethod.GET)
	public @ResponseBody Statistique getSEPAStats() {
		return transactionDAO.getStats();
	}
	
	/*Renvoie un flux XML décrivant le détail de la transaction d’identifiant id 
	 * avec id = PmtId */
	@RequestMapping(value="/trx/{id}", method = RequestMethod.GET)
	public @ResponseBody DrctDbtTxInf getTransactionById(@PathVariable("id") String id) {
		return transactionDAO.get(id);
	}
	
	/*Reçoit un flux XML décrivant une transaction, 
	 * crée l'objet correspondant et retourne la valeur PmtId*/
	@RequestMapping(value="/depot", method = RequestMethod.POST)
	public @ResponseBody String addTransaction(@RequestBody DrctDbtTxInf drctDbtTxInf) {
		
		sepa.addTransaction(drctDbtTxInf);
		return drctDbtTxInf.getPmtId();
	}
	
	
}