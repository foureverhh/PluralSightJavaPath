package DaoImpl;

import Dao.HelloEJBRemote;

import javax.ejb.Stateless;

@Stateless
public class HelloEJBRemoteBean implements HelloEJBRemote {
    @Override
    public String hello(String name) {
        return "HelloEJBRemote interface say hello to  " + name;
    }
}
