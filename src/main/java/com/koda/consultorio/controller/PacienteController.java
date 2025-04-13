package com.koda.consultorio.controller;

import com.koda.consultorio.model.Paciente;
import com.koda.consultorio.repository.PacienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

  private final PacienteRepository repository;

  public PacienteController(PacienteRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public Paciente criarPaciente(@RequestBody Paciente paciente) {
    return repository.save(paciente);
  }

  @GetMapping
  public List<Paciente> listar(){
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Paciente buscar(@PathVariable Long id){
    return repository.findById(id).orElse(null);
  }

  @PutMapping("/{id}")
  public Paciente atualizar(@PathVariable Long id, @RequestBody Paciente paciente) {
    paciente.setId(id);
    return repository.save(paciente);
  }

  @DeleteMapping("/{id}")
  public void deletar(@PathVariable Long id){
    repository.deleteById(id);
  }

}
