public class Passenger {
	public enum ClassType {First, Econ};
	public enum SeatType {W, A, C};
	public ClassType c;
	public SeatType s;
	private String first;
	private String last;
	private int n;

	public Passenger(String firstName, String lastName, String x, String y, int num) {
		first = firstName;
		last = lastName;
		c = ClassType.valueOf(x);
		s = SeatType.valueOf(y);
		n = num;
	}
	
	public String getSeat() {
		return Plane.Placeholder(c, s, n);
	}
	
	public String getReservation() {
		return first + " " + last + "          seat" + getSeat();
  	}

}

