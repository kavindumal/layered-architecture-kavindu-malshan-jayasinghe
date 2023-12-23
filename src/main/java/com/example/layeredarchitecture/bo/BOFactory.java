package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.SuperDAO;
import com.example.layeredarchitecture.dao.custom.impl.*;

import static com.example.layeredarchitecture.bo.BOFactory.BOType.CUSTOMER;

public class BOFactory {
    private BOFactory(){}

    private static BOFactory boFactory;

    public static BOFactory getBOFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOType{
        CUSTOMER,ITEM,PLACE_ORDER
    }

    public SuperBO getBO(BOType boType){
        switch (boType){
            case CUSTOMER -> {
                return new CustomerBOImpl();
            }
            case ITEM -> {
                return new ItemBOImpl();
            }
            case PLACE_ORDER -> {
                return new PlaceOrderBOImpl();
            }
            default -> {
                return null;
            }
        }
    }
}
