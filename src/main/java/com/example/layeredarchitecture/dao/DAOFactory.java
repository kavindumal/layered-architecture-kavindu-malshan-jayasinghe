package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.bo.CustomerBOImpl;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.dao.custom.impl.*;

public class DAOFactory {
    private DAOFactory(){}

    private static DAOFactory daoFactory;

    public static DAOFactory getDAOFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOType{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL,QUERY
    }

    public  SuperDAO getDAO(DAOType daoType){
        switch (daoType){
            case CUSTOMER -> {
                return new CustomerDAOImpl();
            }
            case ITEM -> {
                return new ItemDAOImpl();
            }
            case ORDER -> {
                return new OrdersDAOImpl();
            }
            case ORDER_DETAIL -> {
                return new OrderDetailDAOImpl();
            }
            case QUERY -> {
                return new QuaryDAOImpl();
            }
            default -> {
                return null;
            }
        }
    }
}
