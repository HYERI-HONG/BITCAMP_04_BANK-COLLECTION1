package domain;

public class MemberBean {
	protected String uid, pass, name, ssn, addr, phone,email;
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "< 회원 정보 >\n아이디 :" + uid +"\n"+ "비밀번호 : ****"  +"\n"+ "이름 :" + name +"\n"+ "주민번호 : ******-*******"+"\n"+ "주소 :" + addr
				+"\n"+ "연락처 :" +"\n"+ phone +"이메일 :"+"\n"+email+ "\n\n";
	}
	
}
	