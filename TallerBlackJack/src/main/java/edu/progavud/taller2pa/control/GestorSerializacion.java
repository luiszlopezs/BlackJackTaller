package edu.progavud.taller2pa.control;
import edu.progavud.taller2pa.control.ControlPrincipal;
import edu.progavud.taller2pa.modelo.Crupier;
import edu.progavud.taller2pa.modelo.SerializacionCrupier;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class GestorSerializacion {
    private Crupier crupierASerializar;
    private Crupier crupierDesSerializada;
    private SerializacionCrupier serializar;
    private ControlPrincipal cPrinc;




    public GestorSerializacion(ControlPrincipal cPrinc) {   
        
        this.cPrinc = cPrinc;

        //serializar = new SerializacionCrupier();
    }

    public void Serializar(Crupier crupier) {
        crupierASerializar = crupier;
        try {
            serializar.escribirArchivoSerializado(crupierASerializar);
            serializar.cerrarArchivoSerializadoOut();
        } catch (IOException ex) {
            Logger.getLogger(GestorSerializacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    public void DesSerializar() {
        crupierDesSerializada = new Crupier();
        try {
            crupierDesSerializada = (Crupier) serializar.leerArchivoSerializado();
            serializar.cerrarArchivoSerializadoIn();
        } catch (IOException ex) {
            Logger.getLogger(GestorSerializacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorSerializacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Persona DesSerializada: " + crupierDesSerializada.getNombre() + " " + crupierDesSerializada.getApellido());
   }
}