package service;

import pojo.Airplane;

import java.util.List;

public interface AirPlaneService {
    List<Airplane> show(int takeId,int landId);
}
