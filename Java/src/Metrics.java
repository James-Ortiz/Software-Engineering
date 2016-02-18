/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

/**
 *
 * @author Danielle.
 */
public class Metrics {
    private String airNum;
    private String ACID;
    private String track;
    private int start;
    private int end;
    private int flights=50;
    private Reader r = new Reader();

    public Metrics(){
        
    }
    
    public void singleFlight(int counter){
        Metrics m= new Metrics();
//      Reader r = new Reader();
//      int ac_num=0;
        Map<String, ArrayList<String>> flightMap = new HashMap<String, ArrayList<String>>();
        ArrayList<String> myArray = new ArrayList<String>();
        myArray.add(m.track(counter));
        myArray.add(m.getACID(counter));
 
        flightMap.put(airNum, myArray);
    }
    
    /**
     * Returns the AC_Num from the .csv file
     * @param getID
     * @return airID
     */
    public String getAircraftNum(int getID){

        airNum = (String) r.getFlights().get(getID).getRequestedValue("#AC_NUM");
        return airNum;
    }
    
    /**
     * Returns the track_cnt number from the .csv file
     * @param getTrack
     * @return track
     */
    public String track(int getTrack){

        track = (String) r.getFlights().get(getTrack).getRequestedValue("TRACK_CNT");
        return track;
    }
    
    /**
     * Returns the ACID number from the .csv file
     * @param getACID
     * @return ACID
     */
    public String getACID(int getACID){

        ACID = (String) r.getFlights().get(getACID).getRequestedValue("ACID");
        return ACID;
    }
    
    public int getStartTime(int getStart){

        start = Integer.parseInt( (String) r.getFlights().get(getStart).getRequestedValue("ST_TIME"));
        return start;
        
    }
    
    public int getEndTime(int getEnd){

        end =  Integer.parseInt((String) r.getFlights().get(getEnd).getRequestedValue("END_TIME"));
        return end;
    }

    public int getArrivals(String city){
        int arrivals=0;
        for(int i=0;i<flights;i++){
             if(city.equals((String) r.getFlights().get(i).getRequestedValue("ORIGIN_FIX")))
                arrivals++;
        }
        return arrivals;
    }

    public int getDepartures(String city){
        int departures=0;
        for(int i=0;i<flights;i++){
            if(city.equals((String) r.getFlights().get(i).getRequestedValue("DEST_FIX")))
                departures++;
        }
        return departures;
    }

    /**
     * This method calculates the flight duration and prints it out into hh:mm:ss
     * format
     */
    public int flightDuration(){
        Metrics m = new Metrics();
        int duration = end - start;
        return duration;
    }

    public int calulateAverage(){
        int average=0;

        for(int i =0; i < flights; i++){
            getAircraftNum(i);
            track(i);
            singleFlight(i);
            getStartTime(i);
            getEndTime(i);

            average+=flightDuration();


        }
        average/=flights;
        return average;
    }

    /**
     * Just prints out the first five rows, and only the ac_num, track_cnt, and acid
     * in the .csv to test the output
     * @param args 
     */
    
}
