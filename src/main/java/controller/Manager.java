
package controller;

import menu.Menu;
import reponsitory.List;


public class Manager extends Menu{
    private List l = new List();
    public Manager(String title, String []mc){
        super(title, mc);
    }
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                l.addWorker();
                break;
            case 2: 
                l.changeSalary(1);
                break;
            case 3: 
                l.changeSalary(2);
                break;
            case 4: 
                l.printListHistory();
            case 5:
                return;
            default:
                throw new AssertionError();
        }
    }
    
}
