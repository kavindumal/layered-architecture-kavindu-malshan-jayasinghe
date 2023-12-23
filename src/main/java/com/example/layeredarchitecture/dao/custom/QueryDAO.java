package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.OrderDTO;

public interface QueryDAO {
    void orderDetails(OrderDTO dto);
}