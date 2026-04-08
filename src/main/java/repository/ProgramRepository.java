package repository;

import co.edu.cesde.g.models.Program;


import java.util.List;

public interface ProgramRepository {
    Program create(Program program);

    boolean delete(Long programId);
    //Actualizar Role
    boolean update(Program programUpdate);

    Program findById(Long programId);

    //Buscar todos los roles .
    List<Program> findAll();

    //Tambien lo puedo buscar con el DocumenNumber
    boolean existsByName(String name);

    Program findByName(String name);

    int count();


}
