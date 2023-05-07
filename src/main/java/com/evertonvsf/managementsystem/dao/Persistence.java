package com.evertonvsf.managementsystem.dao;

import java.util.List;

public interface Persistence<Generic> {
    public List<Generic> loadFiles();
    public boolean writeFiles(List<Generic> files);
}
