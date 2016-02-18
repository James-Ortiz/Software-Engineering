import java.util.HashMap;

/**
 * Created by HansYolo on 2/12/2016.
 * Added something else.
 * Added more
 */
public class Flight {

    private HashMap flightData;

    public Flight(HashMap attributes){

        flightData = attributes;

    }

    //takes input and returns the requested value from the flightData Hashmap
    //Todo: Test for ints or doubles (and maybe timestamps) and convert if necessary
    public Object getRequestedValue(String key){

        for (Object k : flightData.keySet()) {
           if(k.toString().equals(key)){

            return flightData.get(key);
           }
        }

        return "Key not Found";
    }
}
