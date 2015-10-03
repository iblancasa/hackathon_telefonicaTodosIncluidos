
package telefonica;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iblancasa
 */
public class IoT {
    
    private String name;
    private float coordinateX;
    private float coordinateY;
    private String ID;
    private HttpURLConnection connection;
    
    
    private String cellid;
    private int dbm;
    private float humidity;
    private float luminance;
    private float temperature;

    
    
    public IoT(String nameIoT,String IDIoT, float coorX, float coorY){
        name = nameIoT;
        coordinateX = coorX;
        coordinateY = coorY;
        
        ID = IDIoT;
        
        try {
           URL url = new URL("http://hackathon.ttcloud.net:10026/v1/contextEntities/"+IDIoT);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept","application/json");

            connection.setRequestProperty("fiware-service","todosincluidos");
            connection.setRequestProperty("fiware-servicepath","/iot");
        
        } catch (MalformedURLException ex) {
            Logger.getLogger(IoT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IoT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    public void update() throws IOException{
        try {
            connection.connect();
        } catch (IOException ex) {
            Logger.getLogger(IoT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connection.getResponseCode()!=200){
            return;
        }
        
         BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(IoT.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sb = new String();
        String line;
        while ((line = br.readLine()) != null) {
            sb+=line;
        }
        br.close();
                
        JsonObject object = Json.parse(sb).asObject();
        JsonObject context = object.get("contextElement").asObject();
        JsonArray attributes = context.get("attributes").asArray();
        
        cellid = attributes.get(0).asObject().get("value").asString();
        
       
        humidity = Float.parseFloat( attributes.get(6).asObject().get("value").asString());
        
        luminance = Float.parseFloat(attributes.get(8).asObject().get("value").asString());
        temperature = Float.parseFloat( attributes.get(16).asObject().get("value").asString());
    }
    
    
    
    public String getCellID(){
        return cellid;
    }
    

    
    
    public int getDBM(){
        return dbm;
    }
    
    public float getHumidity(){
        return humidity;
    }
    
    public float getLuminance(){
        return luminance;
    }
    
    public float getTemperature(){
        return temperature;
    }
    
    public float getCoordinateX(){
        return coordinateX;
    }
    
    public float getCoordinateY(){
        return coordinateY;
    }
    
    
}
