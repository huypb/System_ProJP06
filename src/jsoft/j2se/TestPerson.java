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
public class TestPerson {


  public static void main(String[] args) {
    Address addr1= new Address("Ha noi","Thanh xuan", "Nguyen trai");
    Address addr2 = new Address("Ha noi","Hoan Kiem","Ly Thai To");

    Person s= new Student("Huy","Pham",(byte)20, addr1,"(2012)007");
    Person e = new Employer("Hung","Vu",(byte)30,addr2,600000);

    System.out.println(s);
    System.out.print(e);
  }
}
