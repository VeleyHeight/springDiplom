package com.example.spring.service;

import com.example.spring.model.Пользователь;

import java.util.List;
import java.util.Optional;

public interface ПользовательService {
    List<Пользователь> findAll();
    Пользователь saveПользователь(Пользователь пользователь);
    boolean existsByЛогин(String логин);
    Optional<Пользователь> findByЛогин(String логин);
}
//    ОбъемПродукции saveObem(ОбъемПродукции obem);
////    Obem_product findObemId(String id_obem);
//    void deleteObem(String id_obem);
//    ОбъемПродукции updateObem(ОбъемПродукции obem);

