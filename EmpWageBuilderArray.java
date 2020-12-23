
public class EmpWageBuilderArray {
	public static final int IS_PART_TIME = 1;                    
	public static final int IS_FULL_TIME = 2;
		
	private int numOfCompany = 0;
	private EmpWageComputation[] empWageComputationArray;
	
	public EmpWageBuilderArray () {
		empWageComputationArray = new EmpWageComputation[5];
	}
	private void addEmpWageComputation(String company, int empRatePerHour,
			int numOfWorkingDays, int maxHoursPerMonth) {
	empWageComputationArray[numOfCompany] = new EmpWageComputation(company,empRatePerHour,
													numOfWorkingDays, maxHoursPerMonth);
	numOfCompany++;
	}           
private void computeEmpWage() {
	for(int i = 0;i < numOfCompany; i++) {
		empWageComputationArray[i].setTotalEmpWage(this.computeEmpWage(empWageComputationArray[i]));
		System.out.println(empWageComputationArray[i]);
	}
}
		
	private int computeEmpWage(EmpWageComputation empWageComputation) {
	//Variables
	int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
	//Computation
	while (totalEmpHrs <= empWageComputation.maxHoursPerMonth && 
				totalWorkingDays < empWageComputation.numOfWorkingDays) {
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
	 return totalEmpHrs * empWageComputation.empRatePerHour;
		}
	
	public static void main(String[] args) {
		EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();
		empWageBuilder.addEmpWageComputation("Google", 20, 2, 10);
		empWageBuilder.addEmpWageComputation("Microsoft", 10, 4, 20);
		empWageBuilder.computeEmpWage();
	}
}

