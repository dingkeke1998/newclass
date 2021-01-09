package com.tjetc.dao;

import java.util.List;

import com.tjetc.domain.Presses;

public interface PressesDAO {
    List<Presses> findById(int id);
    List<Presses> findAll();
}
