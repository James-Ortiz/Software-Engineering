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
 * @author Danielle
 */
public class Metrics {
    private String airNum;
    private String ACID;
    private String track;
    private int start;
    private int end;
    public Metrics(){
        
    }
    
    public void singleFlight(int counter){
        Metrics m= new Metrics();
//  Reader r = new Reader();
//        int ac_num=0;
 Map<String, ArrayList<String>> flightMap = new HashMap<String, ArrayList<String>>();
 ArrayList<String> myArray = new ArrayList<String>();
 myArray.add(m.track(counter));
 myArray.add(m.getACID(counter));
 
 flightMap.put(airNum, myArray);


System.out.print("Aircraft number: " + airNum + " ");
System.out.println(flightMap.get(airNum));
    }
    
    /**
     * Returns the AC_Num from the .csv file
     * @param getID
     * @return airID
     */
    public String getAircraftNum(int getID){
        
        Reader r = new Reader();
        airNum = (String) r.getFlights().get(getID).getRequestedValue("#AC_NUM");
        return airNum;
    }
    
    /**
     * Returns the track_cnt number from the .csv file
     * @param getTrack
     * @return track
     */
    public String track(int getTrack){
        
        Reader r = new Reader();
        track = (String) r.getFlights().get(getTrack).getRequestedValue("TRACK_CNT");
        return track;
    }
    
    /**
     * Returns the ACID number from the .csv file
     * @param getACID
     * @return ACID
     */
    public String getACID(int getACID){
        
        Reader r = new Reader();
        ACID = (String) r.getFlights().get(getACID).getRequestedValue("ACID");
        return ACID;
    }
    
    public int getStartTime(int getStart){
        Reader r = new Reader();
        start = Integer.parseInt( (String) r.getFlights().get(getStart).getRequestedValue("ST_TIME"));
        return start;
        
    }
    
    public int getEndTime(int getEnd){
        Reader r = new Reader();
        end =  Integer.parseInt((String) r.getFlights().get(getEnd).getRequestedValue("END_TIME"));
        return end;
    }
    
    public void startCoversion(){
        
        int temp = start;
        int seconds = 0;
        int minutes = 0;
        int hours = 0;
       hours = temp / 3600;
       minutes = temp / 60;
       minutes = minutes % 60;
       seconds = temp % 60;
        System.out.println("Start time: " + hours + ":" + minutes + ":" + seconds);
    }
    
    public void endCoversion(){
        int temp = end;
        int seconds = 0;
        int minutes = 0;
        int hours = 0;
       hours = temp / 3600;
       minutes = temp / 60;
       minutes = minutes % 60;
       seconds = temp % 60;
       System.out.println("End time: " + hours + ":" + minutes + ":" + seconds);
    }
    
    /**
     * This method calculates the flight duration and prints it out into hh:mm:ss
     * format
     */
    public void flightDuration(){
        Metrics m = new Metrics();
        int duration = end - start;
        int temp = duration;
        int seconds = 0;
        int minutes = 0;
        int hours = 0;
        hours = temp / 3600;
        minutes = temp / 60;
        minutes = minutes % 60;
        seconds = temp % 60;
       System.out.println("Flight duration: " + hours + ":" + minutes + ":" + seconds);
        
    }
    
    /**
     * Just prints out the first five rows, and only the ac_num, track_cnt, and acid
     * in the .csv to test the output
     * @param args 
     */
    public static void main(String args[]){
        try{
        Metrics m = new Metrics();
        for(int i =0; i < 5; i++){
            m.getAircraftNum(i);
            m.track(i);
            m.getACID(i);
            m.singleFlight(i);
            m.getStartTime(i);
            m.getEndTime(i);
            m.startCoversion();
            m.endCoversion();
            m.flightDuration();
            
            
        }
       
        

    }
       catch (Exception e){
    e.printStackTrace();
}
    }
    
}
