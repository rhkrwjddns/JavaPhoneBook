package kr.mrhi.home0126;

import java.util.Calendar;
import java.util.Objects;

public class PhoneInfo {
	
	private String name;
	private String phone;
	private String birth;
	private String gender;
	private int age;
	private String date;
	
	public PhoneInfo() {
		this(null,null,null,null,0,null);
	}
	public PhoneInfo(String name, String phone, String birth, String gender, int age,String date) {
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.gender = gender;
		this.age = age;
		this.date = date;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if(obj instanceof PhoneInfo) {
			PhoneInfo phone = (PhoneInfo)obj;
			if(phone.equals(this.phone)||name.equals(this.name)) {
				flag = true;
			}else {
				flag = false;
			}
		}
		return flag;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,phone); 
	}
	
	
	//-----------------------------------------------------
	
	@Override
	public String toString() {
		return name + "\t" + phone + "\t"+ birth +"\t"+ gender +"\t"+ age+"\t"+date;
	}
	String randomName() {
		String[] family = new String [] {"±è","ÀÌ","½Å","Á¤","¹Ú"};
		String[] first = new String [] {"¹Î","¿°","Èñ","ÁÖ","µ¿","Áö","Çõ","Áê","·®","°¥","¸é"};
		
		int i = (int)(Math.random()*family.length);
		int j = (int)(Math.random()*first.length);
		int k = (int)(Math.random()*first.length);
	
		return family[i]+first[j]+first[k];
	}
	String randomPhone() {
		String i = String.format("%04d",(int)(Math.random()*10000) );
		String j = String.format("%04d",(int)(Math.random()*10000) );
		
		return "010-"+i+"-"+j;
	}
	String randomBirth() {
		int year =(int)(Math.random()*(2020-1990+1)+1990);
		int immonth = (int)(Math.random()*(12-1+1)+1);
		String month = "";
		if(immonth<10) {
			month = "0"+immonth;
		}else {
			month = ""+immonth;
		}
		String day="";
		
		switch (immonth) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day =String.format("%02d",(int)(Math.random()*(31-1+1)+1));
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day =String.format("%02d",(int)(Math.random()*(30-1+1)+1));
			break;
		default:
			if((year%4==0||year%100==0)&& year%400==0) {
				day =String.format("%02d",(int)(Math.random()*(29-1+1)+1));
				break;
			}else {
				day =String.format("%02d",(int)(Math.random()*(28-1+1)+1));
				break;
			}
		}
		return year+"."+month+"."+day;
	}
	
	String randomGender() {
		
		int i = (int)(Math.random()*2);
		if(i==1) {
			setGender("male");
		}else {
			setGender("female");
		}
		
		return getGender();
	}
	
	String randomDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH)+1;
		int day = cal.get(cal.DATE);
		return String.valueOf(year)+String.valueOf(month)+String.valueOf(day);
	}
	
	//-------------------------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
