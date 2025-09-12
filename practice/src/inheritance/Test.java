package inheritance;

public class Test {
    public static void main(String[] args){
        Teacher t1 = new Teacher(); // child class
        Teacher t2 = new Teacher();
        Teacher t3 = new Teacher();
//input the attribute or variable value
        t1.name = "Fayad";
        t1.age = 21;
        t1.qualification = "student";
        t1.displayinformation2(); // display the attribute value

        t2.name = "Rakib";
        t2.age = 29;
        t2.qualification = "Teacher";
        t2.displayinformation2();

        t3.name = "Faisal";
        t3.age = 23;
        t3.qualification = "Student";
        t3.displayinformation2();


    }
}
