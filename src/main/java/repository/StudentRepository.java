package repository;

import co.edu.cesde.g.models.Student;

import java.util.List;

public interface StudentRepository {
    //Crear estudiante
    Student create(Student student);

    //Eliminar estudiante
    boolean delete(long studentId);

    //Actualizar estudiante
    boolean update(Student studentupdate);

    boolean finById(long studentId);

    //Tambien lo puedo buscar con el DocumenNumber
    boolean finByDocumentNumber(String documentNumber);

    //Buscar todos los estudiantes
    List<Student> findAll();

    boolean existById(long studentId);

}
