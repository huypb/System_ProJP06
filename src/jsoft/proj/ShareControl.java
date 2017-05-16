package jsoft.proj;


public interface ShareControl {
  public ConnectionPool getConnectionPool();
  public void releaseConnection();

}
