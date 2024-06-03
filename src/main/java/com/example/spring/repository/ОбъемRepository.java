package com.example.spring.repository;

import com.example.spring.model.ОбъемПродукции;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

@Table(name = "Объем_продукции")
public interface ОбъемRepository extends JpaRepository<ОбъемПродукции,String> {
}
//    void deleteById(String id_obem);
//    Obem_product findByIdObem(String id_obem);

