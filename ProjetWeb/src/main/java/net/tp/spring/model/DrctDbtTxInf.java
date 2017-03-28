package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DrctDbtTxInf")
public class DrctDbtTxInf {

	@XmlElement
	String PmtId;

	@XmlElement
	double InstdAmt;
	
	@XmlElement
	DrctDbtTx DrctDbtTx;
	
	@XmlElement
	DbtrAgt DbtrAgt;
	
	@XmlElement
	Dbtr Dbtr;
	
	@XmlElement
	DbtrAcct DbtrAcct;
	
	@XmlElement
	String RmtInf;

	public DrctDbtTxInf() {
		
	}

	public DrctDbtTxInf(String pmtId, double instdAmt, DrctDbtTx drctDbtTx,
			DbtrAgt dbtrAgt, Dbtr dbtr, DbtrAcct dbtrAcct,
			String rmtInf) {
		super();
		PmtId = pmtId;
		InstdAmt = instdAmt;
		DrctDbtTx = drctDbtTx;
		DbtrAgt = dbtrAgt;
		Dbtr = dbtr;
		DbtrAcct = dbtrAcct;
		RmtInf = rmtInf;
	}
	
	public String getId(){
		return this.PmtId;
	}
	
}
