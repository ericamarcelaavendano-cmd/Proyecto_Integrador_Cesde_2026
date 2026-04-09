package repository;

import co.edu.cesde.g.models.GroupSubject;
import java.util.List;

public interface GroupSubjectRepository {

    // Crear un nuevo GroupSubject
    GroupSubject create(GroupSubject groupSubject);

    // Eliminar un GroupSubject por su ID
    boolean delete(Long groupSubjectId);

    // Actualizar un GroupSubject
    boolean update(GroupSubject groupSubjectUpdate);

    // Buscar un GroupSubject por su ID
    GroupSubject findById(Long groupSubjectId);

    // Buscar todos los GroupSubjects
    List<GroupSubject> findAll();

    // Buscar por groupId
    List<GroupSubject> findByGroupId(Long groupId);

    // Buscar por subjectId
    List<GroupSubject> findBySubjectId(Long subjectId);

    // Buscar por teacherId
    List<GroupSubject> findByTeacherId(Long teacherId);

    // Verificar si existe la combinación group-subject
    boolean existsByGroupIdAndSubjectId(Long groupId, Long subjectId);

    // Contar el total de GroupSubjects
    int count();
}