package serviceImpl;

import java.util.*;
import domain.*;
import service.*;

public class MemberServiceImpl implements MemberService{
	Map<String,MemberBean> map;
	
	public MemberServiceImpl() {
		map = new HashMap<>();
	}
	@Override
	public void createUser(UserBean user) {
		user.setCreditRating("7등급");
		map.put(user.getUid(),user);
		
	}

	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("1234");
		map.put(staff.getUid(),staff);
	}

	@Override
	public Map<String , MemberBean> map() {
		return map;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> temp = new ArrayList<>();
		Set<MemberBean> set = new HashSet<>();
		
		for(Map.Entry<String, MemberBean> e : map.entrySet()) { //Map에서 value의 key값을 떼어내고, 
																										//내부에 있는 것들을 차례차례 확인하는데,
			if(name.equals(e.getValue().getName())) {   //이름을 비교해서 이름이 같은경우 
				set.add(e.getValue());                                //해당 value를 set에 담는다
			}	
		}
		Iterator<MemberBean> it = set.iterator();  //set에 들어있는 요소들을 막무가내로 뒤진다.
		while(it.hasNext()) {    //아직 더 뒤질게 남아있다면, 남아있는게 없을때까지 계속
				temp.add(it.next()); //temp list에 해당 값을 넣는다.
		}
		return temp;
	}
	@Override
	public MemberBean findById(MemberBean member) {
		System.out.println("찾는 아이디에 해당하는 이름 :" + map.get(member.getUid()));
		return map.get(member.getUid());
	}
	@Override
	public void updatePassword(MemberBean member) {
		String id = member.getUid();
		String oldPass = member.getPass().split("/")[0];
		String newPass = member.getPass().split("/")[1];
		if(map.get(id)==null) {
			System.out.println("일치하는 아이디 없음");
		}else if (oldPass.equals(map.get(id).getPass()))
			map.get(id).setPass(newPass);
	}
	@Override
	public void deleteMember(MemberBean member) {
		map.remove(member.getUid());
		
	}
	
}
