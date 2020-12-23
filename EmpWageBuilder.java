import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class EmpWageBuilder implements IComputeEmpWage {
	public static final int IS_PART_TIME = 1;                    
	public static final int IS_FULL_TIME = 2;
			
	private int numOfCompany = 0;
	private LinkedList<EmpWageComputation> empWageComputationList;
	private Map<String,EmpWageComputation> toEmpWageComputationMap;
	
	public EmpWageBuilder() {
		empWageComputationList = new LinkedList<>();
		toEmpWageComputationMap = new HashMap<>();
	}
	public void addEmpWageComputation(String company, int empRatePerHour,
			int numOfWorkingDays, int maxHoursPerMonth) {
	EmpWageComputation empWageComputation = new EmpWageComputation(company,empRatePerHour,
													numOfWorkingDays, maxHoursPerMonth);
	empWageComputationList.add(empWageComputation);
	toEmpWageComputationMap.put(company,empWageComputation);
	}           
	public void computeEmpWage() {
	for(int i = 0;i < empWageComputationList.size(); i++) {
		EmpWageComputation empWageComputation = empWageComputationList.get(i);
		empWageComputation.setTotalEmpWage(this.computeEmpWage(empWageComputation));
		System.out.println(empWageComputation);
	}
}
	@Override
	public int getTotalWage(String company) {
		return toEmpWageComputationMap.get(company).totalEmpWage;
	}
	public int computeEmpWage(EmpWageComputation empWageComputation) {
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
		IComputeEmpWage empWageBuilder = new EmpWageBuilder();
		empWageBuilder.addEmpWageComputation(company:"Google",empRatePerHour: 20,numOfWorkingDays: 2,maxHoursPerMonth: 10);
		empWageBuilder.addEmpWageComputation(company:"Microsoft",empRatePerHour: 10,numOfWorkingDays: 4,maxHoursPerMonth: 20);
		empWageBuilder.computeEmpWage();
		System.out.println("Total Wage for Google Company: " +empWageBuilder.getTotalWage(company:"Google"));
	}
}

