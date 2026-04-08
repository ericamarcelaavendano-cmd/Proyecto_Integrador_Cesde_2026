package service;

import co.edu.cesde.g.models.Program;
import java.util.List;

public interface ProgramService {

    Program create(Program program);

    boolean delete(Long programId);

    //Actualizar Program
    boolean update(Program programUpdate);

    Program findById(Long programId);

    //Buscar todos los programas
    List<Program> findAll();

    //Buscar por nombre
    boolean existsByName(String name);

    Program findByName(String name);

    int count();
}
