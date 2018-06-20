package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.AccountService;
import serviceImpl.AccountServiceImpl;

enum AccountButt1 {
	EXIT, ACCOUNT, 
	MINUS_ACCOUNT, 
	LIST, 
	MINUS_LIST, 
	FIND_BY_ID, 
	FIND_BY_NAME, 
	CHANGE_PASS, 
	DELETE_ACCOUNT
}
public class AccountController {

	public static void main(String[] args) {
		AccountButt1[] buttons = { 
				AccountButt1.EXIT, 
				AccountButt1.ACCOUNT, 
				AccountButt1.MINUS_ACCOUNT,
				AccountButt1.LIST, 
				AccountButt1.FIND_BY_ID,
				AccountButt1.FIND_BY_NAME, 
				AccountButt1.CHANGE_PASS,
				AccountButt1.DELETE_ACCOUNT
		};
		AccountBean account;
		AccountService service = new AccountServiceImpl();
		while (true) {
			AccountButt1 select = (AccountButt1) JOptionPane.showInputDialog(null, // frame
					"선택", // frame title
					"기능을 선택하시오", // order
					JOptionPane.QUESTION_MESSAGE, // type
					null, // icon
					buttons, // Array of choices
					buttons[1]); // default
			switch (select) {
			case EXIT:
				return;
			case ACCOUNT:
				account = new AccountBean();
				account.setName(JOptionPane.showInputDialog("이름 : "));
				account.setUid(JOptionPane.showInputDialog("아이디 : "));
				account.setPass(JOptionPane.showInputDialog("비밀번호"));
				service.createAccount(account);
				break;
			case MINUS_ACCOUNT:
				account = new MinusAccountBean();
				account.setName(JOptionPane.showInputDialog("이름 : "));
				account.setUid(JOptionPane.showInputDialog("아이디 : "));
				account.setPass(JOptionPane.showInputDialog("비밀번호"));
				((MinusAccountBean) account).setLimit(JOptionPane.showInputDialog("대출 한도"));
				service.createMinusAccount((MinusAccountBean) account);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null,service.list());
				break;
			case FIND_BY_ID:
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("아이디 : "));
				JOptionPane.showMessageDialog(null,(service.search(account).toString()));
				break;
			case FIND_BY_NAME:
				JOptionPane.showMessageDialog(null,service.search(JOptionPane.showInputDialog("이름 : ")));
				break;
			case CHANGE_PASS:
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("아이디 : "));
				account.setPass(JOptionPane.showInputDialog("새 비밀번호 : "));
				service.update(account);
				break;
			case DELETE_ACCOUNT:
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("아이디 : "));
				service.delete(account);
				break;
			}

		}
	}

}