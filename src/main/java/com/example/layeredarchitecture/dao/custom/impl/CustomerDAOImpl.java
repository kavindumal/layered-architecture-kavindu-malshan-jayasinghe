package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.dao.SQLUtil;

import java.sql.*;
import java.util.ArrayList;

public class  CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM customer");

        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();

        while (rst.next()) {

            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString( 1 ),
                    rst.getString( 2 ),
                    rst.getString( 3 ) );

            allCustomers.add( customerDTO );
        }

        return allCustomers;
    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO customer VALUES (?,?,?)",
                dto.getId(),
                dto.getName(),
                dto.getAddress());
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE customer SET name=?, address=? WHERE id=?",
                dto.getName(),
                dto.getAddress(),
                dto.getId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM customer WHERE id=?", id);

        return rst.next();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM customer WHERE id=?", id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM customer ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {
            return rst.getString( 1 );
        }

        return null;
    }

    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer WHERE id=?", (id + ""));

        if (rst.next()) {
            return new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
        }

        return null;
    }
}
