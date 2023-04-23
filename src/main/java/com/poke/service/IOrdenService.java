package com.poke.service;

import com.poke.domain.Orden;
import java.util.List;

public interface IOrdenService {

    public List<Orden> getAllOrden();

    public Orden getOrdenById(long id);

    public void saveOrden(Orden orden);

    public void deleteOrden(long id);
}
