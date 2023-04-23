package com.poke.service.impl;

import com.poke.service.IOrdenService;
import com.poke.domain.Orden;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poke.dao.OrdenDao;

@Service
public class OrdenService implements IOrdenService {

    @Autowired
    private OrdenDao ordenRepository;

    @Override
    public List<Orden> getAllOrden() {
        return (List<Orden>) ordenRepository.findAll();
    }

    @Override
    public Orden getOrdenById(long id) {
        return ordenRepository.findById(id).orElse(null);
    }

    @Override
    public void saveOrden(Orden orden) {
        ordenRepository.save(orden);
    }

    @Override
    public void deleteOrden(long id) {
        ordenRepository.deleteById(id);
    }
}
