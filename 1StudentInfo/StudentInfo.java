import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


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
	System.out.printf("\nAverage : %.2f\n\n",(float)subject[subject.length-1]/(float)(subject.length-1));
	}
}

public class StudentInfo{
	public static void main(String[] ar) throws NumberFormatException, IOException{
	int studentNum=0;
	boolean bool = true;
//	Scanner in = new Scanner(System.in);
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	System.out.printf("Enter Number of Students : ");
	studentNum = Integer.parseInt(in.readLine());
	SungJuk[] person = new SungJuk[studentNum];
	for(int i=0; i<studentNum; i++){
		System.out.printf("\tStudent Number %d\n", i+1);
		person[i] = new SungJuk();
		}
	while(bool){
	System.out.print("Data input ended. Do you want to see student's information? (Y/N) ");
	String decision = in.readLine();
	switch(decision){
		case "Y" :
		case "y" :
	for(int i=0; i<studentNum; i++){
		System.out.printf("Student %d \n", i+1);
		person[i].showStudent();
		}
	bool = false;
	break;
		case "N" :
		case "n"  :
	System.out.println("Program ended.");
	System.exit(-1);
	bool = false;
	break;
		default :
	System.out.println("Wrong input. Please try again.");
	break;
	}
	}
	in.close();
	}
}

