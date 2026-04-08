package co.edu.cesde.g.models;

import java.util.Objects;

public class Program {
    private Long programId;
    private String code;
    private String name;

    // Constructor vacío
    public Program() {
    }

    // Constructor con parámetros
    public Program(Long programId, String code, String name) {
        this.programId = programId;
        this.code = code;
        this.name = name;
    }

    // Getters y Setters
    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // //Metodo ToString
    @Override
    public String toString() {
        return "Program{" +
                "programId=" + programId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    // Útil para comparar objetos por su ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return Objects.equals(programId, program.programId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programId);
    }
}

