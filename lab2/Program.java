package lab2;

public class Program {
    public static void main(String[] args) {
        Employee employee1 = new Programmer("Ilya Sirenko", "IT", 2, "Python");
        employee1.work(8);
        employee1.breaks(12);
        Employee employee2 = new Administrator("John Doesn't", "IT", 5, 1999.99F);
        employee2.work(12);
        employee2.breaks(100);
        Employee employee3 = new Manager("Jane Doe", "IT", 20, 8);
        employee3.work(10);
        employee3.breaks(1221312312);
        Employee employee4 = new BachelorProgrammer("Idontcare Fornames", "IT", 2, "Java", "MTUCI");
        employee4.work(12);
        employee4.breaks(5);
        System.out.print(String.format("There are currently %d employees", Employee.employeeCount));

    }
}

abstract class Employee{
    protected String name;
    protected String department;
    protected int experience;
    protected static int employeeCount = 0;

    Employee(String nname, String ndep, int nexp){
        name = nname;
        department = ndep;
        experience = nexp;
        employeeCount += 1;
    }

    Employee(){
        name = "John Doe";
        department = "Undefined";
        experience = 0;
        employeeCount += 1;
    }

    public void work(int hours){
        System.out.println(String.format("there are %d work hours", hours));
    }
    public void breaks(int nb){
        System.out.println(String.format("there are %d breaks", nb));
    }

    public String getName(){
        return name;
    }

    public int getExp(){
        return experience;
    }
    public String getDep(){
        return department;
    }

    public void setName(String nname){
        name = nname;
    }

    public void setExp(int nexp){
        experience = nexp;
    }

    public void setDep(String ndep){
        department = ndep;
    }
}   

class Programmer extends Employee{
    protected String mainlang;
    Programmer(String nname, String ndep, int nexp, String nmainlang){
        super(nname, ndep, nexp);
        mainlang = nmainlang;
    }

    Programmer(){
        mainlang = "Java";
    }

    public void work(int hours){
        int totalHours = hours+experience/2;
        System.out.println(String.format("%s programmer %s works for %d hours", mainlang, name, totalHours));
    }

    public void breaks(int nb){
        System.out.println("Programmers have no breaks :(");

    }
}

class Administrator extends Employee{
    private float bonus;
    Administrator(String nname, String ndep, int nexp, Float nbonus){
        super(nname, ndep, nexp);
        bonus = nbonus;
    }

    Administrator(){
        bonus = 999.99F;
    }

    public void work(int hours){
        System.out.println(String.format("Administrator %s gets a %s bonus for working for %d hours", name, bonus, hours));
    }

    public void breaks(int nb){
        System.out.println("Administrators don't need breaks :)");

    }
}

class Manager extends Employee{
    private int hateHours;
    Manager(String nname, String ndep, int nexp, int nhateHours){
        super(nname, ndep, nexp);
        hateHours = nhateHours;
    }

    Manager(){
        hateHours = 8;
    }

    public void work(int hours){
        System.out.println(String.format("Manager %s hates programmers for %s hours in %d hour work day", name, hateHours, hours));
    }

    public void breaks(int nb){
        System.out.println(String.format("Managers get a break for each hour they hate programmers, this one has %d breaks", hateHours));
    }
}

class BachelorProgrammer extends Programmer{
    private String university;
    BachelorProgrammer(String nname, String ndep, int nexp, String nmainlang, String nuniversity){
        super(nname, ndep, nexp, nmainlang);
        university = nuniversity;
    }
    
    BachelorProgrammer(){
        university = "MTUCI";
    }

    public void work(int hours){
        int totalHours = hours+experience/2;
        System.out.println(String.format("%s bachelor programmer %s works for %d hours, graduated from %s", mainlang, name, totalHours, university));
    }

    public void breaks(int nb){
        System.out.println("Programmers have no breaks, even if they have a bachelors degreee :(");

    }
}
