package com.demonew.demonew.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demonew.demonew.Entity.Demo;
import com.demonew.demonew.Repository.DemoRepository;

@Service
public class ServiceImpl implements DemoService{

    @Autowired
    DemoRepository demoRepository;

    @Override
    public Demo save(Demo demo) {
        // TODO Auto-generated method stub
        return demoRepository.save(demo);
        
    }

    @Override
    public List<Demo> findAll() {
        // TODO Auto-generated method stub
        return demoRepository.findAll();
        
    }

    @Override
    public Demo findById(int id) {
        // TODO Auto-generated method stub
        return demoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
       demoRepository.deleteById(id);
     
    }

    @Override
public Demo updateOrCreate(int id, Demo demo) {
    Demo olDemo = demoRepository.findById(id).orElse(new Demo());

    olDemo.setId(id);  // important for upsert
    olDemo.setName(demo.getName());
    olDemo.setNumber(demo.getNumber());

    return demoRepository.save(olDemo);
}

    
}
