package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException;
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    public boolean existItem(String id) throws SQLException, ClassNotFoundException;
    public String generateIDItem() throws SQLException, ClassNotFoundException;
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException;
}
