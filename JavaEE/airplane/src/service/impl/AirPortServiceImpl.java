package service.impl;

import mapper.AirportMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Airport;
import service.AirPortService;
import utils.MybatisUtil;

import java.util.List;

public class AirPortServiceImpl implements AirPortService {

    @Override
    public List<Airport> showTakePort() {
        SqlSession session = MybatisUtil.getSession();
        AirportMapper airportMapper = session.getMapper(AirportMapper.class);
        return airportMapper.selTakePort();
    }

    @Override
    public List<Airport> showLandPort() {
        SqlSession session = MybatisUtil.getSession();
        AirportMapper airportMapper = session.getMapper(AirportMapper.class);
        return airportMapper.selLandPort();
    }
}
