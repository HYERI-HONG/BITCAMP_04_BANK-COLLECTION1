package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

enum MemberButt {
	EXIT, ADD,JOIN, LIST, FIND_BY_ID, FIND_BY_NAME,UPDATE, REMOVE
}

public class MemberController {
	public static void main(String[] args) {
		MemberButt[] memberbuttons = { MemberButt.EXIT, MemberButt.ADD, MemberButt.JOIN, MemberButt.LIST, MemberButt.FIND_BY_ID,
				MemberButt.FIND_BY_NAME, MemberButt.UPDATE, MemberButt.REMOVE

		};
		MemberService service = new MemberServiceImpl();
		MemberBean member;
		while (true) {
			switch ((MemberButt) JOptionPane.showInputDialog(null, "멤버 Map 버전", "메뉴를 선택하시오", JOptionPane.QUESTION_MESSAGE, null,
					memberbuttons, memberbuttons[0])) {
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
						JOptionPane.showMessageDialog(null,service.map());
						break;
					case FIND_BY_ID:
						member = new MemberBean();
						member.setUid(JOptionPane.showInputDialog("아이디"));
						JOptionPane.showMessageDialog(null, service.findById(member).toString());
						break;
					case FIND_BY_NAME:
						JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름").toString()));
						break;
					case UPDATE:
						member = new MemberBean();
						member.setUid(JOptionPane.showInputDialog("아이디"));
						member.setPass(JOptionPane.showInputDialog("기존 비밀번호")+ "/" + JOptionPane.showInputDialog("새 비밀번호"));
						service.updatePassword(member);
						break;
					case REMOVE:
						member = new MemberBean();
						member.setUid(JOptionPane.showInputDialog("아이디"));
						service.deleteMember(member);
						break;
			}
		}
	}
}
