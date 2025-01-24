package org.example.billingservice.Web;

import org.example.billingservice.entitie.Bill;
import org.example.billingservice.entitie.Customer;
import org.example.billingservice.repositorie.BillRepository;
import org.example.billingservice.repositorie.ProductItemRepository;
import org.example.billingservice.service.CustomerRestClient;
import org.example.billingservice.service.ProductRestClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;

    private CustomerRestClient customerRestClient;

    private ProductRestClient productRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }
    @GetMapping(path = "/fullbill/{id}")
    public Bill bill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        System.out.println(bill.getCustomerID());
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerID()));
        bill.getProductItems().forEach(
                productItem -> {
                    productItem.setProduct(productRestClient.findProductById(productItem.getProductID()));
                }
        );

        return  bill;
    }
}
