package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.TransactionUtil;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.custom.OrdersDAO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    OrdersDAO ordersDAO = (OrdersDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.ORDER);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.ORDER_DETAIL);
    ItemBO itemBO = (ItemBO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.ITEM);
    @Override
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        TransactionUtil.startTransaction();

        boolean isExists = isExists(orderId);
        /*if order id already exist*/
        if (isExists) {

        }

        boolean isSaved = placeOrder(new OrderDTO(orderId, orderDate, customerId));

        if (!isSaved) {
            TransactionUtil.rollBack();
            return false;
        }

        for (OrderDetailDTO detail : orderDetails) {

            if (!saveOrderDetail(orderId, detail)) {
                TransactionUtil.rollBack();
                return false;
            }

//                //Search & Update Item
            ItemDTO item = findItem(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            if (!itemBO.updateItem(item)) {
                TransactionUtil.rollBack();
                return false;
            }
        }

        TransactionUtil.endTransaction();
        return true;
    }

    public ItemDTO findItem(String code) {
        try {
            return itemBO.searchItem(code);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

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
    public boolean placeOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return ordersDAO.saveOrder(dto);
    }
}