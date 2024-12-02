package com.example.demo.service;

import com.example.demo.dto.SaleDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.Sale;
import com.example.demo.entity.Store;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SaleRepository;
import com.example.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
 public class SaleServiceImpl implements SaleService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Sale buy(Sale sale) {
        Product product = productRepository.findById(sale.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product Not Found"));

        Store store = storeRepository.findById(sale.getStore().getId())
                .orElseThrow(() -> new RuntimeException("Store Not Found"));

        sale.setProduct(product);
        sale.setStore(store);

        return saleRepository.save(sale);
    }

    @Override
    public List<SaleDTO> fetchSalesByStoreId(Integer id) {
        List<Sale> sales = saleRepository.findSalesByStoreId(id);
        List<Product> productList = productRepository.findAll();

        List<SaleDTO> list = new ArrayList<>();

        for (Sale sale : sales) {
            SaleDTO saleDTO = new SaleDTO();
            String productName = sale.getProduct().getName();
            int totalSaleQuantity = sale.getSaleQuantity();
            int mrp = sale.getProduct().getMrp();

            // Check if the product has already been added to the list
            boolean found = false;
            for (SaleDTO existingSale : list) {
                if (existingSale.getProductName().equals(productName)) {
                    // If found, add to the existing quantity and update amount
                    totalSaleQuantity += existingSale.getSaleQuantity();
                    existingSale.setSaleQuantity(totalSaleQuantity);
                    existingSale.setAmount(totalSaleQuantity * mrp);
                    found = true;
                    break; // Exit the loop since we found the product
                }
            }

            // If the product was not found, create a new SaleDTO and add it to the list
            if (!found) {
                saleDTO.setProductName(productName);
                saleDTO.setSaleQuantity(totalSaleQuantity);
                saleDTO.setMrp(mrp);
                saleDTO.setAmount(totalSaleQuantity * mrp);
                list.add(saleDTO);
            }
        }
//
//        for (Product product : productList) {
//            SaleDTO saleDTO = new SaleDTO();
//            String productName = product.getName();
//            int mrp = product.getMrp();
//            boolean found = false;
//            for (SaleDTO existingSale : list) {
//                if (existingSale.getProductName().equals(productName)) {
//                    // If found, add to the existing quantity and update amount
//                    found = true;
//                    break; // Exit the loop since we found the product
//                }
//            }
//
//            // If the product was not found, create a new SaleDTO and add it to the list
//            if (!found) {
//                saleDTO.setProductName(productName);
//                saleDTO.setSaleQuantity(0);
//                saleDTO.setMrp(mrp);
//                saleDTO.setAmount(0);
//                list.add(saleDTO);
//            }
//        }

        return list;
    }

}
