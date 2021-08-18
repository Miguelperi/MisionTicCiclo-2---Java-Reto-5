package model.vo;

public class LiderPorSalario {
    
    private String nombre;
    private String primerApellido;
    private int idLider;
    private int salario;
    
    public LiderPorSalario() {        
    }
    
    public LiderPorSalario(String nombre, String primerApellido, int idLider, int salario) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.idLider = idLider;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido){
        this.primerApellido = primerApellido;
    }

    public int getIdLider() {
        return idLider;
    }

    public void setIdLider(int idLider) {
        this.idLider = idLider;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
