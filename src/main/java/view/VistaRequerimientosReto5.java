package view;

import controller.ControladorRequerimientos;

import model.vo.LiderPorNombre;
import model.vo.LiderPorSalario;
import model.vo.ProyectosPorTipo;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaRequerimientosReto5 extends JFrame{
    
    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();
    // Creando la ventana para la Interfaz 
    //private JFrame frame = new JFrame("Consultas por Requerimiento");         
            
    // Creando el panel en la parte inferior para los
    private JPanel panel;

    // Área de texto en el centro
    private static JTextArea ta;

    public VistaRequerimientosReto5() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 50, 800, 650);
        panel = new JPanel();
        setContentPane(panel);

        JLabel titulo = new JLabel("Consultas Reto 5");
        titulo.setBounds(28,20,100,30);
        panel.add(titulo);
        panel.setLayout(null);

        JScrollPane barra = new JScrollPane();
        barra.setBounds(28,70,730,460);            
        panel.add(barra);

        ta = new JTextArea();
        barra.setViewportView(ta);

        JButton consulta1 = new JButton("Por Salario");
        consulta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();                     
            }
        });
        consulta1.setBounds(30,550,120,30);
        panel.add(consulta1);
        
        JButton consulta2 = new JButton("Por Tipo");
        consulta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento2();
            }
        });
        consulta2.setBounds(160, 550, 120, 30);
        panel.add(consulta2);
        
        JButton consulta3 = new JButton("Por Nombre");
        consulta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });
        consulta3.setBounds(290, 550, 120, 30);
        panel.add(consulta3);
        
        JButton limpiar = new JButton("Limpiar");
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("");
            }
        });
        limpiar.setBounds(620, 550, 120, 30);
        panel.add(limpiar);
    }

    public static void requerimiento1() {

        String result = "*** Lideres por Salario ***\n\nNombre\tPrimer Apellido\t\tID del Lider\tSalario\n\n";

        try {
            ArrayList<LiderPorSalario> rankingLiderPorSalario = controlador.consultarLiderPorSalario();

            for (LiderPorSalario liderPorSalario : rankingLiderPorSalario) {
                 
                result += liderPorSalario.getNombre();
                result += "\t";
                result += liderPorSalario.getPrimerApellido();
                result += "\t\t";
                result += liderPorSalario.getIdLider();
                result += "\t";
                result += liderPorSalario.getSalario();
                result += "\n";
                
                ta.setText(result);
            }
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public static void requerimiento2() {

        String result = "*** Proyectos por Tipo ***\n\nID Proyecto\tConstructora\t\tCiudad\tEstrato\n\n";

        try {
            ArrayList<ProyectosPorTipo> rankingProyectosPorTipo = controlador.consultarProyectosPorTipo();
            
            for (ProyectosPorTipo ProyectosPorTipo : rankingProyectosPorTipo) {
                result += ProyectosPorTipo.getId();
                result += "\t"; 
                result += ProyectosPorTipo.getConstructora();            
                if (ProyectosPorTipo.getConstructora().contains("Pegaso") ) {
                    result += "\t\t";
                }else {
                    result += "\t";
                }
                result += ProyectosPorTipo.getCiudad();
                result += "\t";
                result += ProyectosPorTipo.getEstrato();
                result += "\n";

                ta.setText(result);
            }
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public static void requerimiento3() {

        String result = "*** Lideres por Nombre ***\n\nId del Lider\tNombre\tPrimer Apellido\n\n";

        try {
            ArrayList<LiderPorNombre> rankingLiderPorNombre = controlador.consultarLiderPorNombre();

            for (LiderPorNombre liderPorNombre : rankingLiderPorNombre) {                
                result += liderPorNombre.getIdLider();
                result += "\t";
                result += liderPorNombre.getNombre();
                result += "\t";
                result += liderPorNombre.getPrimerApellido();
                result += "\n";

                ta.setText(result);
            }
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }        
    }
}
