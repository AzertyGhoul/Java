package My;

import java.util.ArrayList;

/**
 * Этот класс представляет собой компанию, которая содержит список сотрудников.
 */
public class Company {
    private ArrayList<Employee> Employees = new ArrayList<Employee>();

    /**
     * Добавляет сотрудника в компанию.
     *
     * @param employee сотрудник для добавления
     */
    public void addEmployee(Employee employee) {
        Employees.add(employee);
    }

    /**
     * Удаляет сотрудника из компании.
     *
     * @param employee сотрудник для удаления
     */
    public void removeEmployee(Employee employee) {
        Employees.remove(employee);
    }

    /**
     * Проверяет, содержит ли компания указанного сотрудника.
     *
     * @param employee сотрудник для проверки
     * @return true, если компания содержит сотрудника, иначе false
     */
    public Boolean containEmployee(Employee employee) {
        return Employees.contains(employee);
    }

    /**
     * Конструктор по умолчанию.
     * Создает компанию без сотрудников.
     */
    public Company() {
    }

    /**
     * Конструктор с параметрами.
     * Создает компанию с заданным списком сотрудников.
     *
     * @param Employees список сотрудников
     */
    public Company(ArrayList<Employee> Employees) {
        this.Employees = Employees;
    }

    /**
     * Выводит количество сотрудников по часовой оплате и по окладу.
     */
    public void amountOfEmployees() {
        int forHour = 0;
        int forSalary = 0;

        for (Employee worker : Employees) {
            if (worker instanceof EmployeeForHour) {
                forHour++;
            } else {
                forSalary++;
            }
        }

        System.out
                .print("\nРаботники по часовой оплате : " + forHour + "\nРаботники по окладу : " + forSalary + "\n\n");
    }

    /**
     * Выводит информацию о всех сотрудниках компании.
     */
    public void printAllEmployees() {
        for (Employee worker : Employees) {
            System.out.print(worker.toString());
        }
    }
}
