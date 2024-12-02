package com.example.demo.service;

import com.example.demo.dto.SaleDTO;
import com.example.demo.entity.Sale;

import java.util.List;

public interface SaleService {

    Sale buy(Sale sale);

    List<SaleDTO> fetchSalesByStoreId(Integer id);

}
