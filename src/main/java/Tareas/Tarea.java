
package Tareas;

public class Tarea {
    
    private int id;
    
    private String nombreTarea;
    
    boolean completado = false;

    public Tarea(int id, String nombreTarea) {
        this.id = id;
        this.nombreTarea = nombreTarea;
    }
    
    public Tarea(){}
   

    public int getId() {
        return id;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
    
    
    public void cambiarCompletado() {
        completado = !completado; // Cambiar el valor de completado (true a false o false a true)
    }
    
}
