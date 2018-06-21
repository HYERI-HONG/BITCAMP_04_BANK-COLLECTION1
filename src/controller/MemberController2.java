package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

enum MemberButt2 {
	EXIT,
	JOIN, ADD,
	LIST,FIND_BY_ID, 
	FIND_BY_NAME,
	UPDATE, 
	DELETE
}

public class MemberController2 {
	public static void main(String[] args) {
		MemberButt2[] buttons = { 
				MemberButt2.EXIT, 
				MemberButt2.JOIN, 
				MemberButt2.ADD, 
				MemberButt2.LIST, 
				MemberButt2.FIND_BY_ID,
				MemberButt2.FIND_BY_NAME,
				MemberButt2.UPDATE, 
				MemberButt2.DELETE

		};
		MemberService2 service = new MemberServiceImpl2();
		MemberBean member;
		while (true) {
			switch ((MemberButt2) JOptionPane.showInputDialog(null, 
					"멤버 List 버전", "메뉴를 선택하시오", 
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
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디"));
				JOptionPane.showMessageDialog(null, service.search(member).toString());
				break;
			case FIND_BY_NAME:
				JOptionPane.showMessageDialog(null, service.search(JOptionPane.showInputDialog("이름")));
				break;
			case UPDATE:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setPass(JOptionPane.showInputDialog("새 비밀번호"));
				service.update(member);
				break;
			case DELETE:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디"));
				service.delete(member);
				break;
			}
		}
	}
}
