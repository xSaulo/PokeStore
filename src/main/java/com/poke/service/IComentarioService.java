package com.poke.service;

import com.poke.domain.Comentario;
import java.util.List;

public interface IComentarioService {

    public List<Comentario> getAllComentarios();

    public Comentario getComentarioByID(long id);

    public void saveComentario(Comentario comentario);

    public void delete(long id);
}
