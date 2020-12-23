public interface IComputeEmpWage {
	public void addEmpWageComputation(String company, int empRatePerHour,
										int numOfWorkingDays, int maxHoursPerMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
}
public class EmpWageComputation {	
	public final String company;
	public final int numOfWorkingDays;
	public final int  empRatePerHour;
	public final int maxHoursPerMonth;
	public int totalEmpWage;
	
	public EmpWageComputation(String company, int empRatePerHour,
			int numOfWorkingDays, int maxHoursPerMonth) {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
		totalEmpWage = 0;
	}
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}
	@Override
	public String toString() {
	return "Total Employee Wage For Company:" +company+ " is:"+ totalEmpWage;
	}
}
		
