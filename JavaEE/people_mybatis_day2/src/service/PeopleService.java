package service;

import pojo.People;

import java.io.IOException;
import java.util.List;

public interface PeopleService {
    List<People> showAll() throws IOException;
}
