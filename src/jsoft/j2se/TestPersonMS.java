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
public class TestPersonMS {
  public static void main(String[] args) {
    PersonMS p = new PersonMSImpl();

    Address addr = new Address("Ha noi","Tu Liem","32");
    Employer e =new Employer("Huy","Pham",(byte)20,addr,150000);
    p.addEmployer(e);


  }
}
