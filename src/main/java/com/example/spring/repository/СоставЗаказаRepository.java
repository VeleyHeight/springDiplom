package com.example.spring.repository;

import com.example.spring.model.Заказ;
import com.example.spring.model.СоставЗаказа;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

@Table(name = "Состав_заказа")
public interface СоставЗаказаRepository extends JpaRepository<СоставЗаказа,Integer> {
}
//    void deleteById(String id_obem);
//    Obem_product findByIdObem(String id_obem);

