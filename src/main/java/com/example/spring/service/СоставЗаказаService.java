package com.example.spring.service;

import com.example.spring.model.Заказ;
import com.example.spring.model.СоставЗаказа;

import java.util.List;

public interface СоставЗаказаService {
    List<СоставЗаказа> findAll();
    СоставЗаказа saveСоставЗаказа(СоставЗаказа составЗаказа);
    List<СоставЗаказа> saveAll(List<СоставЗаказа> составЗаказа);
}
//    ОбъемПродукции saveObem(ОбъемПродукции obem);
////    Obem_product findObemId(String id_obem);
//    void deleteObem(String id_obem);
//    ОбъемПродукции updateObem(ОбъемПродукции obem);

