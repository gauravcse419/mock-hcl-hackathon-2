
package com.hcl.hackathon.repository;

import com.hcl.hackathon.entity.OrderInfo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<OrderInfo, Integer> {


    List<OrderInfo> findByOrderStatus(String orderStatus);
    List<OrderInfo> findByOrderStatusAndOrderNo(String orderStatus, String orderNo);

}
