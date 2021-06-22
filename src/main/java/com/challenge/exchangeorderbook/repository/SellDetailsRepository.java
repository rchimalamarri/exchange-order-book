package com.challenge.exchangeorderbook.repository;
import com.challenge.exchangeorderbook.entity.SellDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 15-JUN-2021
 ************************************/
public interface SellDetailsRepository extends JpaRepository<SellDetails, String> {

    SellDetails findByorderId  (String orderId);

}
