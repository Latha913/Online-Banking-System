package in.co.online.bank.mgt.form;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.online.bank.mgt.dto.BaseDTO;
import in.co.online.bank.mgt.dto.UserDTO;
import in.co.online.bank.mgt.util.DataUtility;




public class UserRegistrationForm extends BaseForm {

	@NotEmpty
	@Pattern(regexp = "(^[A-Za-z ]*)*$")
	private String firstName;
	/**
	 * Last Name of User
	 */
	@NotEmpty
	@Pattern(regexp = "(^[A-Za-z ]*)*$")
	private String lastName;

	@NotEmpty
	@Pattern(regexp="(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$")
	private String login;

	@NotEmpty
	private String gender;
	/**
	 * Password of User
	 */
	@NotEmpty
	@Pattern(regexp="(^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\S])[A-Za-z0-9\\S]{6,12})*$",message="Pattern.form.password")

	private String password;

	@NotEmpty

	private String confirmPassword;

	/**
	 * Date of Birth of User
	 */
	@NotEmpty
	private String dob;

	/**
	 * MobielNo of User
	 */
	@NotEmpty
	@Pattern(regexp="(^[7-9][0-9]{9})*$")
	private String mobileNo;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	private long accountNo;
	@Min(1)
	private long bankId;
	private String bankName;
	@NotEmpty
	private String typeOfAccount;
	@NotEmpty
	private String title;
	@NotEmpty
	private String accountName;
	@NotEmpty
	private String fax;
	@NotEmpty
	private String nationality;
	private String userImage;
	@NotEmpty
	private String emailId;
	
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
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

	public String getTypeOfAccount() {
		return typeOfAccount;
	}

	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLogin(login);
		dto.setPassword(password);
		dto.setGender(gender);
		dto.setDob(DataUtility.getDate(dob));
		dto.setMobileNo(mobileNo);
		dto.setAccountNo(accountNo);
		dto.setBankId(bankId);
		dto.setBankName(bankName);
		dto.setTypeOfAccount(typeOfAccount);
		dto.setTitle(title);
		dto.setAccountName(accountName);
		dto.setFax(fax);
		dto.setNationality(nationality);
		dto.setEmailId(emailId);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {

	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
