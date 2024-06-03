package com.example.spring.repository;

import com.example.spring.model.ИнформацияОТоваре;
import com.example.spring.model.Поставщики;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Table(name = "Информация_о_товаре")
public interface ИнформацияОтовареRepository extends JpaRepository<ИнформацияОТоваре,Integer> {
    @Query("SELECT i.id, i.полноеНаименование, i.группаТовара, p.наименование, i.типоразмер, i.модель, i.ценаШиныСНдс " +
            "FROM ИнформацияОТоваре i " +
            "JOIN i.кодПоставщика p")
    List<Object[]> findAllWithName();
}
