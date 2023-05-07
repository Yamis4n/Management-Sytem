package com.evertonvsf.managementsystem.dao.CRUD.users;

import com.evertonvsf.managementsystem.dao.CRUD;

import java.util.List;

public interface UserCRUD<Generic> extends CRUD<Generic> {
    public List<Generic> findByName(String name);
    public boolean deleteByName(String name);
}
