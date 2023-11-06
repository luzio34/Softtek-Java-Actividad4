
//FALTA ACOMODAR LAS CONSULTAS SQL


package Interfaces;

import Main.Main;
import Tareas.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoTareaImplementacion implements DaoTarea {

    //Establecemos una estancia de la clase main aqui
    Main main = new Main();

    @Override
    public void registrar(Tarea tarea) {

        //Implementamos un Try-Catch
        try {
            Connection conectar = this.main.establecerConeccion();
            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO task (description) VALUES (?)");
            //insertar.setInt(1, tarea.getId());
            insertar.setString(1, tarea.getNombreTarea());
            insertar.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    @Override
    public void modificar(Tarea tarea) {
        try {
            Connection conectar = main.establecerConeccion();

            PreparedStatement modificar = conectar.prepareStatement("update task set description= ? where idtask = ?;");

            modificar.setString(1, tarea.getNombreTarea());
            modificar.setInt(2, tarea.getId());
            modificar.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    @Override
    public void eliminar(Tarea tarea) {
        try {

            Connection conectar = main.establecerConeccion();

            PreparedStatement eliminar = conectar.prepareStatement("delete from task where idtask = ?");

            eliminar.setInt(1, tarea.getId());
            eliminar.execute();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void buscar(Tarea tarea) {

        /*try {

            Connection conectar = main.establecerConeccion();

            PreparedStatement buscar = conectar.prepareStatement("select * from empleados where id = ?");

            buscar.setInt(1, tarea.getId());

            ResultSet consulta = buscar.executeQuery();

            if (consulta.next()) {
                tarea.setId(Integer.parseInt(consulta.getString("id")));
                tarea.setNombreTarea(consulta.getString("nombre"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }*/

    }
    
    @Override
    public List<Tarea> listarTodos() {
        List<Tarea> listaTareas = new ArrayList<>();

        try {
            Connection conectar = main.establecerConeccion();
            PreparedStatement listar = conectar.prepareStatement("SELECT * FROM task");
            ResultSet consulta = listar.executeQuery();

            while (consulta.next()) {
                Tarea tarea = new Tarea();
                tarea.setId(Integer.parseInt(consulta.getString("idtask")));
                tarea.setNombreTarea(consulta.getString("description"));
                tarea.setCompletado(consulta.getBoolean("completed"));
                listaTareas.add(tarea);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return listaTareas;
    }
    
    @Override
    public void modificarEstadoCompletado(Tarea tarea) {
        try {
            Connection conectar = main.establecerConeccion();
            PreparedStatement modificar = conectar.prepareStatement("UPDATE task SET completed = ? WHERE idtask = ?");

            modificar.setBoolean(1, true); // Establece el estado de completado como true
            modificar.setInt(2, tarea.getId());

            modificar.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    

}
