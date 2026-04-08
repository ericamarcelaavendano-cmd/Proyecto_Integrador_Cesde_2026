package repository.impl;

import co.edu.cesde.g.models.Program;
import repository.ProgramRepository;
import java.util.ArrayList;
import java.util.List;

public class ProgramRepositoryInMemory implements ProgramRepository {

    private final List<Program> programs;
    private Long nextProgramId;

    public ProgramRepositoryInMemory() {
        this.programs = new ArrayList<>();
        this.nextProgramId = 1L;
    }

    // Agrega un nuevo programa a la lista y lo retorna
    @Override
    public Program create(Program program) {
        if (program == null) {
            return null;
        }
        if (existsByName(program.getName())) {
            return null;
        }
        program.setProgramId(nextProgramId++);
        programs.add(program);
        return program;
    }

    // Elimina un programa de la lista buscándolo por su ID
    @Override
    public boolean delete(Long programId) {
        Program program = findById(programId);
        if (program == null) {
            return false;
        }
        return programs.remove(program);
    }

    // Reemplaza un programa existente con los nuevos datos
    @Override
    public boolean update(Program programUpdate) {
        if (programUpdate == null || programUpdate.getProgramId() == null) {
            return false;
        }
        for (int i = 0; i < programs.size(); i++) {
            if (programs.get(i).getProgramId().equals(programUpdate.getProgramId())) {
                programs.set(i, programUpdate);
                return true;
            }
        }
        return false;
    }

    // Busca y retorna un programa por su ID
    @Override
    public Program findById(Long programId) {
        if (programId == null) {
            return null;
        }
        for (Program program : programs) {
            if (program.getProgramId().equals(programId)) {
                return program;
            }
        }
        return null;
    }

    // Retorna una copia de toda la lista de programas
    @Override
    public List<Program> findAll() {
        return new ArrayList<>(programs);
    }

    // Verifica si ya existe un programa con el nombre dado
    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }

    // Busca y retorna un programa por su nombre
    @Override
    public Program findByName(String name) {
        if (name == null || name.isBlank()) {
            return null;
        }
        for (Program program : programs) {
            if (name.equalsIgnoreCase(program.getName())) {
                return program;
            }
        }
        return null;
    }

    // Retorna el número total de programas
    @Override
    public int count() {
        return programs.size();
    }
}