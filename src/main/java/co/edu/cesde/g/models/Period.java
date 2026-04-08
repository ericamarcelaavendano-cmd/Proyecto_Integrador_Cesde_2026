package co.edu.cesde.g.models;

import java.util.Objects;

public class Period {
    private Long periodId;
    private String code;
    private String startDate;
    private String endDate;

    // Constructor vacío
    public Period() {
    }

    // Constructor con parámetros
    public Period(Long periodId, String code, String startDate, String endDate) {
        this.periodId = periodId;
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters y Setters
    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    // Método toString
    @Override
    public String toString() {
        return "Period{" +
                "periodId=" + periodId +
                ", code='" + code +
                ", startDate='" + startDate +
                ", endDate='" + endDate +
                '}';
    }

    // Compara dos objetos Period por su ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return Objects.equals(periodId, period.periodId);
    }

    // Genera el hashCode basado en el ID
    @Override
    public int hashCode() {
        return Objects.hash(periodId);
    }
}
