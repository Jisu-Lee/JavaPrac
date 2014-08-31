import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Scanner;


class Person{
	private int[] ssNumber; 
	private String name;
	private int sum; private float temp;
	private boolean bool;
	static BufferedReader in; 

	static{
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Person(){
		ssNumber = new int[14];
		name = "";
		sum = 0; temp = 0.0f;
		bool = false;
	}

	public void setName()throws IOException{
		System.out.print("Name : ");
		name = in.readLine();
	}
	
	public String getName(){
		return name;
	}
	public void setNumber()throws IOException{
	do{
		System.out.print("Social Security Number : ");
		for(int i=0; i<ssNumber.length; i++){
			ssNumber[i] = System.in.read() - 48;
		}
		System.in.read();
		System.in.read();

		if(ssNumber[2]*10 + ssNumber[3] > 12){
			System.out.println("The combination of 3rd and 4th number cannot exceeds twelve.");
			continue;
		}

		if(ssNumber[4]*10 + ssNumber[5] > 31){

			System.out.println("The combination of 5th and 6th number cannot exceeds thirty one.");
			continue;
		}

		if(ssNumber[7] < 1 || ssNumber[7] > 4){
			System.out.println("The 7th Number should be between 1 and 4.");
			continue;
		}
		int num = 2;
	       	sum = 0;
		for(int i=0; i<ssNumber.length-1; i++){
			if(i == 6) continue;
			if(num == 10) num = 2;
			sum += ssNumber[i]*num++;
		}

		temp = (int)(sum/11.0f) * 11.0f + 11.0f - sum;
		temp = temp - (int)(temp/10.0f) * 10.0f;

		if(temp != ssNumber[13]){
			System.out.println("The last number is invalid.");
			continue;
		}

		bool = true;
		}while(!bool);
	}


	public void showInfo(){
		System.out.println("\nName : " + name);
		System.out.print("Social Security number : ");
		for(int i=0; i<ssNumber.length; i++){
			if(i==6){
				System.out.print("-");
				continue;
			}
			System.out.print(ssNumber[i]);
		}
		String sex = null;
		int year=0, month=0, day=0;
		switch(ssNumber[7]){
			case 1:
				sex = "male";
			case 2:
				year = 1900;
				sex = "female";
				break;
			case 3:
				sex = "male";
			case 4:
				year = 2000;
				sex = "female";
				break;
		}
		year += ssNumber[0]*10 + ssNumber[1];
		month = ssNumber[2]*10 + ssNumber[3];
		day = ssNumber[4]*10 + ssNumber[5];

		System.out.println("\nDoB : " + year + "." + month + "." + day);
		System.out.println("Sex : " + sex);
		
		String place = null;

		switch(ssNumber[8]){
			case 0: place = "Seoul"; break;
			case 1: place = "Daegyeon"; break;
			case 2: place = "Daegu"; break;
			case 3: place = "Busan"; break;
			case 4: place = "JeonJu"; break;
			case 5: place = "Gangwondo"; break;
			case 6: place = "Jeju"; break;
			case 7: place = "Gyeonggi"; break;
			case 8: place = "Chungchung"; break;
			case 9: place = "JeonLa"; break;
		}

		System.out.println("Birthplace : " + place);
		int age;
		Calendar cal = Calendar.getInstance();
		age = cal.get(Calendar.YEAR) - year + 1;
		System.out.println("Age : " + age);
		}

	class SungJuk{
		private int[] subject = new int[5]; //English, Korean, Math, Physics, total
		private String[] subName = new String[]{"English", "Korean", "Math", "Physics"};
		
		public SungJuk(){
		Scanner in = new Scanner(System.in);
		for(int i=0; i<subject.length-1; i++){
			System.out.print(subName[i] + " : ");
			subject[i] = in.nextInt();
			if(subject[i] > 100 || subject[i] < 0){
				System.out.println("A score should be between 0 and 100.Please enter again.");
				i--;
				continue;
			}
			subject[subject.length-1] += subject[i];
		}
		System.out.printf("Average : %.2f\n",(float)subject[subject.length-1]/(float)(subject.length-1));
		System.out.println();

		}
		
		public void showStudent(){
		for(int i=0; i<subject.length-1; i++){
			System.out.print(subName[i] + " : " + subject[i] + "\t");	
		}
		
		float avr = (float)subject[subject.length-1]/(subject.length-1);
		String score = "default";
		
		if(avr > 90 && avr <= 100) score = "A";
		else if(avr > 80 && avr <= 90) score = "B";
		else if(avr > 70 && avr <= 80) score = "C";
		else if(avr > 60 && avr <= 70) score = "D";
		else if(avr <= 60) score = "F";

		System.out.printf("\nSum : %d", subject[subject.length-1]);
		System.out.printf("\nAverage : %.2f\n",avr);
		System.out.println("Score : "+score);
		System.out.println("Rank : 1st\n");
		}
	}
}
public class JuminScore {
	public static void main(String[] args) throws IOException {
		int num = 1;
		System.out.print("Enter Student number : ");
		num = new Scanner(System.in).nextInt();
		Person[] person = new Person[num];
		for(int i=0; i<num; i++){
			person[i] = new Person();
            person[i].setName();
            person[i].setNumber();
            System.out.println();
            Person.SungJuk score = person[i].new SungJuk();
            System.out.println(person[i].getName()+"�� ������");
            person[i].showInfo();
            System.out.println();
            score.showStudent();
		}
		
	}

}
