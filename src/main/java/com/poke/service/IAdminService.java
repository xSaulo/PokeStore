package com.poke.service;

import com.poke.domain.Admin;
import java.util.List;

public interface IAdminService {

    public List<Admin> getAdmins();

    public Admin getAdmin(Admin admin);

    public void save(Admin admin);

    public void delete(Admin admin);

}
