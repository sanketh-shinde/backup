package com.example.demo.repository;

import com.example.demo.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

    @Query("SELECT s FROM Sale s WHERE s.store.id = :id")
    // SELECT s.* FROM SALE s INNER JOIN STORE st ON s.store_id == st.id WHERE st.id = id
    List<Sale> findSalesByStoreId(@Param("id") Integer id);

}
