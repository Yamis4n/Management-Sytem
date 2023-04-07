package com.evertonvsf.managementsystem.dao.users;

import com.evertonvsf.managementsystem.dao.CRUD;
import com.evertonvsf.managementsystem.models.users.Client;

import java.util.List;

public interface UserCRUD<Generic> extends CRUD<Generic> {
    public List<Generic> findByName(String name);

    public boolean deleteById(int id);
    public boolean deleteByName(String name);
}
