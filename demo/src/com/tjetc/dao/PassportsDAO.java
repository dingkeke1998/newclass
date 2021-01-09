package com.tjetc.dao;

import java.util.List;

import com.tjetc.domain.Passports;


public interface PassportsDAO {
   Passports findById(int id);
   List<Passports> findAll();

}
