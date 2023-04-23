package com.poke.service;

import com.poke.domain.DetalleOrden;
import java.util.List;

public interface IDetalleOrdenService {

    public List<DetalleOrden> getAllDetalleOrden();

    public DetalleOrden getDetalleOrdenById(long id);

    public void saveDetalleOrden(DetalleOrden detalleOrden);

    public void deleteDetalleOrden(long id);
}
