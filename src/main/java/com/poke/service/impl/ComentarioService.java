package com.poke.service.impl;

import com.poke.service.IComentarioService;
import com.poke.domain.Comentario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poke.dao.ComentarioDao;

@Service
public class ComentarioService implements IComentarioService {

    @Autowired
    private ComentarioDao comentarioRepository;

    @Override
    public List<Comentario> getAllComentarios() {
        return (List<Comentario>) comentarioRepository.findAll();
    }

    @Override
    public Comentario getComentarioByID(long id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    @Override
    public void saveComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    @Override
    public void delete(long id) {
        comentarioRepository.deleteById(id);
    }
}
