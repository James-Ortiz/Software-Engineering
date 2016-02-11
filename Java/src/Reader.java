/**
 * Created by HansYolo on 2/10/2016.
 */

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class Reader {


    public static void main(String[] args) {
        try {
            CSVReader reader = new CSVReader(new FileReader("C:\\Users\\HansYolo\\SWI\\Software-Engineering\\Java\\expanded_nonzero_bias_terms.csv")); // .csv file location
            String [] nextLine;
            nextLine = reader.readNext();
            // nextLine[] is an array of values from the line
            System.out.println(nextLine[0] + " " + nextLine[1] + " etc...");



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
