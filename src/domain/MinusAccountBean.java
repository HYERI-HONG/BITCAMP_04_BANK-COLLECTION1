package domain;

public class MinusAccountBean extends AccountBean {
	public final static String ACCOUNT_TYPE="마이너스통장";
	public int limit;
	
	public void setLimit(String limit) {
		this.limit = Integer.parseInt(limit);
	}
	public int getLimit() {
		return limit;
	}
	public String toString() {
		
		return String.format("%s \n %s \n 이름: %s\n 계좌번호: %s\n 생성날짜: %s\n 아이디 : %s\n비밀번호 : ****\n대출 한도 : %d\n", BANK_NAME, ACCOUNT_TYPE, name, accountNum,
				createDate,uid,limit);
	}
}
