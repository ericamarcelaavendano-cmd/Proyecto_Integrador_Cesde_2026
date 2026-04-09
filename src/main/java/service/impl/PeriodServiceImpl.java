package service.impl;

import co.edu.cesde.g.models.Period;
import repository.PeriodRepository;
import service.PeriodService;
import java.util.List;

public class PeriodServiceImpl implements PeriodService {

    private final PeriodRepository periodRepository;

    // Constructor que recibe el repositorio por inyección
    public PeriodServiceImpl(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    // Crea un nuevo periodo validando que no sea inválido y que no exista con el mismo código
    @Override
    public Period create(Period period) {
        if (isInvalidPeriod(period) || periodRepository.existsByCode(period.getCode()))
            return null;
        return periodRepository.create(period);
    }

    // Elimina un periodo por ID validando que no sea nulo
    @Override
    public boolean delete(Long periodId) {
        if (periodId == null)
            return false;
        return periodRepository.delete(periodId);
    }

    // Actualiza un periodo validando que no sea inválido y que tenga ID
    @Override
    public boolean update(Period periodsUpdate) {
        if (isInvalidPeriod(periodsUpdate) || periodsUpdate.getPeriodId() == null)
            return false;
        return periodRepository.update(periodsUpdate);
    }
//
    // Busca y retorna un periodo por su ID
    @Override
    public Period findById(Long periodId) {
        if (periodId == null)
            return null;
        return periodRepository.findById(periodId);
    }

    // Retorna todos los periodos de la lista
    @Override
    public List<Period> findAll() {
        return periodRepository.findAll();
    }

    // Verifica si existe un periodo con ese código
    @Override
    public boolean existsByCode(String code) {
        if (isBlank(code))
            return false;
        return periodRepository.existsByCode(code);
    }

    // Busca y retorna un periodo por su código
    @Override
    public Period findByCode(String code) {
        if (isBlank(code))
            return null;
        return periodRepository.findByCode(code);
    }

    // Retorna el total de periodos registrados
    @Override
    public int count() {
        return periodRepository.count();
    }

    // Verifica si un periodo es inválido
    private boolean isInvalidPeriod(Period period) {
        return period == null
                || isBlank(period.getCode())
                || period.getStartDate() == null
                || period.getEndDate() == null;
    }

    // Verifica si un String es nulo o está en blanco
    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
