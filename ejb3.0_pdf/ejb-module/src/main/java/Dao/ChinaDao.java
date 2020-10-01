package Dao;

import javax.ejb.Local;

@Local
public interface ChinaDao {
    public String sayHello(String name);
}
