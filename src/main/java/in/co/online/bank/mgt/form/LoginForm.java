package in.co.online.bank.mgt.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


import in.co.online.bank.mgt.dto.BaseDTO;
import in.co.online.bank.mgt.dto.UserDTO;




public class LoginForm extends BaseForm {

	@NotEmpty
	private String login;

	@NotEmpty
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setLogin(login);
		dto.setPassword(password);
		
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		UserDTO dto=(UserDTO)bDto;
		login=dto.getLogin();
		password=dto.getPassword();
	}

	

}
