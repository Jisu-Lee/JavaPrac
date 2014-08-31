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
		name = "�̸� ����";
		money = 0;
	}
	
	public void display(){
		System.out.printf("%s    %d��      %.0f%%\n", name, money, rate);
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
		System.out.print("1.�ű԰��� 2.�������� 3.����ο����� 4.�н����� ���� 5.���� ==> ");
		num = in.nextInt();
		System.out.println();
		
		switch(num){
		case 1:
			customer[customerNumber] = new Customer(); 
			System.out.println("== �ű� ���� ==");
			System.out.print("�̸� = ");
			customer[customerNumber].setName(in.next());
			System.out.print("�Ա� �ݾ� = ");
			customer[customerNumber].setMoney(in.nextInt());
			System.out.println();
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("'�ű� ������ 'yyyy'�� 'M'�� 'd'�� ' HH'�� 'mm'�п� ó���Ǿ����ϴ�.'");
			System.out.println(sdf.format(cal.getTime()));
			System.out.printf("�Ա��� �ݾ��� %d���Դϴ�.\n", customer[customerNumber].getMoney());
			System.out.printf("���� ���� ������ %.0f%%�Դϴ�.\n", Customer.getRate());
			System.out.println("== �ű� ���� �� ==\n");
			customerNumber++;
			break;
		case 2:
			do{
				System.out.print("������ �н����带 �Է��ϼ��� : ");
				boolean bool = manager.isEqual(in.next()); 
				if(bool == true){
				       System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
			       break;
				}
				else{
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				continue;
				}		
			}while(true);
			System.out.printf("���� %.0f%%�� ������ ����ǰ� �ֽ��ϴ�. �󸶷� �����Ͻðڽ��ϱ�?\n���� ���� = ", Customer.getRate());
			Customer.setRate(in.nextFloat());
			System.out.printf("��� �������� %.0f%%�� ���� ����˴ϴ�.\n\n", Customer.getRate());
			break;
		case 3:
			System.out.println("=== ���� ��� ���� ���� ===");
			System.out.println("�̸�\t  �ݾ�\t     ����");
			System.out.println("===========================");
			for(int i=0; i<customerNumber; i++){
				customer[i].display();
			}
			System.out.println("===========================\n");
			break;
		case 4:
			do{
				System.out.print("���� �н����带 �Է��ϼ��� : ");
				boolean bool = manager.isEqual(in.next());
				if(bool == true){
					System.out.println("�����Ǿ����ϴ�.");
					break;
				}
				else{
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
					continue;
				}
			}while(true);
			System.out.print("�н����带 �Է��ϼ���. : ");
			manager.setPassword(in.next());
			break;
			
		case 5:
			System.out.println("���� ������ �����մϴ�. �����ϼ̽��ϴ�.");
			break;
		default:
			System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			break;
		}
		
	}while(num != 5);				
	}

}