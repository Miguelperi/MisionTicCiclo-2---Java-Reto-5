package model.vo;

public class LiderPorNombre {
        private int idLider;
        private String nombre;
        private String primerApellido;
        
        public LiderPorNombre(int idLider, String nombre, String primerApellido) {
            this.idLider = idLider;
            this.nombre = nombre;
            this.primerApellido = primerApellido;
        }

        public LiderPorNombre() {
        }

        public int getIdLider() {
            return idLider;
        }

        public void setIdLider(int idLider) {
            this.idLider = idLider;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getPrimerApellido() {
            return primerApellido;
        }

        public void setPrimerApellido(String primerApellido) {
            this.primerApellido = primerApellido;
        }
    
}
