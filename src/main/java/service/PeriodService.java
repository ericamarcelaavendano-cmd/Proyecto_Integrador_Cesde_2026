package service;

import co.edu.cesde.g.models.Period;

import java.util.List;

public interface PeriodService {
    // Crear un nuevo periodo
    Period create(Period period);

    // Eliminar un periodo por su ID
    boolean delete(Long periodId);

    // Actualizar un periodo
    boolean update(Period periodsUpdate);

    // Buscar un periodo por su ID
    Period findById(Long periodId);

    // Buscar todos los periodos
    List<Period> findAll();

    // Verificar si existe un periodo con ese código
    boolean existsByCode(String code);

    // Buscar un periodo por su código
    Period findByCode(String code);

    // Contar el total de periodos
    int count();
}
