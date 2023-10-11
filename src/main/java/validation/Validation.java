
package validation;

import java.util.ArrayList;
import java.util.Scanner;
import model.History;
import model.Worker;


public class Validation {

    private final static Scanner sc = new Scanner(System.in);
    ArrayList<Worker> lw = new ArrayList<>();
    ArrayList<History> lh = new ArrayList<>();

    public static int checkInputInt(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (Exception e) {
                System.out.println("please Enter between " + min + "and " + max);
                System.out.println("Enter again: ");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Not Empty");
                System.out.println("Enter again: ");
            } else {
                return result;
            }
        }
    }
    // check tồn tại của ID

    public static boolean checkExxitID(ArrayList<Worker> lw, String ID) {
        for (Worker w : lw) {
            if (ID.contains(w.getID())) {
                return true;
            }
        }
        return false;
    }
    // nhập salary

    public static int checkInputsalary() {
        while (true) {
            try {
                int salary = Integer.parseInt(sc.nextLine().trim());
                if(salary<0)
                    throw new NumberFormatException();
                return salary;

            } catch (Exception e) {
                System.out.println("salary must be greater than 0");
                System.out.println("Enter again: ");
            }
        }
    }
    // check một người đã tồn tại trong danh sách hay chưa
    public static boolean checkWorkexsit(ArrayList<Worker> lw, String id , String name, int age, int salary, String woklocation){
       for(Worker w : lw){
           if(id.equals(w.getID())&&name.equals(w.getName())
                   && age==w.getAge()||salary==w.getSalary()&&woklocation.equals(w.getWorklocation()))
               return true;
       } 
      return false;
    }
    
}
