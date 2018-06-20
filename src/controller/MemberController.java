package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

enum MemberButt {
	EXIT,
	JOIN, ADD,
	LIST,FIND_BY_ID, FIND_BY_NAME,COUNT, 
	UPDATE, 
	WITHDRAWAL
}

public class MemberController {
	public static void main(String[] args) {
		MemberButt[] buttons = { 
				MemberButt.EXIT, 
				MemberButt.JOIN, 
				MemberButt.ADD, 
				MemberButt.LIST, 
				MemberButt.FIND_BY_ID,
				MemberButt.FIND_BY_NAME,
				MemberButt.COUNT, 
				MemberButt.UPDATE, 
				MemberButt.WITHDRAWAL

		};
		MemberService service = new MemberServiceImpl();
		MemberBean member;
		while (true) {
			switch ((MemberButt) JOptionPane.showInputDialog(null, 
					"메뉴", "메뉴를 선택하시오", 
					JOptionPane.QUESTION_MESSAGE, 
					null, buttons, buttons[0])) {
			case EXIT:
				return;
			case JOIN:
				member= new UserBean();
				member.setName(JOptionPane.showInputDialog("이름 : "));
				member.setSsn(JOptionPane.showInputDialog("주민 번호 : "));
				member.setAddr(JOptionPane.showInputDialog("주소 : "));
				member.setPhone(JOptionPane.showInputDialog("연락처 : "));
				member.setEmail(JOptionPane.showInputDialog("이메일 : "));
				member.setUid(JOptionPane.showInputDialog("아이디 : "));
				member.setPass(JOptionPane.showInputDialog("비밀 번호 : "));
				service.createUser((UserBean) member);
				break;
			case ADD:
				member= new StaffBean();
				member.setName(JOptionPane.showInputDialog("이름 : "));
				member.setSsn(JOptionPane.showInputDialog("주민 번호 : "));
				member.setAddr(JOptionPane.showInputDialog("주소 : "));
				member.setPhone(JOptionPane.showInputDialog("연락처 : "));
				member.setEmail(JOptionPane.showInputDialog("이메일 : "));
				member.setUid(JOptionPane.showInputDialog("아이디 : "));
				member.setPass(JOptionPane.showInputDialog("비밀 번호 : "));
				service.createStaff((StaffBean) member);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null,service.list());
				break;
			case FIND_BY_ID:
				break;
			case FIND_BY_NAME:
				break;
			case COUNT:
				break;
			case UPDATE:
				break;
			case WITHDRAWAL:
				break;
			}
		}
	}
}
