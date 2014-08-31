import java.io.*;
import java.util.Scanner;

public class PersonInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num, pplnum = 1, infoNum;
		boolean bool = true;
		Scanner in = new Scanner(System.in);
		System.out.print("number of person : ");
		num = in.nextInt();
		Person[] person = new Person[num];
		for(int i=0; i<num; i++){
			person[i] = new Person();
		}
		while(pplnum != -1){
		System.out.print("Whose information do you want to change?(exit 0) : ");
		 pplnum = in.nextInt(); pplnum--;
		 bool = true;
		
		 while(bool && pplnum >= 0){	
			 System.out.print("\nInformation to change(1. name 2. jumin 3. phone number 4. address (exit : 5)) : ");
			 infoNum = in.nextInt();

		switch(infoNum){
			case 1 :
				System.out.print("\nname : ");
				person[pplnum].setName(in.next());
				break;
			case 2 :
				System.out.print("\njumin : ");
				person[pplnum].setJumin(in.next());
				break;
			case 3 :
				System.out.print("\nphone number : ");
				person[pplnum].setPhoneNum(in.next());
				break;
			case  4 :
				System.out.print("\naddress : ");
				person[pplnum].setAddress(in.next());
				break;
			case 5 :
				System.out.println("\nInput ended.");
				bool = false; break;
			default : 
				System.out.println("\nWrong number. Please enter again.");
				break;
		}
	  }
	}
		pplnum = 0;
		while(pplnum != -1){
		 System.out.print("\nChoose person to show(exit 0) : ");
		 pplnum = in.nextInt(); pplnum--;
		 if(pplnum < 0) break;
		 person[pplnum].show();
		}
		 in.close();
 }
}


class Person{
	private String name;
	private String jumin;
	private String phoneNum;
	private String address;

	public Person(){
		name = "guest";
		jumin = "000000-0000000";
		phoneNum = "000-0000-0000";
		address = "주소 기재하지 않음";
	}

//	public Person(String name){
//		this();
//		this.name = name;
//	}
//
//	public Person(String name, String jumin){
//		this(name);
//		this.jumin = jumin;
//	}
//
//	public Person(String name, String jumin, String phoneNum){
//		this(name, jumin);
//		this.phoneNum = phoneNum;
//	}
//
//	public Person(String name, String jumin, String phoneNum, String address){
//		this(name, jumin, phoneNum);
//		this.address = address;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void show(){
		System.out.println("name : " + name);
		System.out.println("jumin : " + jumin);
		System.out.println("phone number : " + phoneNum);
		System.out.println("address : " + address);
		
	}
	
}







