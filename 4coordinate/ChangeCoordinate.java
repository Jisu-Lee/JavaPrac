import java.util.Scanner;

public class ChangeCoordinate{
	public static void main(String[] args) {
	Coordinate coo = new Coordinate();
	Scanner in = new Scanner(System.in);
	int num = 0; 
	
	do{
		System.out.print("\n1. Set coordinate 2. Display coordinate 3. exit : ");
		num = in.nextInt();

		if(num == 1){
			coo.setCoordinate();
		}
		else if(num == 2){
			coo.display();
		}
		else if(num == 3){
			System.out.println("\n\tProgram ended.");
			break;
		}
		else{
			System.out.println("\n\tYou've entered a wrong number. Please enter again.");
		}
	}while(true);
}
}

class Coordinate{
	private float cooX, cooY;
	Scanner in = new Scanner(System.in);

	public Coordinate(){
		cooX = 0.0f;
		cooY = 0.0f;
	}

	public void setCoordinate(){
		System.out.print("\n\tCoordinate X : ");
		this.cooX = in.nextFloat();
		System.out.print("\tCoordinate Y : ");
		this.cooY = in.nextFloat();
	}

	public void display(){
		System.out.println("\n\t(" + cooX + ", " + cooY + ")");
	}
}
/*
import java.util.Scanner;

public class Test{
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int num = 0; 
	
		do{
			System.out.print("1. Set coordinate 2. Display coordinate : ");
			num = in.nextInt();
	
			if(num == 1){
				Coordinate.setCoordinate();
			}
			else if(num == 2){
				Coordinate.display();
			}
			else if(num == 3){
				break;
			}
			else{
				System.out.println("You've entered a wrong number. Please enter again");
			}
		}while(true);
		in.close();
	}
}

class Coordinate{
	private static float cooX, cooY;

	public Coordinate(){
		cooX = 0.0f;
		cooY = 0.0f;
	}

	public static void setCoordinate(){
		Scanner in = new Scanner(System.in);
		System.out.print("Coordinate X : ");
		cooX = in.nextFloat();
		System.out.print("Coordinate Y : ");
		cooY = in.nextFloat();
		//in.close(); this line cause error. I don't know why.
	}

	public static void display(){
		System.out.println("(" + cooX + ", " + cooY + ")");
	}
}
 */ 
