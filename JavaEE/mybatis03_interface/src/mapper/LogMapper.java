package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Log;

import java.util.List;

public interface LogMapper {
    List<Log> selectAll();
    //List<Log> selectByAccInAccOut(String accIn, String accOut);

    //mapper.xml中可以使用in和out，作为入参的名字,此时是使用map作为媒介来存储数据
    //key ： value   in:accIn out:accOut
    List<Log> selectByAccInAccOut(@Param("in") String accIn, @Param("out") String accOut);
    List<Log> selectByAccInAndAccOut(@Param("accIn") String accIn, @Param("accOut") String accOut);
    int upd(Log log);
    List<Log> selIn(List<Integer> list);
    int ins(List<Integer> list);
}
