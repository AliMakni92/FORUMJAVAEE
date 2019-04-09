package mbeans;

import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;

import Entities.User;
import Services.AccountManagementServicesLocal;
import Services.Utilities;
import Util.Utils;


@ManagedBean
@ViewScoped
public class UserManagementBean {
	private User user;
	private User userSelected = new User();
	private Boolean formVisibility = false;
	public User getUserSelected() {
		return userSelected;
	}
	public void setUserSelected(User userSelected) {
		this.userSelected = userSelected;
	}

	@ManagedProperty(value = "#{identity}")
	private Identity identity;
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public AccountManagementServicesLocal getAccountManagementServicesLocal() {
		return accountManagementServicesLocal;
	}
	public void setAccountManagementServicesLocal(AccountManagementServicesLocal accountManagementServicesLocal) {
		this.accountManagementServicesLocal = accountManagementServicesLocal;
	}

	@EJB
	private AccountManagementServicesLocal accountManagementServicesLocal;

	public String doAddUser() {
		accountManagementServicesLocal.addUser(user);
		return "/login?faces-redirect=true";
	}
	public String doRenderUpdate()
	{
		user=accountManagementServicesLocal.findUserById(((User)Utilities.getSession().getAttribute("username")).getId());
		return "/pages/Profile/editaccount?faces-redirect=true";
	}
	public String  DoUpdate() {
		
		accountManagementServicesLocal.updateProfilUser(user.getUsername(), user.getPassword(), user.getEmail());
		formVisibility = false;
		HttpSession session = Utils.getSession();
		session.setAttribute("username", user);
		return "/pages/user/home?faces-redirect=true";
					
	}


	@PostConstruct
	private void init() {
		user = new User();
		user.setRole("user");
		user.setEnabled(true);
	}
	 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Boolean getFormVisibility() {
		return formVisibility;
	}
	public void setFormVisibility(Boolean formVisibility) {
		this.formVisibility = formVisibility;
	}

}
