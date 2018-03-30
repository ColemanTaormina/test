//ColemanTaormina
//Plane
//3-25-18
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Plane {
	List<String> SeatsForPartnerFirst = new ArrayList<String>();
	public static String[][] x = new String[3][4];
	//first class seats
	public static String[][] y = new String[22][6];
	//economy's seats
	private static int lastPositionI = 0;
	private static int lastPositionJ = 0;
	//used to save the positions to compare to the next seats position in the array
	private static int LI;
	private static int LJ;
	//used to save the positions to compare to the next seats position in the array
	private static int Lz = 65;
	//the char number of 'A' as to be increased to equal the seat number
	private static int ultaholder;
	//holds the seat number 
	private static char charholder;
	//holds the letter
	private static String ultacharholder;
	//combines the number and letter 
	private static Passenger.SeatType asileholder;
	// used to compare the last asile seat(W,A,or C) to the next asile seat(W,A,or C)
	private static int LP = 1;
	//holds the last number from the peps/ the number of people reserved to sit together
	private static int foranI = 0;
	private static int foranJ = 0;
	//holders that compare to the next set of cordinates
private static int extraspecialI = 0;
private static int extraspecialJ = 0;
//final comparsion to determine if the next position in the array is open
	public static String Placeholder(Passenger.ClassType type, Passenger.SeatType asile, int peps) {
		//given one person at a time which made coding difficult and the code has to predict which spot for reservations
		// could be the next seat and then have the next point based on it type, asile and peps find its appropriate seat
		String firstHolder = "";
		if (Passenger.ClassType.First == type) {
			//first class seats are calculated
			firstHolder = Firstnumber(asile, peps);
		
			//give the seat number+letter to partner
			return firstHolder;
	
		}

		// ----------------------------
		if (Passenger.ClassType.Econ == type) {
			//econ seats are calculated
			firstHolder = Secondnumber(asile, peps);
			//give the seat number+letter to partner
			return firstHolder;
		}
		//should never run an error but better to have it as for checking purposes
		return "ERROR";
	}

	private static String Secondnumber(Passenger.SeatType asile3, int peps3) {
		//Economy class seating
		
		String firstHolder3 = "";
		//just a holder 
		int i2 = 0, j2 = 0;
		//for the for loops and while loops
		int holdery2 = 0;
		//a secondary holder
		int y2 = 65;
		//the char should start at 65 and will not run if not at 65 which is checked with this int
		int j3;
		int i3;
		//another for statement starters
		int specialI = 0;
		int specialJ = 0;
		//compare the current positions to find the best seat
		int extrapepsholder;
		boolean check = false;
		//finds the next spot for a group of 4 or greater if the peps/reservation of people is more than 4
		

		//specialty check for the peps when the reservation is two since there has to be an open seat and be next to the prior point
		if (peps3 == 0 && LP == 2) {

			//checks all points for an reserved spot of A, B, or C which A is an Window, B is an Center, and C is an asile
			// these are the prior checks for special seats which have to be predicted in later code below
			for (i2 = 0; i2 < 22; i2++) {
				for (j2 = 0; j2 <= 5; j2++) {
					//checks if the seat is an Window and is reserved
					if (y[i2][j2] == "A" && Passenger.SeatType.W == asile3) {
						//!!!!!!!!!!!This commented section below is used countless times throughout my code and would have been better
						//used in another method however a few of them are slightly different and will be explained
						//I will reference this calculation as the "first time" and will not just copy the explanation over and over
						//since it degrades the importance of other characteristics of the code
						
						//here is the creation of the seat number and letter
						//LP is set to zero as to reflect that this is the last seat to go next to the reserved person
						//z2 becomes equal to the letter as a char 
						//the number is calculated plus six since the second array in economy starts at six 
						//the number is added as a string to anoth string the letter of z2
						//the string is put into the array to never allow anyone else to sit there
						//asileholder is set to the current asile as to save it for comparsion later
						//the loops counters are set to zero
						//then the seat number+letter as a string are returned to the Place holder which are then returned to my partner
						LP = peps3;
						char z2 = (char) (y2 + j2);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						asileholder = asile3;
						j2 = 0;
						i2 = 0;
						return firstHolder3;
					}
					//checks if the seat is an Asile and is reserved
					if (y[i2][j2] == "C" && Passenger.SeatType.A == asile3) {
						//calculates the same as the "first time" but for Asile seats
						LP = peps3;
						char z2 = (char) (y2 + j2);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						asileholder = asile3;
						j2 = 0;
						i2 = 0;
						return firstHolder3;
					}
					//checks if the seat is an Center and is reserved
					if (y[i2][j2] == "B" && Passenger.SeatType.C == asile3) {
						//calculates the same as the "first time" but for Center seats
						LP = peps3;
						char z2 = (char) (y2 + j2);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						asileholder = asile3;
						j2 = 0;
						i2 = 0;
						return firstHolder3;
					}
				}
			}
		}
//for all other seats that are reserved by a person the seat should be reserved and placed in those seats 
		if (peps3 == 0) {

			while (specialI < 1) {

				for (specialI = 0; specialI < 22; specialI++) {
					for (specialJ = 0; specialJ <= 5; specialJ++) {
						//same as "first time" calculations however the counters are different as to separate the two sections and 
						//saves the last seat for groups of more then 3 as to keep them together as closely as possible
						
						if (y[specialI][specialJ] == "A" && Passenger.SeatType.W == asile3) {
							//checks if the spot is an Windo and is reserved
							extraspecialI = specialI;
							extraspecialJ = specialJ;
							//saves the last points for seats greater than four
							extrapepsholder = peps3;
							char z2 = (char) (y2 + specialJ);
							firstHolder3 = (Integer.toString(specialI + 6)) + (Character.toString(z2));
							y[specialI][specialJ] = firstHolder3;
							asileholder = asile3;
							specialI = 0;
							specialJ = 0;
							return firstHolder3;
						}

						if (y[specialI][specialJ] == "B" && Passenger.SeatType.C == asile3) {
							//checks if the spot is an Center and is reserved
							extraspecialI = specialI;
							extraspecialJ = specialJ;
							//saves the last points for seats greater than four
							extrapepsholder = peps3;
							char z2 = (char) (y2 + specialJ);
							firstHolder3 = (Integer.toString(specialI + 6)) + (Character.toString(z2));
							y[specialI][specialJ] = firstHolder3;
							asileholder = asile3;
							specialI = 0;
							specialJ = 0;
							return firstHolder3;
						}

						if (y[specialI][specialJ] == "C" && Passenger.SeatType.A == asile3) {
							//checks if the spot is an Windo and is reserved
							extraspecialI = specialI;
							extraspecialJ = specialJ;
							//saves the last points for seats greater than four
							extrapepsholder = peps3;
							char z2 = (char) (y2 + specialJ);
							firstHolder3 = (Integer.toString(specialI + 6)) + (Character.toString(z2));
							y[specialI][specialJ] = firstHolder3;
							asileholder = asile3;
							specialI = 0;
							specialJ = 0;
							return firstHolder3;
						}

					}
				}
			}
			//if the reservation is greater than 3 then the fourth seat needs to be open and as close to the group as possible
			//this is where extraspecialI and extraspecialJ are used to get the next seat of that type
			for (specialI = 0; specialI < 22; specialI++) {
				for (specialJ = 0; specialJ <= 5; specialJ++) {
					if (extraspecialI == specialI) {
						//if the current seat is after the last seat then that seat is open for the taking
						if (extraspecialI==specialI &&extraspecialJ == specialJ) {
							check = true;
						}
					}
					if (check == true) {
							//the seat has to empty and of the same seating asile 
						if (y[specialI][specialJ] == null && Passenger.SeatType.W == asile3) {
							//"first time" calculations however, sets check to false so the prior statements will not resolve till the
							//reserved seats go in to the array
							extraspecialI = specialI;
							extraspecialJ = specialJ;
							extrapepsholder = peps3;
							char z2 = (char) (y2 + specialJ);
							firstHolder3 = (Integer.toString(specialI + 6)) + (Character.toString(z2));
							y[specialI][specialJ] = firstHolder3;
							asileholder = asile3;
							specialI = 0;
							specialJ = 0;
							check =false;
							return firstHolder3;
						}
						//the seat has to empty and of the same seating asile 
						if (y[specialI][specialJ] == null && Passenger.SeatType.A == asile3) {
							//"first time" calculations however, sets check to false so the prior statements will not resolve till the
							//reserved seats go in to the array
							extraspecialI = specialI;
							extraspecialJ = specialJ;
							extrapepsholder = peps3;
							char z2 = (char) (y2 + specialJ);
							firstHolder3 = (Integer.toString(specialI + 6)) + (Character.toString(z2));
							y[specialI][specialJ] = firstHolder3;
							asileholder = asile3;
							specialI = 0;
							specialJ = 0;
							check =false;
							return firstHolder3;
						}
						//the seat has to empty and of the same seating asile 
						if (y[specialI][specialJ] == null && Passenger.SeatType.C == asile3) {
							//"first time" calculations however, sets check to false so the prior statements will not resolve till the
							//reserved seats go in to the array
							extraspecialI = specialI;
							extraspecialJ = specialJ;
							extrapepsholder = peps3;
							char z2 = (char) (y2 + specialJ);
							firstHolder3 = (Integer.toString(specialI + 6)) + (Character.toString(z2));
							y[specialI][specialJ] = firstHolder3;
							asileholder = asile3;
							specialI = 0;
							specialJ = 0;
							check =false;
							return firstHolder3;
						}
					}

				}
			}
		}
		//this is the backup for any failings and give the person a seat that is empty if all else fails(it is a back up just in case)
		if (peps3 == 0) {
			for (i2 = 0; i2 < 22; i2++) {
				for (j2 = 0; j2 <= 5; j2++) {
					if (y[i2][j2] == null && foranI <= i2 && foranJ < j2) {
						char z2 = (char) (y2 + j2);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						asileholder = asile3;
						specialI = 0;
						specialJ = 0;
						return firstHolder3;

					}
				}
			}
		}
		
		//!!!!!!!below is the second most important part of the program that reserves the seats in the array for the special 2 people seating
		//this is the most important since there is the possibility of if the reservation is made the next seats must be reserved 
		//correctly so that two people are actually together
		for (i2 = 0; i2 < 22; i2++) {
			for (j2 = 0; j2 <= 5; j2++) {
				//there are two possible window seats in a row so if either of them are reserved then that is where the person is to sit 
				if (Passenger.SeatType.W == asile3) {
					//this 
					if (peps3 == 2 && j2 == 0 && y[i2][j2] == null && y[i2][j2 + 1] == null) {
						//puts the person in the first Window reserved seat 
						y[i2][j2 + 1] = "B";
						char z2 = (char) (y2);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						i2 = 0;
						j2 = 0;
						LP = peps3;

						return firstHolder3;
					}
					if (peps3 == 2 && j2 == 5 && y[i2][j2] == null && y[i2][j2 - 1] == null) {
						//puts the person in the second Window reserved seat 
						y[i2][j2 - 1] = "B";
						char z2 = (char) (y2 + 5);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						i2 = 0;
						j2 = 0;
						LP = peps3;
						return firstHolder3;

					}
				}
				//there are two possible window seats in a row so if either of them are reserved then that is where the person is to sit 
				if (Passenger.SeatType.A == asile3) {
					if (peps3 == 2 && j2 == 2 && y[i2][j2] == null && y[i2][j2 - 1] == null) {
						//puts the person in the first asile reserved seat 
						y[i2][j2 - 1] = "C";
						char z2 = (char) (y2 + 2);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						i2 = 0;
						j2 = 0;
						LP = peps3;
						return firstHolder3;
					}
					//puts the person in the second asile reserved seat 
					if (peps3 == 2 && j2 == 3 && y[i2][j2] == null && y[i2][j2 + 1] == null) {
						y[i2][j2 + 1] = "B";
						char z2 = (char) (y2 + 3);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						i2 = 0;
						j2 = 0;
						LP = peps3;
						return firstHolder3;
					}
				}
				//this is where the importance of the code is since there are four different possibilities if the reserver
				//person is in the center
				//there are two possible window seats in a row so if either of them are reserved then that is where the person is to sit 
				//with the appropriate seat reserved next door
				if (Passenger.SeatType.C == asile3 && j2 == 1) {

					if (peps3 == 2) {
						if (peps3 == 2 && j2 == 1 && y[i2][j2 + 3] == null && y[i2][j2 + 2] == null) {
							//puts the person in the first center reserved seat reservation possibility
							y[i2][j2 + 2] = "C";
							char z2 = (char) (y2 + 4);
							firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
							y[i2][j2 + 4] = firstHolder3;
							i2 = 0;
							j2 = 0;
							LP = peps3;
							return firstHolder3;
						}
						if (peps3 == 2 && j2 == 1 && y[i2][j2] == null && y[i2][j2 - 1] == null) {
							//puts the person in the second center reserved seat reservation possibility
							y[i2][j2 - 1] = "A";
							char z2 = (char) (y2 + 1);
							firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
							y[i2][j2] = firstHolder3;
							i2 = 0;
							j2 = 0;
							LP = peps3;
							return firstHolder3;
						}
						if (peps3 == 2 && j2 == 1 && y[i2][j2] == null && y[i2][j2 + 1] == null) {
							//puts the person in the third center reserved seat reservation possibility
							y[i2][j2 + 1] = "C";
							char z2 = (char) (y2 + 1);
							firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
							y[i2][j2] = firstHolder3;
							i2 = 0;
							j2 = 0;
							LP = peps3;
							return firstHolder3;
						}
						if (peps3 == 2 && j2 == 1 && y[i2][j2 + 3] == null && y[i2][j2 + 4] == null) {
							//puts the person in the fourth center reserved seat reservation possibility
							y[i2][j2 + 4] = "A";
							char z2 = (char) (y2 + 4);
							firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
							y[i2][j2 + 4] = firstHolder3;
							i2 = 0;
							j2 = 0;
							LP = peps3;
							return firstHolder3;
						}
					}
				}

			}
		}

		//section for the person reserving the seats is below
		i2 = 0;
		j2 = 0;
		if (Passenger.SeatType.W == asile3) {
			//starts checking all window seats
			while (i2 <= 21) {

				i3 = i2;
				j3 = j2;
				//save points to compare the later points to see if at both of the points that the seats are open

				if (y[i2][j2] == null) {
					// can only start checking if the spots are open at empty seats
					if (j2 == 0) {
						//for all column 1 seats for groups of greater than two
						if (peps3 > 2) {
							while (i2 < 132) {
								if (peps3 > 2 && y[i2][j2] == null && y[i2][j2 + 1] == null && y[i2][j2 + 2] == null) {
									//if a group is greater than two then at the vary least a single three seats must be reserved
									char z2 = (char) (y2);
									firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
									y[i2][j2] = firstHolder3;
									//reserves the two other seats in the row and then fills the current seat
									y[i2][j2 + 1] = "B";
									y[i2][j2 + 2] = "C";
									asileholder = asile3;
									i2 = 0;
									j2 = 0;

									return firstHolder3;
								}
								//goes to the next window seat coordinates in the array
								if (i2 % 2 == 0) {
									j2 = 5;
								} else {
									j2 = 0;
								}
								i2++;
							}
						} else {
							//points to be checked 
							i2 = i3;
							j2 = j3;
						}

						LI = i2;
						LJ = j2;
						//single persons are put into the array at the first open spot
						char z2 = (char) (y2);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						asileholder = asile3;
						i2 = 0;
						j2 = 0;
						break;

					}
					if (j2 == 5) {
						//for all column 6 seats for groups of greater than two
						if (peps3 > 2) {
							while (i2 < 132) {
								if (peps3 > 2 && y[i2][j2] == null && y[i2][j2 - 1] == null && y[i2][j2 - 2] == null) {

									char z2 = (char) (y2 + 5);
									firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
									y[i2][j2] = firstHolder3;
									//reserves the two other seats in the row and then fills the current seat
									y[i2][j2 - 1] = "B";
									y[i2][j2 - 2] = "C";
									asileholder = asile3;
									i2 = 0;
									j2 = 0;

									return firstHolder3;
								}
								//goes to the next window seat coordinates in the array
								if (i2 % 2 == 0) {
									j2 = 5;
								} else {
									j2 = 0;
								}
								i2++;
							}
						} else {
							//points to be checked 							
							i2 = i3;
							j2 = j3;
						}
						LI = i2;
						LJ = j2;
						if (peps3 == 0) {
							//worst case scenario if there is no seats of that asile with there group then fit them in 
							ultaholder = (int) (Lz);
							ultaholder = ultaholder + 5;
							charholder = (char) (ultaholder);
							ultacharholder = (Integer.toString(LI + 6)) + (Character.toString(charholder));
							y[i2][j2] = ultacharholder;
							asileholder = asile3;
							return ultacharholder;
						}
						//single seaters get the first possible seat
						char z2 = (char) (y2 + 5);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						asileholder = asile3;
						i2 = 0;
						j2 = 0;
						break;
					}
				}
				//go through the loop again
				j2 = j2 + 1;
				if (j2 == 6) {
					j2 = 0;
					i2 = i2 + 1;
				}
			}
		}
		//back up to make sure everything is zero to start with
		i2 = 0;
		j2 = 0;

		
		if (Passenger.SeatType.A == asile3) {
			//starts checking all asile seats
			while (i2 <= 132) {
//points to be checked
				i3 = i2;
				j3 = j2;
				
				if (y[i2][j2] == null) {
					//only find empty spot to start
					if (j2 == 2) {
						//all from column 3

						if (peps3 > 2) {
							while (i2 < 132) {
								if ((peps3 > 2 && y[i2][j2] == null && y[i2][j2 - 1] == null
										&& y[i2][j2 - 2] == null)) {
									char z2 = (char) (y2 + 2);
									firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
									y[i2][j2] = firstHolder3;
									//reserves the two other seats in the row and then fills the current seat
									y[i2][j2 - 1] = "B";
									y[i2][j2 - 2] = "A";
									asileholder = asile3;
									i2 = 0;
									j2 = 0;
									foranI = i2;
									foranJ = j2;
									return firstHolder3;
								}
								//goes to the next window seat coordinates in the array
								if (i2 % 2 == 0) {
									j2 = 3;
								} else {
									j2 = 2;
								}
								i2++;
							}

						} else {
							//points to be checked
							i2 = i3;
							j2 = j3;
						}
						LI=i2;
						LJ = j2;
						//worst case scenario if there is no seats of that asile with there group then fit them in 
						if (peps3 == 0) {
							ultaholder = (int) (Lz);
							ultaholder = ultaholder + 2;
							charholder = (char) (ultaholder);

							ultacharholder = (Integer.toString(LI + 6)) + (Character.toString(charholder));
							
							y[i2][j2] = ultacharholder;
							asileholder = asile3;
							return ultacharholder;
						}
						//fills in single person
						char z2 = (char) (y2 + 2);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						asileholder = asile3;
						i2 = 0;
						j2 = 0;
						break;

					}
					if (j2 == 3) {
						//all from column 4
						if (peps3 > 2) {
							while (i2 < 132) {
								if (peps3 > 2 && y[i2][j2] == null && y[i2][j2 + 1] == null && y[i2][j2 + 2] == null) {
									char z2 = (char) (y2 + 3);
									firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
									y[i2][j2] = firstHolder3;
									//reserves the two other seats in the row and then fills the current seat
									y[i2][j2 + 1] = "B";
									y[i2][j2 + 2] = "A";
									asileholder = asile3;
									i2 = 0;
									j2 = 0;
									foranI = i2;
									foranJ = j2;
									return firstHolder3;
								}
								//goes to next asile seat
								if (i2 % 2 == 0) {
									j2 = 2;
								} else {
									j2 = 3;
								}
								i2++;
							}
						} else {
							//points to chceck
							i2 = i3;
							j2 = j3;
						}
						LI=i2;
						LJ = j2;
						//worst case scenario if there is no seats of that asile with there group then fit them in 
						if (peps3 == 0) {

							ultaholder = (int) (Lz);
							ultaholder = ultaholder + 3;
							charholder = (char) (ultaholder);
							ultacharholder = (Integer.toString(LI + 6)) + (Character.toString(charholder));
							if (asileholder == Passenger.SeatType.C) {
								//reserves a seat
								if (y[i2][j2 + 1] == null) {
									y[i2][j2 + 1] = "R";
									y[i2][j2] = ultacharholder;
								}
								if (y[i2][j2 + 2] == null) {
									y[i2][j2 + 2] = "R";
									y[i2][j2] = ultacharholder;
								}
							}

							asileholder = asile3;
							return ultacharholder;
						}
						//fills in single person
						char z2 = (char) (y2 + 3);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						asileholder = asile3;
						i2 = 0;
						j2 = 0;
						break;
					}
				}
				j2 = j2 + 1;
				//goes to next spot
				if (j2 == 6) {
					j2 = 0;
					i2 = i2 + 1;
				}
			}
		}
		i2 = 0;
		j2 = 0;

		if (Passenger.SeatType.C == asile3) {
			//starts checking all window seats
			while (i2 <= 132) {
//points to check
				i3 = i2;
				j3 = j2;
				if (y[i2][j2] == null) {
					if (j2 == 1) {
						//all for column 2
						if (peps3 > 2) {
							while (i2 < 132) {
								if (peps3 > 2 && y[i2][j2] == null && y[i2][j2 + 1] == null && y[i2][j2 - 1] == null) {
									char z2 = (char) (y2 + 1);
									firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
									y[i2][j2] = firstHolder3;
									//reserves the two other seats in the row and then fills the current seat
									y[i2][j2 + 1] = "C";
									y[i2][j2 - 1] = "A";
									asileholder = asile3;
									i2 = 0;
									j2 = 0;

									return firstHolder3;
								}
								//goes to next point
								if (i2 % 2 == 0) {
									j2 = 4;
								} else {
									j2 = 1;
								}
								i2++;
							}
						} else {
						//points to check
							i2 = i3;
							j2 = j3;
						}
						LI=i2;
						LJ = j2;
						//worst case scenario if there is no seats of that asile with there group then fit them in 
						if (peps3 == 0) {
							ultaholder = (int) (Lz);
							ultaholder = ultaholder + 1;
							charholder = (char) (ultaholder);
							ultacharholder = (Integer.toString(LI + 6)) + (Character.toString(charholder));
							y[i2][j2] = ultacharholder;
							asileholder = asile3;
							return ultacharholder;
						}
						//single person fill in
						char z2 = (char) (y2 + 1);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						asileholder = asile3;
						i2 = 0;
						j2 = 0;
						break;

					}
					//column 5
					if (j2 == 4) {
						if (peps3 > 2) {
							while (i2 < 132) {

								if (peps3 > 2 && y[i2][j2] == null && y[i2][j2 + 1] == null && y[i2][j2 - 1] == null) {
									char z2 = (char) (y2 + j2);
									firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
									y[i2][j2] = firstHolder3;
									//reserves two seats and fills the seat
									y[i2][j2 + 1] = "C";
									y[i2][j2 - 1] = "A";
									i2 = 0;
									j2 = 0;
									asileholder = asile3;
									return firstHolder3;
								}
								//goes to next point
								if (i2 % 2 == 0) {
									j2 = 1;
								} else {
									j2 = 4;
								}
								i2++;
							}
						} else {
							//points to check
							i2 = i3;
							j2 = j3;
						}
						LJ = j2;
						//worst case scenario if there is no seats of that asile with there group then fit them in 
						if (peps3 == 0) {
							ultaholder = (int) (Lz);
							ultaholder = ultaholder + 4;
							charholder = (char) (ultaholder);
							ultacharholder = (Integer.toString(LI + 6)) + (Character.toString(charholder));
							y[i2][j2] = ultacharholder;
							asileholder = asile3;
							return ultacharholder;

						}
						//single person gets filled in
						char z2 = (char) (y2 + 4);
						firstHolder3 = (Integer.toString(i2 + 6)) + (Character.toString(z2));
						y[i2][j2] = firstHolder3;
						asileholder = asile3;
						i2 = 0;
						j2 = 0;
						break;
					}
				}
				//goes to next point
				j2 = j2 + 1;
				if (j2 == 6) {
					j2 = 0;
					i2 = i2 + 1;
				}
			}
		}
		return firstHolder3;
	}

	private static String Firstnumber(Passenger.SeatType asile2, int peps2) {
		//first class 
		
		String firstHolder2 = "";
		//holder
		int i = 0, j = 0;
		int holdery = 0;
		//second holder
		int y = 65;
		//letter start for 'A'
		
		//these 4 if statements state that if only one person is sitting that only one person can go next to them
		if ((peps2 == 1) && (x[lastPositionI][lastPositionJ] == "R")) {
			if (lastPositionJ == 0) {
				x[lastPositionI][lastPositionJ] = ((Integer.toString(lastPositionI + 1)) + ((char) y));
				firstHolder2 = x[lastPositionI][lastPositionJ];

			}
			//""
			if (lastPositionJ == 1) {
				holdery = y + 2;
				x[lastPositionI][lastPositionJ] = ((Integer.toString(lastPositionI + 1)) + ((char) holdery));
				firstHolder2 = x[lastPositionI][lastPositionJ];
			}
			//""
			if (lastPositionJ == 2) {
				holdery = y + 3;
				x[lastPositionI][lastPositionJ] = ((Integer.toString(lastPositionI + 1)) + ((char) holdery));
				firstHolder2 = x[lastPositionI][lastPositionJ];
			}
			//""
			if (lastPositionJ == 3) {
				holdery = y + 5;
				x[lastPositionI][lastPositionJ] = ((Integer.toString(lastPositionI + 1)) + ((char) holdery));
				firstHolder2 = x[lastPositionI][lastPositionJ];
			}

		
			return firstHolder2;
		}
//finds a seat and fills it with either the seat or a reservation 
		if (Passenger.SeatType.W == asile2) {
			while (i <= 12) {

				if (x[i][j] == null) {
					if (j == 0) {
						//column 1
						char z = (char) (y + j);
						firstHolder2 = (Integer.toString(i + 1)) + (Character.toString(z));
						x[i][j] = firstHolder2;
						if (peps2 == 1) {
							//reserves a spot
							x[i][j + 1] = "R";
							lastPositionI = i;
							lastPositionJ = j + 1;

						}
						i = 0;
						j = 0;
						break;
					}
					if (j == 3) {
						//column 4
						char z = (char) (y + j + 2);
						firstHolder2 = (Integer.toString(i + 1)) + (Character.toString(z));
						x[i][j] = firstHolder2;
						if (peps2 == 1) {
							//reserves a spot
							x[i][j - 1] = "R";
							lastPositionI = i;
							lastPositionJ = j - 1;

						}
						i = 0;
						j = 0;
					}
					break;

				}
				j = j + 1;
				if (j == 4) {
					//goes to next point
					j = 0;
					i = i + 1;
				}

			}

		}

		i = 0;
		j = 0;

		if (Passenger.SeatType.A == asile2) {
			while (i <= 12) {
				if (x[i][j] == null) {
					if (j == 1) {
						//column 2
						char z = (char) (y + j + 1);
						firstHolder2 = (Integer.toString(i + 1)) + (Character.toString(z));
						x[i][j] = firstHolder2;
						if (peps2 == 1) {
							//reserves a position
							x[i][j - 1] = "R";
							lastPositionI = i;
							lastPositionJ = j - 1;
						}
						i = 0;
						j = 0;
						break;
					}
					if (j == 2) {
						//column 3
						char z = (char) (y + j + 1);
						firstHolder2 = (Integer.toString(i + 1)) + (Character.toString(z));
						x[i][j] = firstHolder2;
						if (peps2 == 1) {
							//reserves a position
							x[i][j + 1] = "R";
							lastPositionI = i;
							lastPositionJ = j + 1;

						}
						i = 0;
						j = 0;
						break;

					}
				}
				j = j + 1;
				if (j == 4) {
					//goes to next point
					j = 0;
					i = i + 1;
				}

			}
		}
		return firstHolder2;

	}

}

