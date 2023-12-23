package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.custom.OrdersDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrdersDAOImpl;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    OrdersDAO ordersDAO = new OrdersDAOImpl();
    OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
    @Override
    public boolean saveOrderDetail(String orderId, OrderDetailDTO detailDTO) throws SQLException, ClassNotFoundException {
        return orderDetailDAO.saveOrderDetail(orderId,detailDTO);
    }

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        return ordersDAO.generateNextOrderId();
    }

    @Override
    public boolean isExists(String orderId) throws SQLException, ClassNotFoundException {
        return ordersDAO.isExists(orderId);
    }

    @Override
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return ordersDAO.saveOrder(dto);
    }
}