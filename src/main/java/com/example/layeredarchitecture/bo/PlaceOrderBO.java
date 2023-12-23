package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface PlaceOrderBO {
    public boolean saveOrderDetail(String orderId, OrderDetailDTO detailDTO) throws SQLException, ClassNotFoundException;
    public String generateNextOrderId() throws SQLException, ClassNotFoundException;
    public boolean isExists(String orderId) throws SQLException, ClassNotFoundException;
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
}
