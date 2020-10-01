package service.impl;

import mapper.AirplaneMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Airplane;
import service.AirPlaneService;
import utils.MybatisUtil;

import java.util.List;

public class AirplaneServiceImpl implements AirPlaneService {

    @Override
    public List<Airplane> show(int takeId, int landId) {
        SqlSession session = MybatisUtil.getSession();
        AirplaneMapper airplaneMapper = session.getMapper(AirplaneMapper.class);
        return airplaneMapper.selAirPlaneByPorts(takeId,landId);
    }
}
