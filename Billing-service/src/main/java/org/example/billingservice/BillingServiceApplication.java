package org.example.billingservice;

import org.example.billingservice.entitie.Bill;
import org.example.billingservice.entitie.Customer;
import org.example.billingservice.entitie.Product;
import org.example.billingservice.entitie.ProductItem;
import org.example.billingservice.repositorie.BillRepository;
import org.example.billingservice.repositorie.ProductItemRepository;
import org.example.billingservice.service.ProductRestClient;
import org.example.billingservice.service.CustomerRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository , ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient , ProductRestClient productRestClient){
        return args -> {
          Collection<Product> products = productRestClient.allProducts().getContent();
          String  customerid = "c30835d9-8c05-45bc-9201-d6cb080cc09b";
          Customer customer = customerRestClient.findCustomerById(customerid);

          if (customer == null){
              throw  new RuntimeException("Customer not found");
          }
          Bill bill = new Bill();
          bill.setBillingDate(new Date("10/11/2024"));
          bill.setCustomerID(customerid);
          Bill saveBill = billRepository.save(bill);
          products.forEach(product -> {
              ProductItem productItem = new ProductItem();
              productItem.setBill(saveBill);
              productItem.setQuantity(1+new Random().nextInt(10));
              productItem.setProductID(product.getId());
              productItem.setPrice(product.getPrice());
              productItemRepository.save(productItem);
          });

        };
    }

}
