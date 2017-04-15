package net.tp.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.tp.spring.model.Dbtr;
import net.tp.spring.model.DbtrAcct;
import net.tp.spring.model.DbtrAgt;
import net.tp.spring.model.DrctDbtTx;
import net.tp.spring.model.DrctDbtTxInf;
import net.tp.spring.model.DrctDbtTxInfResume;
import net.tp.spring.model.FinInstnId;
import net.tp.spring.model.Id;
import net.tp.spring.model.MndtRltdInf;

public class TransactionDAO implements ITransactionDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public TransactionDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*Ajouter une nouvelle transaction à la base de données*/
	@Override
	public void add(DrctDbtTxInf DrctDbtTxInf) {
		
	}

	/*Rechercher une transaction identifiée par pmtId dans la base de données*/
	@Override
	public DrctDbtTxInf get(String pmtId) {
		String sql = "SELECT * FROM transaction WHERE PmtId='" + pmtId +"'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<DrctDbtTxInf>() {

			public DrctDbtTxInf extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					return new DrctDbtTxInf(rs.getInt("transaction_id"),
							rs.getString("num"),rs.getString("PmtId"),rs.getDouble("InstdAmt"), 
							new DrctDbtTx((new MndtRltdInf(rs.getString("MndtId"),rs.getString("DtOfSgntr")))),
							new DbtrAgt(new FinInstnId(rs.getString("BIC"))),new Dbtr(rs.getString("Nm")), 
							new DbtrAcct(new Id(rs.getString("IBAN"))),rs.getString("RmtInf"));
				}
				
				return null;
			}
			
		});
	}

	/*Liste de toutes les transactions détaillées*/
	@Override
	public List<DrctDbtTxInf> list() {
		String sql = "SELECT * FROM transaction";
		List<DrctDbtTxInf> listTransactions = jdbcTemplate.query(sql, new RowMapper<DrctDbtTxInf>() {

			public DrctDbtTxInf mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DrctDbtTxInf(rs.getInt("transaction_id"),
						rs.getString("num"),rs.getString("PmtId"),rs.getDouble("InstdAmt"), 
						new DrctDbtTx((new MndtRltdInf(rs.getString("MndtId"),rs.getString("DtOfSgntr")))),
						new DbtrAgt(new FinInstnId(rs.getString("BIC"))),new Dbtr(rs.getString("Nm")), 
						new DbtrAcct(new Id(rs.getString("IBAN"))),rs.getString("RmtInf"));
				
			}
			
		});
		
		return listTransactions;
	}

	/*Liste de toutes les transactions résumées*/
	@Override
	public List<DrctDbtTxInfResume> listResume() {
		String sql = "SELECT * FROM transaction";
		List<DrctDbtTxInfResume> listTransactions = jdbcTemplate.query(sql, new RowMapper<DrctDbtTxInfResume>() {

			public DrctDbtTxInfResume mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DrctDbtTxInfResume(rs.getString("num"),rs.getString("PmtId"),rs.getDouble("InstdAmt"), 
						rs.getString("DtOfSgntr"));
				
			}
			
		});
		
		return listTransactions;
	}

}
