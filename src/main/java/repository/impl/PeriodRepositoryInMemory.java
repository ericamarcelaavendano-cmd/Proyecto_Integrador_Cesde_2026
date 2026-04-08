package repository.impl;

import co.edu.cesde.g.models.Period;
import repository.PeriodRepository;
import java.util.ArrayList;
import java.util.List;

public class PeriodRepositoryInMemory implements PeriodRepository {

    private final List<Period> periods;
    private Long nextPeriodId;

    public PeriodRepositoryInMemory() {
        this.periods = new ArrayList<>();
        this.nextPeriodId = 1L;
    }

    @Override
    public Period create(Period period) {
        if (period == null)
            return null;
        if (existsByCode(period.getCode()))
            return null;
        period.setPeriodId(nextPeriodId++);
        periods.add(period);
        return period;
    }

    @Override
    public boolean delete(Long periodId) {
        Period period = findById(periodId);
        if (period == null)
            return false;
        return periods.remove(period);
    }


    @Override
    public boolean update(Period periodUpdate) {
        if (periodUpdate == null || periodUpdate.getPeriodId() == null)
            return false;
        for (int i = 0; i < periods.size(); i++) {
            if (periods.get(i).getPeriodId().equals(periodUpdate.getPeriodId())) {
                periods.set(i, periodUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public Period findById(Long periodId) {
        if (periodId == null)
            return null;
        for (Period period : periods) {
            if (period.getPeriodId().equals(periodId)) {
                return period;
            }
        }
        return null;
    }

    @Override
    public List<Period> findAll() {
        return new ArrayList<>(periods);
    }

    @Override
    public boolean existsByCode(String code) {
        return findByCode(code) != null;
    }

    @Override
    public Period findByCode(String code) {
        if (code == null || code.isBlank())
            return null;
        for (Period period : periods) {
            if (period.getCode().equalsIgnoreCase(code)) {
                return period;
            }
        }
        return null;
    }

    @Override
    public int count() {
        return periods.size();
    }
}