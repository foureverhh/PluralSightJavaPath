package Dao;

import javax.ejb.Remote;

@Remote
public interface HelloEJBRemote {
    String hello(String name);
}
