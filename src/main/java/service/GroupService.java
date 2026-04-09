package service;

import co.edu.cesde.g.models.Group;

import java.util.List;

public interface GroupService {

    // Crear una nueva materia
    Group create(Group group);

    // Eliminar una materia por su ID
    boolean delete(Long groupId);

    // Actualizar una materia
    boolean update(Group groupUpdate);

    // Buscar un grupo por su código
    Group findByCode(String code);

    // Buscar una materia por su ID
    Group findById(Long groupId);

    // Buscar todos los grupos de un periodo
    List<Group> findByPeriodId(Long periodId);

    // Buscar todas las materias
    List<Group> findAll();

    // Verificar si existe una materia con ese código
    boolean existsByCode(String code);


    // Buscar todas las materias de un programa
    List<Group> findByProgramId(Long programId);

    // Contar el total de grupos
    int count();
}
