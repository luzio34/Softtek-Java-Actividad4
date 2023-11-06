
package Interfaces;

import Tareas.Tarea;
import java.util.List;

public interface DaoTarea {
    
    public void registrar(Tarea tarea);
    
    public void modificar (Tarea tarea);
    
    public void eliminar (Tarea tarea);
    
    public void buscar (Tarea tarea);
    
    public List<Tarea> listarTodos();
    
    public void modificarEstadoCompletado (Tarea tarea);
    
}
