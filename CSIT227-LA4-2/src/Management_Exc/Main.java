package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        boolean foundEmployee = false;
        boolean foundManager = false;
        int mark =0;


            for (Person p : persons) {

                if (p.getName().equals(manager)) {

                    if (p instanceof Manager) {
                        foundManager = true;
                        for (Person x : persons) {
                            if (x.getName().equals(employee)) {
                                foundEmployee = true;
                                if (x instanceof Employee) {
                                    ((Manager) p).giveRaise((Employee) x, salary);
                                    mark =1;
                                    break;

                                } else {
                                    throw new ClassCastException(employee + " is not an employee");
                                }
                            }
                        }
                    } else {
                        throw new ClassCastException(manager + " is not a manager");
                    }
                    if(mark == 1){
                        break;
                    }
                }
            }
            if(!foundManager){
                throw new NoSuchElementException(manager + " does not exist");
            }
            if (!foundEmployee) {
                throw new NoSuchElementException(employee + " does not exist");
            }



    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        boolean findDev = false;
        boolean findManager = false;
        boolean done = false;
        for(Person p : persons){
            if(p.getName().equals(developer)){
                if(p instanceof Developer){
                    findDev = true;
                    for(Person x : persons){
                        if(x.getName().equals(manager)){
                            if(x instanceof Manager){
                                findManager = true;
                                ((Developer) p).setProjectManager((Manager) x);
                                done = true;
                                break;
                            }else{
                                throw new ClassCastException(manager+ " is not a manager");
                            }

                        }
                    }
                }else{
                    throw new ClassCastException(developer + " is not a developer");
                }

                //find the manager

                if(done){
                    break;
                }

            }
        }
        if(!findManager){
            throw new NoSuchElementException(manager + " does not exist");
        }

        if(!findDev){
            throw new NoSuchElementException(developer+ " does not exist");
        }

    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws IllegalArgumentException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        boolean findCustomer = false;
        boolean findEmployee = false;
        boolean done = false;
        String result = "";
        for(Person p: persons){
            if(p.getName().equals(customer)){
                if(p instanceof  Customer){
                    findCustomer = true;
                    for(Person x : persons){
                        if(x.getName().equals(employee)){
                            findEmployee = true;
                            if(x instanceof Employee){
                               result = ((Customer) p).speak((Employee) x);
                            }else{
                                throw new ClassCastException(employee+ " is not an employee");
                            }
                        }
                    }

                }else{
                    throw new ClassCastException(customer+ " is not a customer");
                }


            }
        }



        if(!findCustomer){
            throw new NoSuchElementException(customer + " does not exist");
        }
        if(!findEmployee){
            throw new NoSuchElementException(employee + " does not exist");
        }

        return result;
    }
}
