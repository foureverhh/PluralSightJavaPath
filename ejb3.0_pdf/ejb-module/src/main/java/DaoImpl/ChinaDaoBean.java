package DaoImpl;

import Dao.ChinaDao;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless//(mappedName = "hello")
@Local(ChinaDao.class)
public class ChinaDaoBean implements ChinaDao {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
