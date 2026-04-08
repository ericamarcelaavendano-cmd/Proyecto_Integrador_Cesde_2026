package service.impl;

import co.edu.cesde.g.models.Program; // Importa el modelo Program
import repository.ProgramRepository;  // Importa el repositorio para acceder a los datos
import service.ProgramService;        // Importa la interfaz que vamos a implementar
import java.util.List;                // Importa List para el retorno de findAll

// Clase que implementa la lógica de negocio de Program
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository; // Repositorio para acceder a los datos

    // Constructor que recibe el repositorio por inyección
    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository; // Asigna el repositorio recibido
    }

    //Metodos Crear (create)
    @Override
    public Program create(Program program) {
        if (isInvalidProgram(program) || programRepository.existsByName(program.getName()))
            return null; // Retorna null si el programa es inválido o ya existe
        return programRepository.create(program); // Delega la creación al repositorio
    }

    // Elimina un programa por ID validando que no sea nulo
    @Override
    public boolean delete(Long programId) {
        if (programId == null)
            return false; // Retorna false si el ID es nulo
        return programRepository.delete(programId); // Delega la eliminación al repositorio
    }

    // Actualiza un programa validando que no sea inválido y que tenga ID
    @Override
    public boolean update(Program programUpdate) {
        if (isInvalidProgram(programUpdate) || programUpdate.getProgramId() == null)
            return false; // Retorna false si el programa es inválido o no tiene ID
        return programRepository.update(programUpdate); // Delega la actualización al repositorio
    }

    // Busca y retorna un programa por su ID
    @Override
    public Program findById(Long programId) {
        if (programId == null)
            return null; // Retorna null si el ID es nulo
        return programRepository.findById(programId); // Delega la búsqueda al repositorio
    }

    // Retorna todos los programas de la lista
    @Override
    public List<Program> findAll() {
        return programRepository.findAll(); // Delega al repositorio
    }

    // Verifica si existe un programa con el nombre dado
    @Override
    public boolean existsByName(String name) {
        if (isBlank(name))
            return false; // Retorna false si el nombre es vacío o nulo
        return programRepository.existsByName(name); // Delega al repositorio
    }

    // Busca y retorna un programa por su nombre
    @Override
    public Program findByName(String name) {
        if (isBlank(name))
            return null; // Retorna null si el nombre es vacío o nulo
        return programRepository.findByName(name); // Delega al repositorio
    }

    // Retorna el total de programas registrados
    @Override
    public int count() {
        return programRepository.count(); // Delega al repositorio
    }

    // Verifica si un programa es inválido (nulo o con campos vacíos)
    private boolean isInvalidProgram(Program program) {
        return program == null
                || isBlank(program.getCode())  // Verifica que el código no sea vacío
                || isBlank(program.getName()); // Verifica que el nombre no sea vacío
    }

    // Verifica si un String es nulo o está en blanco
    private boolean isBlank(String value) {
        return value == null || value.isBlank(); // Retorna true si es nulo o vacío
    }
}