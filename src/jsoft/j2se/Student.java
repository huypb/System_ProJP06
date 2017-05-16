package jsoft.j2se;

/**
 * <p>Title: JP project</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2012</p>
 *
 * <p>Company: </p>
 *
 * @author Huy
 * @version 1.0
 */
public class Student extends Person {

  //constants
  public static final String ID= "(2012)000000";

  //Student's properties
  private String id;

  //constructor
  public Student(){
    this(Person.FIRSTNAME,Person.LASTNAME, Person.AGE, Person.ADDRESS, Student.ID);
  }
  public Student(String firstName, String lastName, byte age, Address address, String id){

    super(firstName, lastName, age,address);
    this.id=id;
  }



  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
public String toString(){
    return super.toString()+", ID:"+this.id;
  }

  public static void main(String[] args) {
    Student s = new Student();

    s.setFristName("Huy").setLastName("Pham").setAge((byte)20);
    s.setAddress("Hanoi"," Thanh Xuan", " Nguyen Trai");
    s.setId("(2012)007");
    System.out.print(s);
  }


  }

