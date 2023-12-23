package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface PlaceOrderBO extends SuperBO{
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
    public boolean saveOrderDetail(String orderId, OrderDetailDTO detailDTO) throws SQLException, ClassNotFoundException;
    public String generateNextOrderId() throws SQLException, ClassNotFoundException;
    public boolean isExists(String orderId) throws SQLException, ClassNotFoundException;
    public boolean placeOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
}
