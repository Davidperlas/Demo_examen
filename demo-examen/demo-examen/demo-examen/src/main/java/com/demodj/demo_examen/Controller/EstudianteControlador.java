package com.demodj.demo_examen.Controller;

import com.demodj.demo_examen.Model.Estudiante;
import com.demodj.demo_examen.Model.Service.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio servicio;  // Cambiado a EstudianteServicio

    @GetMapping
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", servicio.listarEstudiantes());  // Cambiado a listarEstudiantes()
        return "estudiantes/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiantes/formulario";
    }

    @PostMapping
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        servicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        model.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
        return "estudiantes/formulario";
    }

    @PostMapping("/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante) {
        estudiante.setId(id);
        servicio.actualizarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        servicio.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
