package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DrctDbtTxInf")
public class DrctDbtTxInf {

	int id;
	
	String Num;
	
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

	public DrctDbtTxInf(int id, String num,String pmtId, double instdAmt, DrctDbtTx drctDbtTx,
			DbtrAgt dbtrAgt, Dbtr dbtr, DbtrAcct dbtrAcct,
			String rmtInf) {
		super();
		this.id = id;
		Num = num;
		PmtId = pmtId;
		InstdAmt = instdAmt;
		DrctDbtTx = drctDbtTx;
		DbtrAgt = dbtrAgt;
		Dbtr = dbtr;
		DbtrAcct = dbtrAcct;
		RmtInf = rmtInf;
	}
	
	public String getPmtId(){
		return this.PmtId;
	}

	public String getNum() {
		return Num;
	}

	public double getInstdAmt() {
		return InstdAmt;
	}

	public DrctDbtTx getDrctDbtTx() {
		return DrctDbtTx;
	}
	
}
