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
public class Employer extends Person {
  //constants
  public static final int NETWAGE = 0;

  //Employer's properties
  private int netwage;

  //constructor
  public Employer() {
    this(Person.FIRSTNAME, Person.LASTNAME, Person.AGE, Person.ADDRESS, Employer.NETWAGE);
  }

  public Employer(String firstName, String lastName, byte age, Address address, int netwage) {
    super(firstName, lastName, age, address);
    this.netwage = netwage;

  }


  public int getNetwage() {
    return netwage;
  }

  public void setNetwage(int netwage) {
    this.netwage = netwage;
  }

  @Override
public String toString() {
    return super.toString() + ", Netwage:" + this.netwage;
  }

  public static void main(String[] args) {
    Employer e = new Employer();

    e.setFristName("Huy").setLastName("Pham").setAge((byte) 20);
    e.setAddress("Ha noi", "Thanh Xuan", "Nguyen Trai");
    e.setNetwage(150000000);
    System.out.print(e);
  }

}
