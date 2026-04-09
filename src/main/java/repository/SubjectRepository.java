package repository;

import co.edu.cesde.g.models.Subject;
import java.util.List;

public interface SubjectRepository {

    // Crear una nueva materia
    Subject create(Subject subject);

    // Eliminar una materia por su ID
    boolean delete(Long subjectId);

    // Actualizar una materia
    boolean update(Subject subjectUpdate);

    // Buscar una materia por su ID
    Subject findById(Long subjectId);

    // Buscar todas las materias
    List<Subject> findAll();

    // Verificar si existe una materia con ese código
    boolean existsByCode(String code);

    // Buscar una materia por su código
    Subject findByCode(String code);

    // Buscar todas las materias de un programa
    List<Subject> findByProgramId(Long programId);

    // Contar el total de materias
    int count();
}