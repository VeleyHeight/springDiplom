package com.example.spring.service;

import com.example.spring.model.ИнформацияОТоваре;

import java.util.List;

public interface ИнформацияОТовареService {
    List<ИнформацияОТоваре> findAll();
    List<Object[]> findAllWithName();
    ИнформацияОТоваре findById(int id);
}
