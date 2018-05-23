package hw5;

/**
 * Homework #5
 *
 * @author Aleksandr Kurov
 * @version dated Май 22, 2018
 */
public class Runner {
    public static void main(String[] args) {

        // Task 1: OOP Basics
        Employee[] employeeDb = new Employee[5];

        employeeDb[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89451234555", 30000, 30);
        employeeDb[1] = new Employee("Doe John", "Programmer", "dojohn@mailbox.com", "89451234555", 40589, 42);
        employeeDb[2] = new Employee("Gromova Sveta", "SEO Specialist", "grsveta@mailbox.com", "89650001234", 25500, 28);
        employeeDb[3] = new Employee("Brode Ben", "Game Director", "brben@mailbox.com", "82251234588", 60000, 35);
        employeeDb[4] = new Employee("Schildt Herbert", "Programmer", "schherbert@mailbox.com", "81112658709", 52300, 67);

        for (Employee emp : employeeDb) {
            if (emp.getAge() > 40) {
                emp.getEmployeeInfo();
            }
        }

        System.out.println();

        // Task 2: TicTacToe OOP Style
        new TicTacToeOOP();

    }
}
