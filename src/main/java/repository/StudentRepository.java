package repository;

import co.edu.cesde.g.models.Student;

import java.util.List;

public interface StudentRepository {
    //Crear estudiante
    Student create(Student student);

    //Eliminar estudiante
    boolean delete(Long studentId);

    //Actualizar estudiante, aqui se actualiza los estudiante
    boolean update(Student studentupdate);

    Student findById(Long studentId);

    //Tambien lo puedo buscar con el DocumenNumber
    Student findByDocumentNumber(String documentNumber);

    //Buscar todos los estudiantes
    List<Student> findAll();


    boolean existsByDocumentNumber(String documentNumber);

    int count();

}
