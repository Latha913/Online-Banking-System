package in.co.online.bank.mgt.ctl;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.online.bank.mgt.dto.AccountBalanceDTO;
import in.co.online.bank.mgt.dto.UserDTO;
import in.co.online.bank.mgt.exception.DuplicateRecordException;
import in.co.online.bank.mgt.form.AccountBalanceForm;
import in.co.online.bank.mgt.service.AccountBalanceServiceInt;
import in.co.online.bank.mgt.util.DataUtility;



@Controller
@RequestMapping("/ctl/accountBalance")
public class AccountBalanceCtl extends BaseCtl {

	@Autowired
	private AccountBalanceServiceInt service;
	
	@GetMapping
	public String display(HttpSession session,@RequestParam(required = false) Long id,@ModelAttribute("form") AccountBalanceForm form, Model model) {
			
		UserDTO dto=(UserDTO)session.getAttribute("user");
		AccountBalanceDTO bean=service.findByAccountNo(dto.getAccountNo());
		System.out.println(bean);
		if(bean!=null) {
			form.populate(bean);
			model.addAttribute("amount",bean.getAmount());
		}else {
			model.addAttribute("amount",0);
		}
		return "accountBalance";
	}
	
	@PostMapping
	public String submit(@Valid @ModelAttribute("form")  AccountBalanceForm form, BindingResult bindingResult,
			Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:accountBalance";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			
				if (bindingResult.hasErrors()) {
					return "accountBalance";
				}
				
				AccountBalanceDTO bean = (AccountBalanceDTO) form.getDto();
				if(bean.getId()>0) {
					service.update(bean);
					model.addAttribute("success", "AccountBalance update Successfully!!!!");
				}else {
				service.add(bean);
				model.addAttribute("success", "AccountBalance Added Successfully!!!!");
				}
				return "accountBalance";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "accountBalance";
		}
		return "";
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") AccountBalanceForm form,
			@RequestParam(required = false) String operation,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/AccountBalance/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}else if (OP_NEW.equals(operation)) {
			return "redirect:/AccountBalance";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					AccountBalanceDTO dto = new AccountBalanceDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success","Deleted Successfully!!!");
			} else {
				model.addAttribute("error","Select at least one record");
			}
		}
		AccountBalanceDTO dto=(AccountBalanceDTO)form.getDto();
		List<AccountBalanceDTO> list =service.search(dto, pageNo, pageSize);
		List<AccountBalanceDTO> totallist =service.search(dto);
		model.addAttribute("list", list);
		
		

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error","Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "AccountBalance-list";
	}
	
}
