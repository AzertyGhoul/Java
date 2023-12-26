package My;

public class testCompany {
    public static void main(String[] args) {
        Company Bereg = new Company();

        EmployeeForHour Aleksei = new EmployeeForHour("Некрасов Алексей Викторович", 20, "Бармен", 160);
        EmployeeForHour Kiril = new EmployeeForHour("Кирилл Уколов Федорович", 21, "Репер", 10000);
        EmployeeForSalary Arsenyi = new EmployeeForSalary("Похилько Арсений Андреевич", 19,
                "Senior Full-Stack Developer",
                40000);

        Bereg.addEmployee(Aleksei);
        Bereg.addEmployee(Arsenyi);
        Bereg.addEmployee(Kiril);
        Bereg.printAllEmployees();
        Bereg.amountOfEmployees();
    }

}
