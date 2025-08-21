package com.demonew.demonew.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demonew.demonew.Entity.Demo;

@Repository
public interface DemoRepository  extends JpaRepository<Demo, Integer>{
    
}
