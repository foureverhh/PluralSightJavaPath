package service;

import pojo.Airport;

import java.util.List;

public interface AirPortService {
    //show all departure airport
    List<Airport> showTakePort();
    //show all arrival airport
    List<Airport> showLandPort();
}
