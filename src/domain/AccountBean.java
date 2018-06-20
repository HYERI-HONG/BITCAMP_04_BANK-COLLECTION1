package domain;

public class AccountBean {
	public static final String BANK_NAME = "비트뱅크";
	public final static String ACCOUNT_TYPE = "기본통장";
	protected int money;
	protected String name, uid, pass, newPass, createDate, accountType, accountNum;

	public void setMoney(String money) {
		this.money = Integer.parseInt(money);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public int getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public String getUid() {
		return uid;
	}

	public String getPass() {
		return pass;
	}

	public String getCreateDate() {
		return createDate;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getAccountNum() {
		return accountNum;
	}
	public String toString() {
		
		return String.format("%s \n %s \n 이름: %s\n 계좌번호: %s\n 생성날짜: %s\n 아이디 : %s\n비밀번호 : ****\n\n", BANK_NAME, ACCOUNT_TYPE, name, accountNum,
				createDate,uid);
	}
}