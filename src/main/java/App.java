import view.VistaRequerimientosReto5;

import java.awt.EventQueue;



public class App {
    public static void main( String[] args ){      
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaRequerimientosReto5 frame = new VistaRequerimientosReto5();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }                
            }
        });
    }
}
