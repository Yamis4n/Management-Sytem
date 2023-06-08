package com.evertonvsf.managementsystem.dao.crud.users;

import com.evertonvsf.managementsystem.dao.crud.CRUD;

import java.util.List;

public interface UserCRUD<Generic> extends CRUD<Generic> {
    public List<Generic> findByName(String name);

}
