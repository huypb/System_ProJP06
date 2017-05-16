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
public class ManagerEmployer extends Manager {
  /**
   * getAge
   *
   * @param name String
   * @return byte
   * @todo Implement this jsoft.j2se.Manager method
   */
  @Override
public byte getAge(String name) {
    return (byte)(20+(Math.random()*40));
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
    return (int)(Math.random()*40);
  }

  public static void main(String[] args) {
    Manager me = new ManagerEmployer();

    System.out.println("Apply Year: "+me.getApplyYear("Tuan"));
    System.out.print("Age: "+me.getAge("Tuan"));
  }
}
