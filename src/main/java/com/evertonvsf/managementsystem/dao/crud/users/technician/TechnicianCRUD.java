package com.evertonvsf.managementsystem.dao.crud.users.technician;

import com.evertonvsf.managementsystem.dao.crud.users.UserCRUD;
import com.evertonvsf.managementsystem.models.users.Technician;

public interface TechnicianCRUD extends UserCRUD<Technician> {
    public Technician findByUsername(String username);
}
