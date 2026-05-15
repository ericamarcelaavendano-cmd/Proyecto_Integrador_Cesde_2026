package service.impl;

import co.edu.cesde.g.models.Program;
import repository.ProgramRepository;
import service.ProgramService;
import java.util.List;

public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    // Constructor que recibe el repositorio por inyección
    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    // Metodo Crear
    @Override
    public Program create(Program program) {
        if (isInvalidProgram(program) || programRepository.existsByName(program.getName()))
            return null;
        return programRepository.create(program);
    }

    // Metodo Eliminar
    @Override
    public boolean delete(Long programId) {
        if (programId == null)
            return false;
        return programRepository.delete(programId);
    }

    // Metodo Actualizar
    @Override
    public boolean update(Program programUpdate) {
        if (programUpdate == null || programUpdate.getProgramId() == null)
            return false;
        if (isInvalidProgram(programUpdate))
            return false;
        return programRepository.update(programUpdate);
    }

    // Metodo buscar por ID
    @Override
    public Program findById(Long programId) {
        if (programId == null)
            return null;
        return programRepository.findById(programId);
    }

    // Metodo buscar todos
    @Override
    public List<Program> findAll() {
        return programRepository.findAll();
    }

    // Metodo verificar si existe por nombre
    @Override
    public boolean existsByName(String name) {
        if (isBlank(name))
            return false;
        return programRepository.existsByName(name);
    }

    // Metodo buscar por nombre
    @Override
    public Program findByName(String name) {
        if (isBlank(name))
            return null;
        return programRepository.findByName(name);
    }

    // Metodo contar
    @Override
    public int count() {
        return programRepository.count();
    }

    // Verifica si un programa es inválido
    private boolean isInvalidProgram(Program program) {
        return program == null
                || isBlank(program.getCode())
                || isBlank(program.getName())
                || program.getCode().length() < 2
                || program.getName().length() < 3
                || !program.getCode().matches("[a-zA-Z0-9-]+");
    }

    // Verifica si un String es nulo o está en blanco
    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}