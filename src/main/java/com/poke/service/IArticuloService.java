package com.poke.service;

import com.poke.domain.Articulo;
import java.util.List;

public interface IArticuloService {
    public List<Articulo> getArticulos(boolean activos);
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
    
    
}
