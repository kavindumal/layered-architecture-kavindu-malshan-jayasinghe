package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.ITEM);
    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }

    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(dto);
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(dto);
    }

    @Override
    public boolean existItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(id);
    }

    @Override
    public String generateIDItem() throws SQLException, ClassNotFoundException {
        return itemDAO.generateID();
    }

    @Override
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException {
        return itemDAO.search(newItemCode);
    }
}