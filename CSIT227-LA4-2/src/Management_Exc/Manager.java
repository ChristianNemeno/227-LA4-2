package Management_Exc;

public class Manager extends Employee {
    public Manager(String name, int age, double salary) {
        super(name, age, salary);
    }

    /**
     * TODO this implementation
     * @param e the employee to be given raise
     * @param raise the raise
     * @throws IllegalArgumentException when raise is negative
     */
    public void giveRaise(Employee e, double raise) {
        if(raise < 0){
            throw new IllegalArgumentException("Raise must be non-negative");
        }

        if(e instanceof Manager){
            e.setSalary(e.getSalary() + raise);
        }else{
            e.setSalary(e.getSalary() + raise);
            double ManagerRaise = raise / 2.0;
            this.setSalary(this.getSalary() + ManagerRaise);
        }

    }

    @Override
    public String toString() {
        return "Mgr. " +super.toString();
    }
}
