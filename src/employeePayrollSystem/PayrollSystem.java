package employeePayrollSystem;

public class PayrollSystem {
    public static void main(String[] args) {
        // 多态的精髓：父类引用指向子类对象
        Employee emp1 = new Manager("Tanaka", 300000, 50000);
        Employee emp2 = new Employee("Sato", 250000);

        // 统一调用相同的方法，但执行的是各自不同的逻辑
        showSalary(emp1);
        showSalary(emp2);
    }

    // 只要是员工，这个方法都能接收，这就是多态的好处！
    public static void showSalary(Employee e) {
        e.calculateSalary();
    }
}
