package com.evertonvsf.managementsystem.dao;

import java.util.List;

public interface CRUD<Generic> {
    public Generic create(Generic object);
    public List<Generic> findMany();
    public boolean update(Generic object);
    public boolean deleteMany();
}
