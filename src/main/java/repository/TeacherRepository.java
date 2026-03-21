package repository;

import co.edu.cesde.g.models.Student;
import co.edu.cesde.g.models.Teacher;

import java.util.List;

public interface TeacherRepository {
    //Crear Teacher
    Teacher create(Teacher teacher);

    //Eliminar teacher
    boolean delete(long teacherId);

    //Actualizar teacher
    boolean update(Teacher teacherupdate);

    boolean finById(long teacherId);

    //Buscar todos los estudiantes
    List<Teacher> findAll();

    //Tambien lo puedo buscar con el DocumenNumber
    boolean existDocumentNumber(String documentNumber);

    Teacher finByDocumentNumber(String documentNumber);


}
