import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws IOException {
		Scanner inFile = new Scanner(new File("input"));
		ArrayList<Passenger> list = new ArrayList<Passenger>();

		while (inFile.hasNext()) {
			list.add(new Passenger(inFile.next(), inFile.next(), inFile.next(), inFile.next(), inFile.nextInt()));
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getReservation());
		}
		
		

	}

}