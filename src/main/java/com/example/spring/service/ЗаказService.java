package com.example.spring.service;

import com.example.spring.controller.ShinaController;
import com.example.spring.model.Заказ;
import com.example.spring.model.Клиент;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.List;
import java.util.Map;

public interface ЗаказService {
    List<Заказ> findAll();
    Заказ saveЗаказ(Заказ заказ);

}
//    ОбъемПродукции saveObem(ОбъемПродукции obem);
////    Obem_product findObemId(String id_obem);
//    void deleteObem(String id_obem);
//    ОбъемПродукции updateObem(ОбъемПродукции obem);

