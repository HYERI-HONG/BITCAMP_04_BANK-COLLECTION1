package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.*;
import domain.*;
import service.*;
//날짜 구하기
import java.text.SimpleDateFormat;


public class AccountServiceImpl implements AccountService {
	Map<String,AccountBean> map;
	public AccountServiceImpl() {
		map = new HashMap<>();
	}
	@Override
	public void createAccount(AccountBean account) {
			account.setCreateDate(createDate());
			account.setAccountNum(createAccountNum());
			map.put(account.getUid(),account);
	}
	@Override
	public void createMinusAccount(MinusAccountBean account) {
			account.setCreateDate(createDate());
			account.setAccountNum(createAccountNum());
			map.put(account.getUid(),account);
	}
	@Override
	public Map<String,AccountBean> map() {
		return map;
	}

	@Override
	public List<AccountBean> findByName(String name) {
		List<AccountBean> temp = new ArrayList<>();
		Set<AccountBean> set = new HashSet<>();
		
		for(Map.Entry<String, AccountBean> e : map.entrySet()) {
			if(name.equals(e.getValue().getName())) {
				set.add(e.getValue());
			}
		}
		Iterator <AccountBean> it = set.iterator();
		while(it.hasNext()) {
			temp.add(it.next());
		}
		return temp;
	}

	@Override
	public AccountBean findById(AccountBean account) {
		AccountBean temp = new AccountBean();
		temp = map.get(account.getUid());
		return temp;
	}
	
	@Override
	public void updatePassword(AccountBean account) {	
		
		String id = account.getUid();
		String oldPass = account.getPass().split("/")[0];
		String newPass = account.getPass().split("/")[0];
		
		if(map.get(id)==null) {
			System.out.println("일치하는 아이디 없음");
		}
		else if(oldPass.equals(map.get(id).getPass())) {
			map.get(id).setPass(newPass);
		}
	}
	
	@Override
	public void deleteAccount(AccountBean account) {
		map.remove(account.getUid());
		
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
