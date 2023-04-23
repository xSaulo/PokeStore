package com.poke.service.impl;

import com.poke.service.IDetalleOrdenService;
import com.poke.domain.DetalleOrden;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poke.dao.DetalleOrdenDao;

@Service
public class DetalleOrdenService implements IDetalleOrdenService {

    @Autowired
    private DetalleOrdenDao detalleOrdenRepository;

    @Override
    public List<DetalleOrden> getAllDetalleOrden() {
        return (List<DetalleOrden>) detalleOrdenRepository.findAll();
    }

    @Override
    public DetalleOrden getDetalleOrdenById(long id) {
        return detalleOrdenRepository.findById(id).orElse(null);
    }

    @Override
    public void saveDetalleOrden(DetalleOrden detalleOrden) {
        detalleOrdenRepository.save(detalleOrden);
    }

    @Override
    public void deleteDetalleOrden(long id) {
        detalleOrdenRepository.deleteById(id);
    }

}
