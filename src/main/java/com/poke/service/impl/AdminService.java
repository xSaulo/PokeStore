package com.poke.service.impl;

import com.poke.service.IAdminService;
import com.poke.domain.Admin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poke.dao.AdminDao;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminDao adminRepository;

    @Override
    public List<Admin> getAdmins() {
        return (List<Admin>) adminRepository.findAll();
    }

    @Override
    public Admin getAdmin(Admin admin) {
        return adminRepository.findById(admin.getIdAdmin()).orElse(null);
    }

    @Override
    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void delete(Admin admin) {
        adminRepository.delete(admin);
    }

}
