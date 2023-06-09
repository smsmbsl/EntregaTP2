
package tp;

import java.util.List;

/**
 *
 * @author Martin Lemberger
 */

public class PronosticoDeportivo {
    private ListaEquipos equipos;
    private ListaPartidos partidos;
    private ListaParticipantes participantes;
    private ListaPronosticos pronosticos;

    public PronosticoDeportivo() {
        equipos = new ListaEquipos();
        partidos = new ListaPartidos();
        participantes = new ListaParticipantes();
        pronosticos = new ListaPronosticos();
    }

    public void play(){
        // cargar y listar los equipos
        equipos.cargarDeArchivo();
        System.out.println("Los equipos cargados son: " + equipos.listar());
        
        System.out.println("================================================");
        
        partidos.cargarDeArchivo(equipos);
        System.out.println("Los partidos cargados son: " + partidos.listar());
        
        System.out.println("================================================");

        participantes.cargarDeArchivo();
        // Una vez cargados los participantes, para cada uno de ellos
        // cargar sus pronósticos
        for (Participante p : participantes.getParticipantes()) {
            p.cargarPronosticos(equipos, partidos);
        }     
        System.out.println("Los participantes cargados son: " + participantes.listar());
        
        System.out.println("================================================ \n");
        
    } 
    
   public void mostrarPuntajes () {
       
       List<Participante> parti = participantes.getParticipantes();
       List<Participante> parti2 = parti;
       
       System.out.println("Puntajes Finales: \n");
        
        for (Participante participante : parti2) { 
            System.out.println("Participante: " + participante.getNombre() + "\n" 
                                + "El puntaje para el participante es: " + participante.getPuntaje() + " puntos \n"
                                + "La cantidad de aciertos para el participante es: " 
                                +  participante.getAciertos());
            
            System.out.println("================================================ \n");
            
        }   
   }
   
   public void mostarPuntajesOrdenados () {
   
       System.out.println("""
                          Los puntajes de los participantes ordenados de mayor a menor son: 
                          ---------------------------------------------------------------- 
                          """ + participantes.listaOrdenados());
       
       System.out.println("================================== \n");
   }
  
   
    public void mostrarGanador () {
  
        System.out.println("¡¡GANADOR!! \n");
        
        participantes.ganador();
        
        System.out.println("""
                           
                           ================================== 
                           """);
   }
}
