package service;

import javax.swing.JOptionPane;
import domain.*;
import java.util.List;

public interface AccountService2 {
	public void createAccount(AccountBean account);
	public void createMinusAccount(MinusAccountBean account);
	public List<AccountBean> list();
	public List<AccountBean> search(String param);
	public AccountBean search(AccountBean account);
	public void update(AccountBean account);
	public void delete(AccountBean account);
	
	public String createDate();
	public String random(int start, int end);
	public String createAccountNum();
}
