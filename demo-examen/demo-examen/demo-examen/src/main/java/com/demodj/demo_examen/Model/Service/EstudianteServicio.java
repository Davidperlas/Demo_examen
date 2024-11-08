package com.demodj.demo_examen.Model.Service;

import com.demodj.demo_examen.Model.Estudiante;
import com.demodj.demo_examen.Model.Repository.EstudianteRepositorio;
import com.demodj.demo_examen.Model.Estudiante;
import com.demodj.demo_examen.Model.Repository.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServicio {

    @Autowired
    private EstudianteRepositorio repositorio;

    public List<Estudiante> listarEstudiantes() {
        return repositorio.findAll();
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    public Estudiante obtenerEstudiantePorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    public void eliminarEstudiante(Long id) {
        repositorio.deleteById(id);
    }
}
