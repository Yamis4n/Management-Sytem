package com.evertonvsf.managementsystem.dao.crud.users.client;

import com.evertonvsf.managementsystem.dao.crud.users.UserCRUD;
import com.evertonvsf.managementsystem.models.users.Client;

public interface ClientCRUD extends UserCRUD<Client> {
    public Client findByCpf(Integer cpf);
    public boolean deleteByCpf(Integer cpf);

}
