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
public class ManagerStudent extends Manager {




  /**
   * getAge
   *
   * @param name String
   * @return byte
   * @todo Implement this jsoft.j2se.Manager method
   */
  @Override
public byte getAge(String name) {
    return (byte)(18+(Math.random()*12));
  }

  /**
   * getApplyYear
   *
   * @param name String
   * @return int
   * @todo Implement this jsoft.j2se.Manager method
   */
  @Override
public int getApplyYear(String name) {
    return (int)(Math.random()*5);
  }


  public static void main(String[] args) {
    Manager ms = new ManagerStudent();
    System.out.println("Apply Year: "+ms.getApplyYear("Huy"));
    System.out.print("Age: "+ms.getAge("Huy"));
  }
}
