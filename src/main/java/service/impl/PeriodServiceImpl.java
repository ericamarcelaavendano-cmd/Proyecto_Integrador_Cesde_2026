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

    // Metodo Crear
    @Override
    public Period create(Period period) {
        if (isInvalidPeriod(period) || periodRepository.existsByCode(period.getCode()))
            return null;
        return periodRepository.create(period);
    }

    // Metodo Eliminar
    @Override
    public boolean delete(Long periodId) {
        if (periodId == null)
            return false;
        return periodRepository.delete(periodId);
    }

    // Metodo Actualizar
    @Override
    public boolean update(Period periodsUpdate) {
        if (periodsUpdate == null || periodsUpdate.getPeriodId() == null)
            return false;
        if (isInvalidPeriod(periodsUpdate))
            return false;
        return periodRepository.update(periodsUpdate);
    }

    // Metodo buscar por ID
    @Override
    public Period findById(Long periodId) {
        if (periodId == null)
            return null;
        return periodRepository.findById(periodId);
    }

    // Metodo buscar todos
    @Override
    public List<Period> findAll() {
        return periodRepository.findAll();
    }

    // Metodo verificar si existe por código
    @Override
    public boolean existsByCode(String code) {
        if (isBlank(code))
            return false;
        return periodRepository.existsByCode(code);
    }

    // Metodo buscar por código
    @Override
    public Period findByCode(String code) {
        if (isBlank(code))
            return null;
        return periodRepository.findByCode(code);
    }

    // Metodo contar
    @Override
    public int count() {
        return periodRepository.count();
    }

    // Verifica si un periodo es inválido
    private boolean isInvalidPeriod(Period period) {
        return period == null
                || isBlank(period.getCode())
                || period.getStartDate() == null
                || period.getEndDate() == null
                || period.getCode().length() < 2
                || period.getEndDate().isBefore(period.getStartDate())
                || period.getEndDate().isEqual(period.getStartDate());
    }

    // Verifica si un String es nulo o está en blanco
    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
