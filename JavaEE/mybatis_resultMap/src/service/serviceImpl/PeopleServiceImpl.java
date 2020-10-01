package service.serviceImpl;

//只在数据访问层和控制层中处理异常，service中只抛异常
/*public class PeopleServiceImpl implements PeopleService {




    @Override
    public List<People> showAll() throws IOException {
        //加载配置文件，在mybatis.xml中的mapper里设置了resource
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        List<People> people = session.selectList("com.peopleMapper.selectAll");
        session.close();
        System.out.println(people);
        return people;
    }
}*/
