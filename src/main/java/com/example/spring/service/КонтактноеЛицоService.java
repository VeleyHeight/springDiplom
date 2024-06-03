package com.example.spring.service;

import com.example.spring.model.КонтактноеЛицо;
import com.example.spring.model.ОбъемПродукции;

import java.util.List;

public interface КонтактноеЛицоService {
    List<КонтактноеЛицо> findAll();
    КонтактноеЛицо saveКонтактноеЛицо(КонтактноеЛицо контактноеЛицо);
}
//    ОбъемПродукции saveObem(ОбъемПродукции obem);
////    Obem_product findObemId(String id_obem);
//    void deleteObem(String id_obem);
//    ОбъемПродукции updateObem(ОбъемПродукции obem);

