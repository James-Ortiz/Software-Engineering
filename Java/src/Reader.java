/**
 * Created by HansYolo on 2/10/2016.
 */

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class Reader {

    private ArrayList<String> columns;
    private CSVReader reader;
    private ArrayList<Flight> flights;
    private int numRecords = 0; //keep track of how many records (flights) we have.



    public static void main(String[] args) {

       Reader r = new Reader();

    }

    public Reader(){
        columns = new ArrayList<String>();
        flights = new ArrayList<Flight>();
        create_and_read_input();
    }

    public void create_and_read_input(){

        try {
            CSVReader reader = new CSVReader(new FileReader("C:\\Users\\HansYolo\\Desktop\\AC_LISTRPS0818DCR.csv")); // .csv file location

            //the first row of the .csv will be the column titles, so let's put those into an ArrayList
            int numColumns;
            String [] nextLine;

            nextLine = reader.readNext();
            numColumns = nextLine.length-1;
            for(int i = 0; i <= numColumns; i++){
                columns.add(nextLine[i]);
                System.out.println(nextLine[i]);

            }

            //the rest of the rows should be records (flights), so lets use the info to create flight objects

            while ((nextLine = reader.readNext()) != null) {
                HashMap attributes = new HashMap();
                for(int i = 0; i <= numColumns; i++){

                    attributes.put(columns.get(i), nextLine[i]);
                }

                flights.add(new Flight(attributes));
                numRecords++;
//                System.out.println(flights.get(numRecords -1).getRequestedValue("#AC_NUM"));//for testing purposes
//
//                if(numRecords > 9){//just for testing
//                    break;
//                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getColumns(){

        return columns;
    }

    public ArrayList<Flight> getFlights(){

        return flights;
    }

    public int getNumRecords(){

        return numRecords;
    }
}
