public class EmpWageComputation {
	public static final int IS_PART_TIME = 1;                    
	public static final int IS_FULL_TIME = 2;
	
	private final String company;
	private final int numOfWorkingDays;
	private final int  empRatePerHour;
	private final int maxHoursPerMonth;
	private int totalEmpWage;
	
	public EmpWageComputation(String company, int empRatePerHour,
			int numOfWorkingDays, int maxHoursPerMonth) {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
	}
		public void buildEmpWage() {
		//Variables
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		//Computation
		while (totalEmpHrs <= maxHoursPerMonth && totalWorkingDays < numOfWorkingDays) {
			totalWorkingDays++;
		int empCheck = (int) Math.floor(Math.random() * 10) % 3;
		switch (empCheck) {
			case IS_FULL_TIME:		//working full time
				empHrs = 8;
				break;
			case IS_PART_TIME:		//working part time
				empHrs = 4;
				break;
			default:
				empHrs = 0;		//Employee is Absent
		}
			totalEmpHrs += empHrs;
			System.out.println("Day:"+ totalWorkingDays+ " Employee Working Hours:"+empHrs);
		}
		 totalEmpWage = totalEmpHrs * empRatePerHour;
		System.out.println("Employee Rate per hour:" +empRatePerHour);
		}
		@Override
		public String toString() {
		return "Total Employee Wage For Company:" +company+ " is:"+ totalEmpWage;
	}
	public static void main(String[] args) {
		EmpWageComputation google = new EmpWageComputation("Google", 20, 2, 10);
		EmpWageComputation microsoft = new EmpWageComputation("Microsoft", 10, 4, 20);
		google.buildEmpWage();
		System.out.println(google);
		microsoft.buildEmpWage();
		System.out.println(microsoft);
	}
}
