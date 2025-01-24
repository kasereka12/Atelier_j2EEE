package org.example.billingservice.repositorie;

import feign.Param;
import org.example.billingservice.entitie.Bill;
import org.example.billingservice.entitie.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long> {

  @RestResource(path = "/byCustomerId")
  List<Bill> findBillBycustomerID(@Param("customerId") String customerID);

}
