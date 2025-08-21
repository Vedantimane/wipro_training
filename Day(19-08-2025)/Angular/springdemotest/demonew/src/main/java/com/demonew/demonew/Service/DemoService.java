package com.demonew.demonew.Service;

import java.util.List;

import com.demonew.demonew.Entity.Demo;

public interface DemoService {

    Demo save(Demo demo);

    List<Demo> findAll();

    Demo findById(int id);

    void deleteById(int id);

    Demo updateOrCreate(int id, Demo demo);
    
}
