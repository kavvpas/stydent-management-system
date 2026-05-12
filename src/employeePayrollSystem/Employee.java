package employeePayrollSystem;

public class Employee {
        private String name;
        private double baseSalary;

        public Employee(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }

        // 每个员工计算工资的方式不同，这里定义一个通用的
        public void calculateSalary() {
            System.out.println(name + "'s salary is: " + baseSalary);
        }

        public String getName() { return name; }
}
