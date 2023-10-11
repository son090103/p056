
package reponsitory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import model.History;
import model.Worker;
import validation.Validation;


public class List implements IList{
    public ArrayList<History> lh = new ArrayList<>();
    public ArrayList<Worker> lw = new ArrayList<>();
    
    public Validation v = new Validation();

    @Override
    public void addWorker() {
        System.out.print("Enter code: ");
        String id = v.checkInputString();
        System.out.print("Enter name: ");
        String name = v.checkInputString();
        System.out.print("Enter age: ");
        int age = v.checkInputInt(18, 50);
        System.out.print("Enter salary: ");
        int salary = v.checkInputsalary();
        System.out.print("Enter work location: ");
        String workLocation = v.checkInputString();
        if (v.checkWorkexsit(lw, id, name, age, salary, workLocation)==true) {
            System.err.println("Duplicate.");
        } else {
            lw.add(new Worker(id, name, age, salary, workLocation));
            System.err.println("Add success.");
        }
    }

     public void printListHistory() {
        if (lh.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(lh);
        for (History history : lh) {
            printHistory(history);
        }
    }
     public void printHistory(History history) {
        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getID(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }

    @Override
    public void changeSalary(int status) {
          if (lw.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter code: ");
        String id = v.checkInputString();
        Worker worker = getWorkerByCode(id);
        if (worker == null) {
            System.err.println("Not exist worker.");
        } else {
            int salaryCurrent = worker.getSalary();
            int salaryUpdate;
            
            if (status == 1) {
                System.out.print("Enter salary: ");
                //loop until user input salary update > salary current
                while (true) {     
                    salaryUpdate = v.checkInputsalary();
                    //check user input salary update > salary current
                    if (salaryUpdate <= salaryCurrent) {
                        System.err.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("UP", getCurrentDate(), worker.getID(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorklocation()));
            } else {
                System.out.print("Enter salary: ");
                //loop until user input salary update < salary current
                while (true) {
                    salaryUpdate = v.checkInputsalary();
                    //check user input salary update < salary current
                    if (salaryUpdate >= salaryCurrent) {
                        System.err.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("DOWN", getCurrentDate(), worker.getID(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorklocation()));
            }
            worker.setSalary(salaryUpdate);
            System.err.println("Update success");
        }
    }
     public Worker getWorkerByCode(String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getID())) {
                return worker;
            }
        }
        return null;
    }

    public String getCurrentDate() {
        Scanner scanner = new Scanner(System.in);
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    while (true) {
        System.out.print("Enter a date (dd/MM/yyyy): ");
        String inputDate = scanner.nextLine();

        try {
            Date date = dateFormat.parse(inputDate);
            return dateFormat.format(date);
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please use dd/MM/yyyy format.");
        }
    }
}
}
