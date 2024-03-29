import java.io.*;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;;

class Customer{
	private String name;
	private int money;
	private static float rate;

	static{
		rate = 5.0f;
	}

	public Customer(){
		name = "이름 없음";
		money = 0;
	}
	
	public void display(){
		System.out.printf("%s    %d원      %.0f%%\n", name, money, rate);
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setMoney(int money){
		this.money = money;
	}
	public int getMoney(){
		return money;
	}
	public static void setRate(float rate){
		Customer.rate = rate;
	}
	public static float getRate(){
		return rate;
	}
}

class Manager{
	private String password;

	public Manager(){
		password = "0000";
	}

	public boolean isEqual(String password){
		return this.password.equals(password);
	}

	public void setPassword(String password){
		this.password = password;
	}
}

public class JBank{
	public static void main(String[] ar){
		int num=0, customerNumber=0;
		Customer[] customer = new Customer[100];	
		Manager manager = new Manager();
		Scanner in = new Scanner(System.in);
		do{
		System.out.print("1.신규가입 2.이율변경 3.등록인원정보 4.패스워드 변경 5.종료 ==> ");
		num = in.nextInt();
		System.out.println();
		
		switch(num){
		case 1:
			customer[customerNumber] = new Customer(); 
			System.out.println("== 신규 가입 ==");
			System.out.print("이름 = ");
			customer[customerNumber].setName(in.next());
			System.out.print("입금 금액 = ");
			customer[customerNumber].setMoney(in.nextInt());
			System.out.println();
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("'신규 가입이 'yyyy'년 'M'월 'd'일 ' HH'시 'mm'분에 처리되었습니다.'");
			System.out.println(sdf.format(cal.getTime()));
			System.out.printf("입금한 금액은 %d원입니다.\n", customer[customerNumber].getMoney());
			System.out.printf("현재 적용 이율은 %.0f%%입니다.\n", Customer.getRate());
			System.out.println("== 신규 가입 끝 ==\n");
			customerNumber++;
			break;
		case 2:
			do{
				System.out.print("관리자 패스워드를 입력하세요 : ");
				boolean bool = manager.isEqual(in.next()); 
				if(bool == true){
				       System.out.println("관리자 인증이 완료되었습니다.");
			       break;
				}
				else{
				System.out.println("비밀번호가 일치하지 않습니다.");
				continue;
				}		
			}while(true);
			System.out.printf("현재 %.0f%%의 이율이 적용되고 있습니다. 얼마로 변경하시겠습니까?\n적용 이율 = ", Customer.getRate());
			Customer.setRate(in.nextFloat());
			System.out.printf("모든 고객에게 %.0f%%로 변경 적용됩니다.\n\n", Customer.getRate());
			break;
		case 3:
			System.out.println("=== 현재 등록 고객 정보 ===");
			System.out.println("이름\t  금액\t     이율");
			System.out.println("===========================");
			for(int i=0; i<customerNumber; i++){
				customer[i].display();
			}
			System.out.println("===========================\n");
			break;
		case 4:
			do{
				System.out.print("기존 패스워드를 입력하세요 : ");
				boolean bool = manager.isEqual(in.next());
				if(bool == true){
					System.out.println("인증되었습니다.");
					break;
				}
				else{
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력하세요.");
					continue;
				}
			}while(true);
			System.out.print("패스워드를 입력하세요. : ");
			manager.setPassword(in.next());
			break;
			
		case 5:
			System.out.println("은행 영업을 마감합니다. 수고하셨습니다.");
			break;
		default:
			System.out.println("잘못된 수를 입력하셨습니다. 다시 입력해주세요.");
			break;
		}
		
	}while(num != 5);				
	}

}
