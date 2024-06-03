package com.example.spring.service;

import com.example.spring.model.Клиент;
import com.example.spring.model.КонтактноеЛицо;
import com.example.spring.model.Пользователь;

import java.util.List;

public interface КлиентService {
    List<Клиент> findAll();
    Клиент saveКлиент(Клиент клиент);
    Клиент findById(int id);
    Клиент findByПользователь(Пользователь user);
    Клиент updateКлиент(int CompanyId, String firm, String mainOrganization,String inn,String kpp,String address,String region,String companyFormUR,String companyFormIP,
                        String clientSurname, String clientName, String clientPatronymic, String phoneNumber, String email);
}
//    ОбъемПродукции saveObem(ОбъемПродукции obem);
////    Obem_product findObemId(String id_obem);
//    void deleteObem(String id_obem);
//    ОбъемПродукции updateObem(ОбъемПродукции obem);

