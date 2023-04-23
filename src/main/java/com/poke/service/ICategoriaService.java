package com.poke.service;

import com.poke.domain.Categoria;
import java.util.List;

public interface ICategoriaService {
    public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);
    
    
}
