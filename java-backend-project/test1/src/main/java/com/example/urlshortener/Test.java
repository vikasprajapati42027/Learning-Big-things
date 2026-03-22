class Employee extends cloneable{
    int id;
    String name;
    public  Employee(int id,String name)
    {
        this.id=id;
        this.name=name;
    }


    public Employee clone(){
        return new Employee()super.clone();
    }

    public static void main(String[] args) {
        Employee emp1= new Employee(101,"vikas");
        Employee emp2= emp1.clone();
        System.out.println(emp2);
    }
}
