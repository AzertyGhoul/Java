import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;

public class DataBase {
    Connection conn = null; // объект для связи с БД
    Statement stmt = null; // объект для создания SQL-запросов
    HashMap<String, String> selectsForTables;

    DataBase(String curPath) {
        super();
        try {
            Class.forName("org.h2.Driver"); // подгружаем драйвер для H2
            conn = DriverManager.getConnection("jdbc:h2:" + curPath + "\\src\\myDB", "sa", "");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Содинение не выполнено");
        } finally {
            if (conn != null) {
                System.out.println("Соединение успешно " + conn);
                selectsForTables = new HashMap<>();
                selectsForTables.put("Company", "SELECT Name, Capitalization, Employees FROM Company");
                selectsForTables.put("Employee", "SELECT Name, Position, Salary FROM Employee");
                selectsForTables.put("Projects", "SELECT Name, Company, Budget FROM Projects");
                selectsForTables.put("Task", "SELECT Name, Employee, Project FROM Task");

            }
        }
    }

    public void CreateTables() {
        try {
            String Company = "CREATE TABLE Company (Id INT PRIMARY KEY AUTO_INCREMENT, Name char(20), Capitalization INT, Employees INT)";
            String CompanyFields = "INSERT INTO Company(Name, Capitalization, Employees) VALUES " +
                    "('ABC Corp', 1000000, 50), " +
                    "('XYZ Ltd', 500000, 30), " +
                    "('Tech Innovators', 2000000, 80), " +
                    "('Global Solutions', 1500000, 60), " +
                    "('Innovate Co', 800000, 40)";
            stmt.executeUpdate(Company);
            stmt.executeUpdate(CompanyFields);

            String Employee = "CREATE TABLE Employee (Id INT PRIMARY KEY AUTO_INCREMENT, Name char(20), Position char(20), Salary FLOAT)";
            String EmployeeFields = "INSERT INTO Employee(Name, Position, Salary) VALUES " +
                    "('John Doe', 'Software Engineer', 80000.0), " +
                    "('Jane Smith', 'Project Manager', 100000.0), " +
                    "('Bob Johnson', 'Data Analyst', 75000.0), " +
                    "('Alice Brown', 'QA Tester', 70000.0), " +
                    "('Charlie Wilson', 'System Administrator', 85000.0)";
            stmt.executeUpdate(Employee);
            stmt.executeUpdate(EmployeeFields);

            String Projects = "CREATE TABLE Projects (Id INT PRIMARY KEY AUTO_INCREMENT, Name char(20), Company char(20), Budget INT)";
            String ProjectFields = "INSERT INTO Projects(Name, Company, Budget) VALUES " +
                    "('Project Alpha', 'ABC Corp', 200000), " +
                    "('Project Beta', 'Tech Innovators', 300000), " +
                    "('Project Gamma', 'Global Solutions', 250000), " +
                    "('Project Delta', 'Innovate Co', 180000), " +
                    "('Project Epsilon', 'XYZ Ltd', 150000)";
            stmt.executeUpdate(Projects);
            stmt.executeUpdate(ProjectFields);

            String Task = "CREATE TABLE Task (Id INT PRIMARY KEY AUTO_INCREMENT, Name char(20), Employee char(20), Project char(20))";
            String TaskFields = "INSERT INTO Task(Name, Employee, Project) VALUES " +
                    "('Task 1', 'John Doe', 'Project Alpha'), " +
                    "('Task 2', 'Jane Smith', 'Project Beta'), " +
                    "('Task 3', 'Bob Johnson', 'Project Gamma'), " +
                    "('Task 4', 'Alice Brown', 'Project Delta'), " +
                    "('Task 5', 'Charlie Wilson', 'Project Epsilon')";
            stmt.executeUpdate(Task);
            stmt.executeUpdate(TaskFields);

        } catch (SQLException e) {
        }
    }

    public void showTables(String tableName) {
        try {
            ResultSet rs = stmt.executeQuery(selectsForTables.get(tableName));
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rsmd.getColumnName(i) + " : " + rs.getString(i) + " ");
                }
                System.out.println("");
            }
        } catch (

        SQLException e) {
        }
    }

    public JTable getTable(String tableName) {
        ResultSet rs = null;

        ArrayList<String> colNames = new ArrayList<>();
        String[][] tableData = null;

        try {
            rs = stmt.executeQuery(selectsForTables.get(tableName));
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnsNumber = rsmd.getColumnCount();
            for (int i = 1; i <= columnsNumber; i++) {
                colNames.add(rsmd.getColumnName(i));
            }

            rs.last();
            int rowCount = rs.getRow();

            tableData = new String[rowCount][colNames.size()];
            rs.beforeFirst();

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    tableData[rs.getRow() - 1][i - 1] = rs.getString(i);
                }
            }
        } catch (SQLException e) {
            System.out.println("Trouble with query!!");
            e.printStackTrace();
        }

        JTable tempTable = new JTable(tableData, colNames.toArray());
        return tempTable;
    }

    public void closeConnetion() {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }

}