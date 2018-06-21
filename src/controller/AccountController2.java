package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

enum AccountButt2 {
	EXIT, ACCOUNT, 
	MINUS_ACCOUNT, 
	LIST, 
	MINUS_LIST, 
	FIND_BY_ID, 
	FIND_BY_NAME, 
	CHANGE_PASS, 
	DELETE_ACCOUNT
}
public class AccountController2 {

	public static void main(String[] args) {
		AccountButt2[] buttons = { 
				AccountButt2.EXIT, 
				AccountButt2.ACCOUNT, 
				AccountButt2.MINUS_ACCOUNT,
				AccountButt2.LIST, 
				AccountButt2.FIND_BY_ID,
				AccountButt2.FIND_BY_NAME, 
				AccountButt2.CHANGE_PASS,
				AccountButt2.DELETE_ACCOUNT
		};
		AccountBean account;
		AccountService2 service = new AccountServiceImpl2();
		while (true) {
			AccountButt2 select = (AccountButt2) JOptionPane.showInputDialog(null, // frame
					"계좌 List 버전", // frame title
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