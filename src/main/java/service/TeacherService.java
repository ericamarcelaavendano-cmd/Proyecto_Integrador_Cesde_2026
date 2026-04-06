package service;

import co.edu.cesde.g.models.Teacher;

import java.util.List;

public interface TeacherService {

    //Crear Teacher
    Teacher create(Teacher teacher);

    //Eliminar teacher
    boolean delete(Long teacherId);

    //Actualizar teacher
    boolean update(Teacher teacherupdate);

    Teacher findById(Long teacherId);

    //Buscar todos los estudiantes
    List<Teacher> findAll();

    //Tambien lo puedo buscar con el DocumenNumber
    boolean existsByDocumentNumber(String documentNumber);


    Teacher findByDocumentNumber(String documentNumber);

    int count();
}
