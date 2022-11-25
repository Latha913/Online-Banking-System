package in.co.online.bank.mgt.form;


import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.online.bank.mgt.dto.BaseDTO;
import in.co.online.bank.mgt.dto.BookTransactionDTO;
import in.co.online.bank.mgt.util.DataUtility;

public class BookTransactionForm extends BaseForm {

	@Min(1)
	private long accountNo;
	private String accHolderName;
	@NotEmpty
	private String transactionType;
	@Min(1)
	private long transactionAmount;
	private long bankId;
	private String bankName;
	@NotEmpty
	private String transactionDate;
	@NotEmpty
	private String transactionDescription;
	@NotEmpty
	private String  routing;
	
	
	
	
	public String getRouting() {
		return routing;
	}

	public void setRouting(String routing) {
		this.routing = routing;
	}

	

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	@Override
	public BaseDTO getDto() {
		BookTransactionDTO dto=new BookTransactionDTO();
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		dto.setAccountNo(accountNo);
		dto.setAccHolderName(accHolderName);
		dto.setTransactionType(transactionType);
		dto.setTransactionAmount(transactionAmount);
		dto.setBankId(bankId);
		dto.setBankName(bankName);
		dto.setTransactionDate(DataUtility.getDate(transactionDate));
		dto.setTransactionDescription(transactionDescription);
		dto.setRoutingNo(routing);
		
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		BookTransactionDTO dto=(BookTransactionDTO)bDto;
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		accountNo=dto.getAccountNo();
		accHolderName=dto.getAccHolderName();
		transactionType=dto.getTransactionType();
		transactionAmount=dto.getTransactionAmount();
		routing=dto.getRoutingNo();
		bankId=dto.getBankId();
		bankName=dto.getBankName();
		transactionDate=DataUtility.getDateString(dto.getTransactionDate());
		transactionDescription=dto.getTransactionDescription();
	}

}
