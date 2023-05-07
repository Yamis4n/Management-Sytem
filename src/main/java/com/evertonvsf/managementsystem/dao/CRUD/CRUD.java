package com.evertonvsf.managementsystem.dao.CRUD;

import java.util.List;

public interface CRUD<Generic> {
    public Generic findById(int id);
    public Generic create(Generic object);
    public List<Generic> findMany();
    public boolean update(Generic object);
    public boolean deleteMany();
    public boolean deleteById(int id);
}
