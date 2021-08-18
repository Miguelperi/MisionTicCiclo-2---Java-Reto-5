package model.vo;

public class ProyectosPorTipo {
    private int IdProyecto;
    private String Constructora;
    private String Ciudad;
    private int Estrato;

    public ProyectosPorTipo() {
    }

    public ProyectosPorTipo(int IdProyecto, String Constructora, String Ciudad, int Estrato) {
        this.IdProyecto = IdProyecto;
        this.Constructora = Constructora;
        this.Ciudad = Ciudad;
        this.Estrato = Estrato;
    }

    public int getId() {
        return IdProyecto;
    }

    public void setId(int IdProyecto) {
        this.IdProyecto = IdProyecto;
    }

    public String getConstructora(){
        return Constructora;
    }

    public void setConstructora(String Constructora){
        this.Constructora = Constructora;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad){
        this.Ciudad = Ciudad;
    }

    public int getEstrato() {
        return Estrato;
    }

    public void setEstrato(int Estrato) {
        this.Estrato = Estrato;
    }
}
