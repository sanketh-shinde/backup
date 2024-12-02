package com.example.demo.controller;

import com.example.demo.dto.SaleDTO;
import com.example.demo.entity.Sale;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
@CrossOrigin("*")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/buy")
    public Sale buyProduct(@RequestBody Sale sale) {
        return saleService.buy(sale);
    }

    @GetMapping("/get/{id}")
    public List<SaleDTO> fetch(@PathVariable Integer id) {
        return saleService.fetchSalesByStoreId(id);
    }

}
