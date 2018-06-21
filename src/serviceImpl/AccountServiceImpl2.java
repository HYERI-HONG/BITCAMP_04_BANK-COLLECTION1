package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import domain.*;
import service.*;
//날짜 구하기
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountServiceImpl2 implements AccountService2 {
	List<AccountBean> list;
	public AccountServiceImpl2() {
		list = new ArrayList<>();
	}
	@Override
	public void createAccount(AccountBean account) {
			account.setCreateDate(createDate());
			account.setAccountNum(createAccountNum());
			list.add(account);
	}
	@Override
	public void createMinusAccount(MinusAccountBean account) {
			account.setCreateDate(createDate());
			account.setAccountNum(createAccountNum());
			list.add(account);
	}
	@Override
	public List<AccountBean> list() {
		return list;
	}

	@Override
	public List<AccountBean> search(String param) {
	List<AccountBean> temp = new ArrayList<>();
		
	for(int i=0; i<list.size(); i++) {
			if(param.equals(list.get(i).getName())) {
				temp.add(list.get(i));
			}
		}
		return temp;
	}

	@Override
	public AccountBean search(AccountBean account) {
		AccountBean temp = new AccountBean();
		for(int i =0; i<list.size(); i++) {
			if(account.getUid().equals(list.get(i).getUid())) {
				temp = list.get(i);
				break;
			}
		}
		return temp;
	}
	
	@Override
	public void update(AccountBean account) {	
		list.get(list.indexOf(search(account))).setPass(account.getPass());
	}
	
	@Override
	public void delete(AccountBean account) {
		list.remove(search(account));
		
	}
	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
		
	}
	@Override
	public String random(int start, int end) {
		String random ="";
		random = String.format("%03d", (int)(Math.random()*end)+start);
		return random;
	}
	@Override
	public String createAccountNum() {
		String accountNum ="";
		for(int i =0; i<3; i++) {
			accountNum += (i==2)? random(0,999):random(0,999)+"-";
		}
		return accountNum;
	}
	
}
