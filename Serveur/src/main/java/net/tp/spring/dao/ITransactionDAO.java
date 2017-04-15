package net.tp.spring.dao;

import java.util.List;

import net.tp.spring.model.DrctDbtTxInf;
import net.tp.spring.model.DrctDbtTxInfResume;

public interface ITransactionDAO {

	public void add(DrctDbtTxInf DrctDbtTxInf);
	
	public DrctDbtTxInf get(String pmtId);
	
	public List<DrctDbtTxInf> list();
	
	public List<DrctDbtTxInfResume> listResume();
}
