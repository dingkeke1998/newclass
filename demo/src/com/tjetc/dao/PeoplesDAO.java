package com.tjetc.dao;

import java.util.List;

import com.tjetc.domain.Peoples;

public interface PeoplesDAO {
     Peoples findById(int id);
     List<Peoples> findAll();
}
