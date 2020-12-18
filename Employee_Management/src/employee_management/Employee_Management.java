package employee_management;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee_Management {

    public static void main(String[] args) throws SQLException {

        int n;

        Scanner input = new Scanner(System.in);

        for (int i = 0;; i++) {
            System.out.println();
            System.out.println("Employee Manegement\n");
            System.out.println("Enter 1 for Add Employee");
            System.out.println("Enter 2 for Delete Employee");
            System.out.println("Enter 3 for Update Employee");
            System.out.println("Enter 4 for View Employee\n\n");

            n = input.nextInt();

            if (n == 1) {
                String name, phone, email, voter;
                int age, id;

                System.out.println("Enter ID");

                id = input.nextInt();

                System.out.println("Enter Name");

                name = input.next();

                System.out.println("Enter Age");

                age = input.nextInt();

                System.out.println("Enter Mobile Number");

                phone = input.next();

                System.out.println("Enter Voter ID Number");

                voter = input.next();

                System.out.println("Enter Email");

                email = input.next();

                try {
                    conn c = new conn();
                    String str = "INSERT INTO add_employee values( '" + id + "', '" + name + "', '" + age + "','" + phone + "', '" + voter + "', '" + email + "')";

                    c.s.executeUpdate(str);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("Add Employee Successfully\n\n");

                continue;

            } 
            
            else if (n == 2) {
                int Did;

                System.out.println("Enter Employee Id");

                Did = input.nextInt();

                try {
                    conn con = new conn();
                    String str = "delete from add_employee where id = '" + Did + "'";
                    con.s.executeUpdate(str);

                } catch (Exception ex) {
                }

                System.out.println("Employee Delete Successfully\n\n");

                continue;
            } 
            
            else if (n == 3) {
                System.out.println("Update Employee Information");

                String Uname, Uphone, Uemail, Uvoter;
                int Uage, Uid;

                System.out.println("Enter Employee ID");

                Uid = input.nextInt();

                System.out.println("Enter Name");

                Uname = input.next();

                System.out.println("Enter Age");

                Uage = input.nextInt();

                System.out.println("Enter Mobile Number");

                Uphone = input.next();

                System.out.println("Enter Voter ID Number");

                Uvoter = input.next();

                System.out.println("Enter Email");

                Uemail = input.next();

                try {
                    conn con = new conn();
                    String str = "update add_employee set name='" + Uname + "',age='" + Uage + "',phone='" + Uphone + "',voter='" + Uvoter + "',email='" + Uemail + "'where id ='" + Uid + "'";
                    con.s.executeUpdate(str);

                } catch (Exception e) {

                }

                System.out.println("Update Employee Information Successfully\n\n");

                continue;
            } 
            
            else if (n == 4) {
                System.out.println("All Employee List");
                System.out.println("Id\tName      Age        Phone           Voter     \t\tEmail");
                System.out.println("__\t____      ___        _____           _____     \t\t_____");
                conn con = new conn();
                String sql = "select * from add_employee";
                //Statement st = con.createStatement();
                ResultSet result = con.s.executeQuery(sql);
                while (result.next()) {
                    System.out.println(result.getString("id") + "      "
                            + result.getString("name") + "      "
                            + result.getString("age") + "      "
                            + result.getString("phone") + "      "
                            + result.getString("voter") + "      "
                            + result.getString("email"));
                }

            } else {
                System.out.println("Not Found");
            }
        }
    }
}
