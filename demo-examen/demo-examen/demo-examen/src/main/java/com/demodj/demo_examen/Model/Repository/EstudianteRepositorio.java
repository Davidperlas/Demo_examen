package com.demodj.demo_examen.Model.Repository;

import com.demodj.demo_examen.Model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
}
