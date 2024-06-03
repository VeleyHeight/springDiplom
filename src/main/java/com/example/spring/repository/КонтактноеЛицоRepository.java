package com.example.spring.repository;

import com.example.spring.model.КонтактноеЛицо;
import com.example.spring.model.ОбъемПродукции;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

@Table(name = "Контактное_лицо")
public interface КонтактноеЛицоRepository extends JpaRepository<КонтактноеЛицо,Integer> {
}
//    void deleteById(String id_obem);
//    Obem_product findByIdObem(String id_obem);

