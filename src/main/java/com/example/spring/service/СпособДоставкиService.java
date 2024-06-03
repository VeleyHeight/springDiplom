package com.example.spring.service;

import com.example.spring.model.Заказ;
import com.example.spring.model.СпособДоставки;

import java.util.List;

public interface СпособДоставкиService {
    List<СпособДоставки> findAll();
    СпособДоставки saveСпособДоставки(СпособДоставки способДоставки);
    СпособДоставки findById(int id);
}
//    ОбъемПродукции saveObem(ОбъемПродукции obem);
////    Obem_product findObemId(String id_obem);
//    void deleteObem(String id_obem);
//    ОбъемПродукции updateObem(ОбъемПродукции obem);

