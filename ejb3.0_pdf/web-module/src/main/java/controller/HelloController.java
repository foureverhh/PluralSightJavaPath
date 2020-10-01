package controller;

import Dao.ChinaDao;
import Dao.HelloEJBRemote;
import DaoImpl.ChinaDaoBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.Serializable;

@Named
@SessionScoped
public class HelloController implements Serializable {
    public static final Long serialVersionUID = 1L;
    private String info;
    private String helloRemote;


    @EJB
    private ChinaDao chinaDaoBean;

    @EJB
    private HelloEJBRemote helloEJBRemote;


    public HelloController() {
    }

    @PostConstruct
    public void init()  {
/*
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
            ChinaDao chinaDao = (ChinaDao) ctx.lookup("hello");//DaoImpl/ChinaDaoBean.java
            info = chinaDao.sayHello("Li");
        } catch (NamingException e) {
            e.printStackTrace();
        }*/

        info = chinaDaoBean.sayHello("Li");
        helloRemote = helloEJBRemote.hello("remote interface called.");
    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHelloRemote() {
        return helloRemote;
    }

    public void setHelloRemote(String helloRemote) {
        this.helloRemote = helloRemote;
    }
}
