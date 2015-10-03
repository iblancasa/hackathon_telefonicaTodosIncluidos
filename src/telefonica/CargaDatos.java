/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefonica;

import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author JaviRubio
 */
public class CargaDatos {
   private List<IoT> listaDatos;
   private static String[] listaID={"ZJ0SW7","7WLFOO","HXATL0","HTUQ68","FCG2RE","NAXH9P","JP30ET","EN898Y","YB6PBL","ZMHBSU"};

   public void CargarDatos(){
       IoT aux;
       int contador=0;
       listaDatos=new ArrayList<>();
       for(String ID:listaID){
           aux=new IoT("Dispositivo"+contador++,ID,0,0);
           listaDatos.add(aux);
       }
   }
   public IoT getDispositivo(int posicion){
       return listaDatos.get(posicion);
   }
}
