package in.co.online.bank.mgt.form;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.online.bank.mgt.dto.BaseDTO;
import in.co.online.bank.mgt.dto.FundTransferDTO;
import in.co.online.bank.mgt.util.DataUtility;

public class FundTransferForm extends BaseForm {

	private long byAccountNo;
	private String byAccHolderName;
	private String transferDate;
	
	private String benAccountNo;
	private String benAccHolderName;
	private String bankName;

	private String routing;
	
	private String traAmount;
	private String status;
	
	
	
	

	public long getByAccountNo() {
		return byAccountNo;
	}

	public void setByAccountNo(long byAccountNo) {
		this.byAccountNo = byAccountNo;
	}

	public String getByAccHolderName() {
		return byAccHolderName;
	}

	public void setByAccHolderName(String byAccHolderName) {
		this.byAccHolderName = byAccHolderName;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	
	
	public String getBenAccountNo() {
		return benAccountNo;
	}

	public void setBenAccountNo(String benAccountNo) {
		this.benAccountNo = benAccountNo;
	}

	public void setTraAmount(String traAmount) {
		this.traAmount = traAmount;
	}

	public String getBenAccHolderName() {
		return benAccHolderName;
	}

	public void setBenAccHolderName(String benAccHolderName) {
		this.benAccHolderName = benAccHolderName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getRouting() {
		return routing;
	}

	public void setRouting(String routing) {
		this.routing = routing;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getTraAmount() {
		return traAmount;
	}

	@Override
	public BaseDTO getDto() {
		FundTransferDTO dto=new FundTransferDTO();
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		dto.setByAccountNo(byAccountNo);
		dto.setByAccHolderName(byAccHolderName);
		dto.setTransferDate(DataUtility.getDate(transferDate));
		dto.setBenAccountNo(DataUtility.getLong(benAccountNo));
		dto.setBenAccHolderName(benAccHolderName);
		dto.setBankName(bankName);
		dto.setRouting(routing);
		dto.setTraAmount(DataUtility.getLong(traAmount));
		dto.setStatus(status);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		FundTransferDTO dto=(FundTransferDTO)bDto;
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		byAccountNo=dto.getByAccountNo();
		byAccHolderName=dto.getByAccHolderName();
		transferDate=DataUtility.getDateString(dto.getTransferDate());
		benAccountNo=String.valueOf(dto.getBenAccountNo());
		benAccHolderName=dto.getBenAccHolderName();
		bankName=dto.getBankName();
		routing=dto.getRouting();
		traAmount=String.valueOf(dto.getTraAmount());
		status=dto.getStatus();
	}

}
