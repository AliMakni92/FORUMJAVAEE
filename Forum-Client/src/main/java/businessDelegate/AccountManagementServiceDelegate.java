package businessDelegate;

import java.util.ArrayList;
import java.util.List;

import Entities.ResponsibilityOf;
import Entities.User;
import ServiceLocator.ServiceLocator;
import Services.AccountManagementServicesRemote;

public class AccountManagementServiceDelegate {
	private static String jndiName = "Forum-ear/Forum-ejb/AccountManagementServices!Services.AccountManagementServicesRemote";

	public static AccountManagementServicesRemote getProxy() {
		return (AccountManagementServicesRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

	public static Boolean doAddUser(User user) {
		return getProxy().addUser(user);
	}

	public static void doUpdateUser(User user) {
		getProxy().updateUser(user);
	}

	public static User dofindUserById(Integer id) {
		return getProxy().findUserById(id);
	}

	public static void dodeleteUser(User user) {
		getProxy().deleteUser(user);
	}

	public static void dodeleteUserById(Integer id) {
		getProxy().deleteUserById(id);
	}

	public static List<User> dofindAllUser() {
		return getProxy().findAllUser();
	}

	public static ArrayList<User> dolistAlphabetically(ArrayList<User> users) {
		return getProxy().listAlphabetically(users);
	}

	public static List<User> dofindAllUserByResponsibilityOf(ResponsibilityOf responsibleOf) {
		return getProxy().findAllUserByResponsibilityOf(responsibleOf);
	}

	public static List<User> dofindAllUserByRole(String role) {
		return getProxy().findAllUserByRole(role);
	}

	public static User dofindUserByUsername(String username) {
		return getProxy().findUserByUsername(username);
	}

	public static User doAuthentification(String username, String password) {
		return getProxy().Authentification(username, password);
	}

	public static User dofindUserByEmail(String email) {
		return getProxy().findUserByEmail(email);
	}

	public static User dofindUserByPassword(String password) {
		return getProxy().findUserByPassword(password);
	}

	public static void updateUser(Integer id, String username, String password, String role) {
		getProxy().updateUser(id, username, password, role);
	}

	public static void updateUser1(Integer id, String username, String password, String role, ResponsibilityOf responsibleOf) {
		getProxy().updateUser1(id, username, password, role, responsibleOf);
	}

	public static Boolean updateUser(Integer id, String role) {
		return getProxy().updateUser(id, role);
	}

	public static void blocUser(boolean en, int id) {
		getProxy().blocUser(en, id);
	}

	public static boolean updateProfilModerator(String username, String password, String email) {
		return getProxy().updateProfilModerator(username, password, email);
	}

	public static List<User> findAllUserNotAdmin(String admin) {
		return getProxy().findAllUserNotAdmin(admin);
	}

	public static List<User> findAllUserNotAdminAndModerator(String user) {
		return getProxy().findAllUserNotAdminAndModerator(user);
	}

	public static List<User> findAllUserNotAdminAndUser(String moderator) {
		return getProxy().findAllUserNotAdminAndUser(moderator);
	}

	public static User updateUser1(Integer id, ResponsibilityOf responsibleOf) {
		return getProxy().updateUser1(id, responsibleOf);
	}
	
}
