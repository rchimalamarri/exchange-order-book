package com.challenge.exchangeorderbook.repository;

import com.challenge.exchangeorderbook.entity.BidDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 15-JUN-2021
 ************************************/
public interface BidDetailsRepository extends JpaRepository<BidDetails, String> {

    BidDetails findByorderId  (String orderId);
}
