package kr.mrhi.home0126;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneInfoExample {

	public static Scanner sc = new Scanner (System.in);
	public static final int NYEAR = 2021;
	public static void main(String[] args) {
		
		HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
		boolean flag = false;
		int no=0;
		
		for(int i =0; i<10;i++) {
			PhoneInfo h = new PhoneInfo();
			h.setName(h.randomName());
			h.setPhone(h.randomPhone());
			h.setBirth(h.randomBirth());
			h.setGender(h.randomGender());
			h.setAge(NYEAR - Integer.parseInt(h.getBirth().substring(0,4))+1);
			h.setDate(h.randomDate());
			set.add(h);
			System.out.println(h.toString());
		}
		
		
		while(!flag) {
			System.out.println("\n");
			System.out.println("------------------------------------------");
			System.out.println("1정렬출력 2정보저장 3정보검색 4정보수정 5정보삭제 6종료");
			System.out.println("------------------------------------------");
			try {
				System.out.print("선택 : ");
				no = sc.nextInt();
			} catch (Exception e) {
				System.out.println("숫자 입력 요망");
				break;
			}
			switch (no) {
			case 1: print(set);break;
			case 2: add(set); break;
			case 3: search(set); break;
			case 4: update(set); break;
			case 5: delete(set); break;
			case 6: flag = true; break;
			default:System.out.println("다시 입력 요망");break;
			}
			
		}
		System.out.println("Finish");
	}//메인
	
	private static void search(HashSet<PhoneInfo> set) {
		boolean isExist = false;
		if(set.size()<0) {
			System.out.println("검색할 정보 없음.");
		}else {
			System.out.print("검색할 정보 이름 입력 : ");
			String answer = sc.next();
			Iterator<PhoneInfo> it = set.iterator();
			while(it.hasNext()) {
				PhoneInfo data = it.next();
				if(data.getName().equals(answer)) {
					isExist = true;
					System.out.println(data.toString());
					break;
				}
			}
			if(!isExist) {
				System.out.println("해당 정보 없음.");
			}
		}
	}
	private static void delete(HashSet<PhoneInfo> set) {
		boolean isExist = false;
		if(set.size()<0) {
			System.out.println("삭제할 정보 없음.");
		}else {
			System.out.print("삭제할 정보 이름 입력 : ");
			String answer = sc.next();
			Iterator<PhoneInfo> it = set.iterator();
			while(it.hasNext()) {
				PhoneInfo data = it.next();
				if(data.getName().equals(answer)) {
					isExist = true;
					set.remove(data);
					System.out.println("**정상적으로 삭제되었습니다.**");
					break;
				}
			}
			if(!isExist) {
				System.out.println("해당 정보 없음.");
			}
			
		}
	}
	private static void update(HashSet<PhoneInfo> set) {
		boolean isExist = false;
		System.out.print("수정할 정보 이름 입력 : ");
		String answer = sc.next();
		Iterator<PhoneInfo> it = set.iterator();
		while(it.hasNext()) {
			PhoneInfo data = it.next();
			if(data.getName().equals(answer)) {
				System.out.print("수정할 생년월일 입력 : ");
				String day = sc.next();
				data.setBirth(day);
				data.setAge(2021 - Integer.parseInt(data.getBirth().substring(0,4))+1);
				isExist = true;
				System.out.println("**정상적으로 수정되었습니다.**");
				break;
			}
		}
		if(!isExist) {
			System.out.println("해당 정보 없음.");
		}
	}
	private static void add(HashSet<PhoneInfo> set) {
		boolean isExist = false;
		PhoneInfo in = new PhoneInfo();
		if(set.size()>=20) {
			System.out.println("저장 용량 초과");
		}else {
			
			while(true) {
				System.out.print("추가할 정보 이름 입력 : ");
				String name=sc.next();
				Iterator<PhoneInfo> it = set.iterator();
				while(it.hasNext()) {
					PhoneInfo data = it.next();
					if(data.getName().equals(name)) {
						isExist = true;
						System.out.println("중복된 정보입니다.");
						break;
					}
				}
				if(isExist ==false) {
					in.setName(name);
					break;
				} else {
					isExist =false;
					continue;
				}
			}
			while(true) {
				System.out.print("추가할 정보 번호 입력 : ");
				String num=sc.next();
				Iterator<PhoneInfo> it = set.iterator();
				while(it.hasNext()) {
					PhoneInfo data = it.next();
					if(data.getPhone().equals(num)) {
						isExist = true;
						System.out.println("중복된 정보입니다.");
						break;
					}
				}
				if(isExist ==false) {
					in.setPhone(num);
					break;
				} else {
					isExist =false;
					continue;
				}
			}
			in.setGender(in.randomGender());
			in.setBirth(in.randomBirth());
			in.setAge(2021 - Integer.parseInt(in.getBirth().substring(0,4))+1);
			in.setDate(in.randomDate());
			set.add(in);
			System.out.println("**정상적으로 추가됨**");
			
		}//if
	}		
	
	private static void print(HashSet<PhoneInfo> set) {
		ArrayList<PhoneInfo> list = new ArrayList<PhoneInfo>(set);
		PhoneInfo temp = null;
		for(int i =0; i <list.size();i++) {
			for(int j = i+1; j < list.size();j++) {
				if(list.get(i).getName().charAt(0)>list.get(j).getName().charAt(0)) {
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
			System.out.println(list.get(i).toString());
		}
	}
}//end
