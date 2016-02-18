import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.table.*;
/**
 * Created with IntelliJ IDEA.
 * User: Stanimir
 * Date: 2/17/16
 * Time: 10:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class GUI extends JFrame {
	private JLabel average;
    private JTable maintable;
    private TableColumn cityColumn, arivalColumn, departureColumn, overflighColumn;
    private Metrics generator = new Metrics(); // use to get average flight times, and values for arivals departures and overflighs
	private JButton selectMetric, selectCity;
	private JComboBox metricList, cityList;
	private String[] metrics = {"Average flight time", "City Operations"};
	private String[] cities = {"PHL", "JFK"};
	
    public GUI(){
		createUserInterface();
    }
	
	private void createUserInterface(){
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		metricList = new JComboBox(metrics);
		metricList.setBounds(20, 20, 140, 40);
		contentPane.add(metricList);
		
		average = new JLabel();
		average.setText(generator.calulateAverage()+" Average flight time");
		average.setBounds(180, 30, 200, 20);
		average.setVisible(false);
		contentPane.add(average);
		
		selectMetric = new JButton();
		selectMetric.setText("Select Metric");
		selectMetric.setBounds(30, 80, 120, 40);
		contentPane.add(selectMetric);
		selectMetric.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int selection = metricList.getSelectedIndex();
						if(selection==0){
							average.setVisible(true);
							maintable.setVisible(false);
							cityList.setVisible(false);
							selectCity.setVisible(false);
						}
						else if(selection==1){
							average.setVisible(false);
							maintable.setVisible(true);
							cityList.setVisible(true);
							selectCity.setVisible(true);
						}
					}
				}
		);
		
		maintable = new JTable(2,3);
		maintable.setBounds(180, 20, 225, 80);
		maintable.setRowHeight(40);
		maintable.setVisible(false);
		maintable.setEnabled(false);
		maintable.setValueAt("Arrivals", 0, 1);
		maintable.setValueAt("Departures", 0, 2);
		contentPane.add(maintable);
		
		cityList = new JComboBox(cities);
		cityList.setBounds(180, 140, 100, 40);
		cityList.setVisible(false);
		contentPane.add(cityList);
		
		selectCity = new JButton();
		selectCity.setText("Select City");
		selectCity.setBounds(300, 140, 120, 40);
		selectCity.setVisible(false);
		
		contentPane.add(selectCity);
		selectCity.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						int selection = cityList.getSelectedIndex();
						if(selection==0){
							maintable.setValueAt("PHL", 1, 0);
							maintable.setValueAt(generator.getArrivals("PHL"), 1, 1);
							maintable.setValueAt(generator.getDepartures("PHL"), 1, 2);
						}
						else if(selection==1){
							maintable.setValueAt("JFK", 1, 0);
							maintable.setValueAt(generator.getArrivals("JFK"), 1, 1);
							maintable.setValueAt(generator.getDepartures("JFK"), 1, 2);
						}
					}
				}
		);
		
		setSize(550,300);
		setVisible(true);
		setTitle("Metrics Generator");
	}
	public static void main(String[] args){
		GUI gui = new GUI();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
