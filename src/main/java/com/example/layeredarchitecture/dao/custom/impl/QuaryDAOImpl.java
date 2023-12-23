package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuaryDAOImpl implements QueryDAO {
    @Override
    public void orderDetails(OrderDTO dto) {
        try {
            ResultSet rst = SQLUtil.execute("SELECT\n" +
                    "    Orders.oid,\n" +
                    "    Orders.date,\n" +
                    "    Item.description AS itemDescription,\n" +
                    "    OrderDetails.qty,\n" +
                    "    OrderDetails.unitPrice AS orderDetailUnitPrice,\n" +
                    "    Item.unitPrice AS itemUnitPrice\n" +
                    "FROM\n" +
                    "    Orders\n" +
                    "        JOIN\n" +
                    "    Customer ON Orders.customerID = Customer.id\n" +
                    "        JOIN\n" +
                    "    OrderDetails ON Orders.oid = OrderDetails.oid\n" +
                    "        JOIN\n" +
                    "    Item ON OrderDetails.itemCode = Item.code");


            while (rst.next()){
                System.out.println(rst.getString("oid"));
                System.out.println(rst.getString("date"));
                System.out.println(rst.getString("customerID"));
                System.out.println(rst.getString("customerName"));
                System.out.println(rst.getString("customerAddress"));
                System.out.println(rst.getString("itemCode"));
                System.out.println(rst.getString("itemDescription"));
                System.out.println(rst.getString("qty"));
                System.out.println(rst.getString("orderDetailUnitPrice"));
                System.out.println(rst.getString("itemUnitPrice"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
