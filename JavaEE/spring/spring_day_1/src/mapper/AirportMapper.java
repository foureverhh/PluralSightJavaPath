package mapper;

import org.apache.ibatis.annotations.Select;
import pojo.Airport;

import java.util.List;

public interface AirportMapper {
    @Select("select * from airport")
    List<Airport> selAll();
}
