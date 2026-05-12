package employeePayrollSystem;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public void calculateSalary() {
        // 经理的工资 = 底薪 + 奖金
        System.out.println(getName() + " (Manager) total salary: " + (200000 + bonus));
    }
}
