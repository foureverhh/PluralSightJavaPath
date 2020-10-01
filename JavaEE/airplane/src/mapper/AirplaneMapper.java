package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Airplane;

import java.util.List;

public interface AirplaneMapper {
    List<Airplane> selAirPlaneByPorts(@Param("takeid") int  takeId, @Param("landid") int landId);
}
