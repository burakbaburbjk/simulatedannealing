package brk;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import java.sql.*;
import java.util.ArrayList;

import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.event.map.StateChangeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.LatLngBounds;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polygon;
import org.primefaces.model.map.Polyline;

import com.mysql.jdbc.BestResponseTimeBalanceStrategy;

import algoritma.City;
import algoritma.SimulatedAnnealing;
import algoritma.Tour;
import algoritma.TourManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;

@ManagedBean(name="lb")
@SessionScoped
public class UyeBean  {
	  
	//private  String[] tour2 = new String[20];  
	   
	 private MapModel polylineModel;  	
	private String tour2;
	 private String tour3;
	 private String tour4;
	 private String tour5;
	 private String tour6;


	 private int finaldestination;
	 private int initialdistance;


	public int getFinaldestination() {
		return finaldestination;
	}

	public void setFinaldestination(int finaldestination) {
		this.finaldestination = finaldestination;
	}

	public int getInitialdistance() {
		return initialdistance;
	}

	public void setInitialdistance(int initialdistance) {
		this.initialdistance = initialdistance;
	}

	
	

	public String getTour4() {
		return tour4;
	}

	public void setTour4(String tour4) {
		this.tour4 = tour4;
	}

	public String getTour5() {
		return tour5;
	}

	public void setTour5(String tour5) {
		this.tour5 = tour5;
	}

	public String getTour6() {
		return tour6;
	}

	public void setTour6(String tour6) {
		this.tour6 = tour6;
	}

	public String getTour3() {
		return tour3;
	}

	public void setTour3(String tour3) {
		this.tour3 = tour3;
	}

	private MapModel simpleModel;  
	
	    public UyeBean() {  
	    
	    	polylineModel = new DefaultMapModel();  
	        simpleModel = new DefaultMapModel();  
	       
	        City city1  =  new City(1150.0,760.0);     TourManager.addCity(city1);
	        City city2  =  new City(630.0,1660.0);     TourManager.addCity(city2);
	        City city3  =  new City(40.0,2090.0);     TourManager.addCity(city3);
	        City city4  =  new City(750.0,1100.0);     TourManager.addCity(city4);
	        City city5  =  new City(750.0,2030.0);     TourManager.addCity(city5);
	        City city6  =  new City(1030.0,2070.0);     TourManager.addCity(city6);
	        City city7  =  new City(1650.0,650.0);     TourManager.addCity(city7);
	        City city8  =  new City(1490.0,1630.0);     TourManager.addCity(city8);
	        City city9  =  new City(790.0,2260.0);     TourManager.addCity(city9);
	        City city10 = new City(710.0,1310.0);     TourManager.addCity(city10);
	        City city11 = new City(840.0,550.0);     TourManager.addCity(city11);
	        City city12 = new City(1170.0,2300.0);     TourManager.addCity(city12);
	        City city13 = new City(970.0,1340.0);     TourManager.addCity(city13);
	        City city14 = new City(510.0,700.0);     TourManager.addCity(city14);
	        City city15 = new City(750.0,900.0);     TourManager.addCity(city15);
	  
	        City city16 = new City(1280.0,1200.0);     TourManager.addCity(city16);
	        City city17 = new City(230.0,590.0);     TourManager.addCity(city17);

	        City city18 = new City(460.0,860.0);     TourManager.addCity(city18);

	        City city19 = new City(1040.0,950.0);     TourManager.addCity(city19);
	        City city20 = new City(590.0,1390.0);     TourManager.addCity(city20);

	        City city21 = new City(830.0,1770.0);     TourManager.addCity(city21);
	        City city22 = new City(490.0,500.0);     TourManager.addCity(city22);
	        City city23 = new City(1840.0,1240.0);     TourManager.addCity(city23);
	        City city24 = new City(1260.0,1500.0);    TourManager.addCity(city24);
	      
	        City city25 = new City(1280.0,790.0);     TourManager.addCity(city25);
	      
	        City city26 = new City(490.0,2130.0);     TourManager.addCity(city26);



	        City city27 = new City(1460.0,1420.0);     TourManager.addCity(city27);
	        City city28 = new City(1260.0,1910.0);     TourManager.addCity(city28);

	        City city29 = new City(360.0,1980.0);     TourManager.addCity(city29);
	        /*
	        City city30 = new City(39.57,41.15);     TourManager.addCity(city30);
	        City city31 = new City(36.15,53.78);     TourManager.addCity(city31);
	        City city32 = new City(30.55,52.25);     TourManager.addCity(city32);
	        City city33 = new City(28.97,48.98);     TourManager.addCity(city33);
	        City city34 = new City(34.62,53.20);     TourManager.addCity(city34);



	        City city35 = new City(27.15,51.60);     TourManager.addCity(city35);

	        City city36 = new City(43.08,49.40);     TourManager.addCity(city36);
	        City city37 = new City(33.78,48.63);     TourManager.addCity(city37);
	        City city38 = new City(35.50,51.27);     TourManager.addCity(city38);

	        City city39 = new City(27.20,48.28);     TourManager.addCity(city39);
	        City city40 = new City(34.17,50.85);     TourManager.addCity(city40);
	        City city41 = new City(29.95,49.22);     TourManager.addCity(city41);
	        City city42 = new City(32.50,52.12);     TourManager.addCity(city42);
	        City city43 = new City(29.97,50.57);     TourManager.addCity(city43);
	        City city44 = new City(38.32,51.65);     TourManager.addCity(city44);



	        City city45 = new City(27.42,51.40);     TourManager.addCity(city45);
	        City city46 = new City(36.93,52.42);     TourManager.addCity(city46);



	        City city47 = new City(40.75,52.68);     TourManager.addCity(city47);
	        City city48 = new City(28.35,52.78);     TourManager.addCity(city48);
	        City city49 = new City(41.50,51.27);     TourManager.addCity(city49);
	        City city50 = new City(34.72,51.38);    TourManager.addCity(city50);

	        City city51 = new City(34.68,52.03);     TourManager.addCity(city51);
	        City city52 = new City(37.87,49.02);     TourManager.addCity(city52);
	        City city53 = new City(40.52,48.98);     TourManager.addCity(city53);
	        City city54 = new City(30.38,49.23);     TourManager.addCity(city54);


	        City city55 = new City(36.33,48.73);     TourManager.addCity(city55);
	        City city56 = new City(41.95,52.07);     TourManager.addCity(city56);
	        City city57 = new City(35.15,47.98);     TourManager.addCity(city57);
	        City city58 = new City(37.02,50.25);     TourManager.addCity(city58);
	        City city59 = new City(27.50,49.02);     TourManager.addCity(city59);

	        City city60 = new City(36.57,49.67);     TourManager.addCity(city60);
	        City city61 = new City(39.77,49.02);     TourManager.addCity(city61);

	        City city62 = new City(39.53,50.88);     TourManager.addCity(city62);
	        City city63 = new City(38.77,52.87);     TourManager.addCity(city63);
	        City city64 = new City(29.40,51.33);     TourManager.addCity(city64);
	        City city65 = new City(43.35,51.47);     TourManager.addCity(city65);
	        City city66 = new City(34.82,50.18);     TourManager.addCity(city66);


	        City city67 = new City(31.80,48.55);     TourManager.addCity(city67);
	        City city68 = new City(34.00,51.62);     TourManager.addCity(city68);

	        City city69 = new City(40.23,49.73);     TourManager.addCity(city69);
	        City city70 = new City(33.20,52.82);     TourManager.addCity(city70);


	        City city71 = new City(33.62,50.13);     TourManager.addCity(city71);

	        City city72 = new City(41.12,52.13);     TourManager.addCity(city72);
	        City city73 = new City(42.48,52.45);     TourManager.addCity(city73);
	        City city74 = new City(32.33,48.37);     TourManager.addCity(city74);


	        City city75 = new City(42.68,48.88);     TourManager.addCity(city75);
	        City city76 = new City(44.05,50.08);     TourManager.addCity(city76);

	        City city77 = new City(29.27,49.35);     TourManager.addCity(city77);
	        City city78 = new City(32.62,48.80);     TourManager.addCity(city78);


	        City city79 = new City(37.12,53.28);     TourManager.addCity(city79);

	        City city80 = new City(36.23,52.95);     TourManager.addCity(city80);
	        City city81 = new City(31.17,49.17);     TourManager.addCity(city81);
	        */
	        double temp = 8000;

	        // Cooling rate
	        double coolingRate = 0.05;

	        // Initialize intial solution
	        Tour currentSolution = new Tour();
	        currentSolution.generateIndividual();
	       
	        System.out.println("Initial solution distance: " + currentSolution.getDistance());
	        initialdistance= currentSolution.getDistance();
	        // Set initial temp
	      
	        // Set as current best
	    Tour best = new Tour(currentSolution.getTour());
int iterasyon =1000;
	        // Loop until system has cooled
	    while (temp > 1) {
	    	while(iterasyon>0){
	    		
	    		
	    	
            // Create new neighbour tour
            Tour newSolution = new Tour(currentSolution.getTour());

            // Get a random positions in the tour
            int tourPos1 = (int) (newSolution.tourSize() * Math.random());
            int tourPos2 = (int) (newSolution.tourSize() * Math.random());

            // Get the cities at selected positions in the tour
            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);

            // Swap them
            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);

            // Get energy of solutions
            int currentEngery = currentSolution.getDistance();
            int neighbourEngery = newSolution.getDistance();

            // Decide if we should accept the neighbour
          
            // Keep track of the best solution found
            if (currentSolution.getDistance() < best.getDistance()) {
                best = new Tour(currentSolution.getTour());
            }

            // Cool system
            temp *= 1-coolingRate;
            iterasyon--;
        }
	    	iterasyon=1000;
	    }
	 finaldestination =best.getDistance();
      //  System.out.println("Final solution distance: " + 10*best.getDistance());
        //System.out.println("Tour: " + best);
    

	  ArrayList < LatLng > latLngList = new ArrayList< LatLng >();
	       
	        //Shared coordinates  
	        LatLng coord1 = new LatLng(best.getCity(0).getX(),best.getCity(0).getY()); 
	        latLngList.add(coord1);
	        LatLng coord2 = new LatLng(best.getCity(1).getX(),best.getCity(1).getY()); 
	        latLngList.add(coord2);
	        LatLng coord3 = new LatLng(best.getCity(2).getX(),best.getCity(2).getY()); 
	        latLngList.add(coord3);
	      
	        LatLng coord4 = new LatLng(best.getCity(3).getX(),best.getCity(3).getY());
	        latLngList.add(coord4);
	        LatLng coord5 = new LatLng(best.getCity(4).getX(),best.getCity(4).getY()); 
	        latLngList.add(coord5);
	        LatLng coord6 = new LatLng(best.getCity(5).getX(),best.getCity(5).getY());
	        latLngList.add(coord6);
	        LatLng coord7 = new LatLng(best.getCity(6).getX(),best.getCity(6).getY());
	        latLngList.add(coord7);
	        LatLng coord8 = new LatLng(best.getCity(7).getX(),best.getCity(7).getY()); 
	        latLngList.add(coord8);
	      
	        LatLng coord9 = new LatLng(best.getCity(8).getX(),best.getCity(8).getY()); 
	        latLngList.add(coord9);
	        LatLng coord10 = new LatLng(best.getCity(9).getX(),best.getCity(9).getY());  
	        latLngList.add(coord10);
	        LatLng coord11 = new LatLng(best.getCity(10).getX(),best.getCity(10).getY());  
	        latLngList.add(coord11);
	        LatLng coord12 = new LatLng(best.getCity(11).getX(),best.getCity(11).getY()); 
	        latLngList.add(coord12);
	        LatLng coord13 = new LatLng(best.getCity(12).getX(),best.getCity(12).getY());  
	        latLngList.add(coord13);
	        LatLng coord14 = new LatLng(best.getCity(13).getX(),best.getCity(13).getY());  
	        latLngList.add(coord14);
	        LatLng coord15 = new LatLng(best.getCity(14).getX(),best.getCity(14).getY()); 
	        latLngList.add(coord15);
	       
	       
	        LatLng coord16 = new LatLng(best.getCity(15).getX(),best.getCity(15).getY());
	        latLngList.add(coord16);
	        
	        LatLng coord17 = new LatLng(best.getCity(16).getX(),best.getCity(16).getY()); 
	        latLngList.add(coord17);
	        LatLng coord18 = new LatLng(best.getCity(17).getX(),best.getCity(17).getY()); 
	        latLngList.add(coord18);
	        LatLng coord19 = new LatLng(best.getCity(18).getX(),best.getCity(18).getY()); 
	        latLngList.add(coord19);
	        LatLng coord20 = new LatLng(best.getCity(19).getX(),best.getCity(19).getY()); 
	        latLngList.add(coord20);
	        LatLng coord21 = new LatLng(best.getCity(20).getX(),best.getCity(20).getY());
	        latLngList.add(coord21);
	        LatLng coord22 = new LatLng(best.getCity(21).getX(),best.getCity(21).getY()); 
	        latLngList.add(coord22);
	        LatLng coord23 = new LatLng(best.getCity(22).getX(),best.getCity(23).getY());
	        latLngList.add(coord23);
	        LatLng coord24 = new LatLng(best.getCity(23).getX(),best.getCity(23).getY());
	        latLngList.add(coord24);
	        LatLng coord25 = new LatLng(best.getCity(24).getX(),best.getCity(24).getY()); 
	        latLngList.add(coord25);
	     
	        LatLng coord26 = new LatLng(best.getCity(25).getX(),best.getCity(25).getY()); 
	        latLngList.add(coord26);
	        LatLng coord27 = new LatLng(best.getCity(26).getX(),best.getCity(26).getY());  
	        latLngList.add(coord27);
	        LatLng coord28 = new LatLng(best.getCity(27).getX(),best.getCity(27).getY());  
	        latLngList.add(coord28);
	        LatLng coord29 = new LatLng(best.getCity(28).getX(),best.getCity(28).getY()); 
	        latLngList.add(coord29);
	        /*
	        LatLng coord30 = new LatLng(best.getCity(29).getX(),best.getCity(29).getY());  
	        latLngList.add(coord30);
	        LatLng coord31 = new LatLng(best.getCity(30).getX(),best.getCity(30).getY());  
	        latLngList.add(coord31);
	        LatLng coord32 = new LatLng(best.getCity(31).getX(),best.getCity(31).getY()); 
	        latLngList.add(coord32);
	        LatLng coord33 = new LatLng(best.getCity(32).getX(),best.getCity(32).getY());
	        latLngList.add(coord33);
	        LatLng coord34 = new LatLng(best.getCity(33).getX(),best.getCity(33).getY()); 
	        latLngList.add(coord34);
	        LatLng coord35 = new LatLng(best.getCity(34).getX(),best.getCity(34).getY()); 
	        latLngList.add(coord35);
	        LatLng coord36 = new LatLng(best.getCity(35).getX(),best.getCity(35).getY()); 
	        latLngList.add(coord36);
	        LatLng coord37 = new LatLng(best.getCity(36).getX(),best.getCity(36).getY()); 
	        latLngList.add(coord37);
	        LatLng coord38 = new LatLng(best.getCity(37).getX(),best.getCity(37).getY());
	        latLngList.add(coord38);
	        LatLng coord39 = new LatLng(best.getCity(38).getX(),best.getCity(38).getY()); 
	        latLngList.add(coord39);
	        LatLng coord40 = new LatLng(best.getCity(39).getX(),best.getCity(39).getY());
	        latLngList.add(coord40);
	        LatLng coord41 = new LatLng(best.getCity(40).getX(),best.getCity(40).getY());
	        latLngList.add(coord41);
	        LatLng coord42 = new LatLng(best.getCity(41).getX(),best.getCity(41).getY()); 
	        latLngList.add(coord42);
	        LatLng coord43 = new LatLng(best.getCity(42).getX(),best.getCity(42).getY()); 
	        latLngList.add(coord43);
	        LatLng coord44 = new LatLng(best.getCity(43).getX(),best.getCity(43).getY());  
	        latLngList.add(coord44);
	        LatLng coord45 = new LatLng(best.getCity(44).getX(),best.getCity(44).getY());  
	        latLngList.add(coord45);
	        LatLng coord46 = new LatLng(best.getCity(45).getX(),best.getCity(45).getY()); 
	        latLngList.add(coord46);
	        LatLng coord47 = new LatLng(best.getCity(46).getX(),best.getCity(46).getY());  
	        latLngList.add(coord47);
	        LatLng coord48 = new LatLng(best.getCity(47).getX(),best.getCity(47).getY());  
	        latLngList.add(coord48);
	        LatLng coord49 = new LatLng(best.getCity(48).getX(),best.getCity(48).getY()); 
	        latLngList.add(coord49);
	        LatLng coord50 = new LatLng(best.getCity(49).getX(),best.getCity(49).getY());
	        latLngList.add(coord50);
	        LatLng coord51 = new LatLng(best.getCity(50).getX(),best.getCity(50).getY()); 
	        latLngList.add(coord51);
	        LatLng coord52 = new LatLng(best.getCity(51).getX(),best.getCity(51).getY()); 
	        latLngList.add(coord52);
	        LatLng coord53 = new LatLng(best.getCity(52).getX(),best.getCity(52).getY()); 
	        latLngList.add(coord53);
	        LatLng coord54 = new LatLng(best.getCity(53).getX(),best.getCity(53).getY()); 
	        latLngList.add(coord54);
	        LatLng coord55 = new LatLng(best.getCity(54).getX(),best.getCity(55).getY());
	        latLngList.add(coord55);
	        LatLng coord56 = new LatLng(best.getCity(56).getX(),best.getCity(56).getY()); 
	        latLngList.add(coord56);
	        LatLng coord57 = new LatLng(best.getCity(57).getX(),best.getCity(57).getY());
	        latLngList.add(coord57);
	        LatLng coord58= new LatLng(best.getCity(58).getX(),best.getCity(58).getY());
	        latLngList.add(coord58);
	        LatLng coord59 = new LatLng(best.getCity(59).getX(),best.getCity(59).getY()); 
	        latLngList.add(coord59);
	        LatLng coord60 = new LatLng(best.getCity(60).getX(),best.getCity(60).getY()); 
	        latLngList.add(coord60);
	        LatLng coord61 = new LatLng(best.getCity(61).getX(),best.getCity(61).getY());  
	        latLngList.add(coord61);
	        LatLng coord62 = new LatLng(best.getCity(62).getX(),best.getCity(62).getY());  
	        latLngList.add(coord62);
	        LatLng coord63 = new LatLng(best.getCity(63).getX(),best.getCity(63).getY()); 
	        latLngList.add(coord63);
	        LatLng coord64 = new LatLng(best.getCity(64).getX(),best.getCity(64).getY());  
	        latLngList.add(coord64);
	        LatLng coord65 = new LatLng(best.getCity(65).getX(),best.getCity(65).getY());  
	        latLngList.add(coord65);
	        LatLng coord66 = new LatLng(best.getCity(66).getX(),best.getCity(66).getY()); 
	        latLngList.add(coord66);
	        LatLng coord67 = new LatLng(best.getCity(67).getX(),best.getCity(67).getY());
	        latLngList.add(coord67);
	        LatLng coord68 = new LatLng(best.getCity(68).getX(),best.getCity(68).getY()); 
	        latLngList.add(coord68);
	        LatLng coord69 = new LatLng(best.getCity(69).getX(),best.getCity(69).getY());
	        latLngList.add(coord69);
	        LatLng coord70 = new LatLng(best.getCity(70).getX(),best.getCity(70).getY()); 
	        latLngList.add(coord70);
	        LatLng coord71 = new LatLng(best.getCity(71).getX(),best.getCity(71).getY());
	        latLngList.add(coord71);
	        LatLng coord72= new LatLng(best.getCity(72).getX(),best.getCity(72).getY());
	        latLngList.add(coord72);
	      
	        LatLng coord73 = new LatLng(best.getCity(73).getX(),best.getCity(73).getY()); 
	        latLngList.add(coord73);
	       
	        LatLng coord74 = new LatLng(best.getCity(74).getX(),best.getCity(74).getY()); 
	        latLngList.add(coord74);
	        LatLng coord75 = new LatLng(best.getCity(75).getX(),best.getCity(75).getY());  
	        latLngList.add(coord75);
	        LatLng coord76 = new LatLng(best.getCity(76).getX(),best.getCity(76).getY());  
	        latLngList.add(coord76);
	        LatLng coord77 = new LatLng(best.getCity(77).getX(),best.getCity(77).getY()); 
	        latLngList.add(coord77);
	        LatLng coord78 = new LatLng(best.getCity(78).getX(),best.getCity(78).getY());  
	        latLngList.add(coord78);
	        LatLng coord79 = new LatLng(best.getCity(79).getX(),best.getCity(79).getY());  
	        latLngList.add(coord79);
	        LatLng coord80 = new LatLng(best.getCity(80).getX(),best.getCity(80).getY()); 
	        latLngList.add(coord80);
	        LatLng coord81 = new LatLng(best.getCity(81).getX(),best.getCity(81).getY());
	        latLngList.add(coord81);
	       
	*/
	  
	        
	        Polyline polyline = new Polyline(); 
	       
	        new Polyline(); 
	       
	   
	        
	        polyline.getPaths().add(coord1);  
	        polyline.getPaths().add(coord2);  
	        polyline.getPaths().add(coord3);  
	    
	        polyline.getPaths().add(coord4); 
	        polyline.getPaths().add(coord5);  
	        polyline.getPaths().add(coord6);  
	        polyline.getPaths().add(coord7);  
	        polyline.getPaths().add(coord8);  
	       
	        polyline.getPaths().add(coord9);
	        polyline.getPaths().add(coord10);  
	        polyline.getPaths().add(coord11);  
	        polyline.getPaths().add(coord12);  
	        polyline.getPaths().add(coord13);
	        polyline.getPaths().add(coord14);  
	        polyline.getPaths().add(coord15);
	      
	        polyline.getPaths().add(coord16);  
	        polyline.getPaths().add(coord17); 
	        polyline.getPaths().add(coord18);  
	        polyline.getPaths().add(coord19);  
	        polyline.getPaths().add(coord20);  
	        polyline.getPaths().add(coord21);
	        polyline.getPaths().add(coord22);  
	        polyline.getPaths().add(coord23);  
	        polyline.getPaths().add(coord24);  
	        polyline.getPaths().add(coord25);
	     
	        polyline.getPaths().add(coord26);  
	        polyline.getPaths().add(coord27);  
	        polyline.getPaths().add(coord28);  
	        polyline.getPaths().add(coord29); 
	        /*
	        polyline.getPaths().add(coord30);  
	        polyline.getPaths().add(coord31);  
	        polyline.getPaths().add(coord32);  
	        polyline.getPaths().add(coord33);
	        polyline.getPaths().add(coord34);  
	        polyline.getPaths().add(coord35);  
	        polyline.getPaths().add(coord36);  
	        polyline.getPaths().add(coord37);
	        polyline.getPaths().add(coord38);  
	        polyline.getPaths().add(coord39);  
	        polyline.getPaths().add(coord40);  
	        polyline.getPaths().add(coord41); 
	        polyline.getPaths().add(coord42);  
	        polyline.getPaths().add(coord43);  
	        polyline.getPaths().add(coord44);  
	        polyline.getPaths().add(coord45);
	        polyline.getPaths().add(coord46);  
	        polyline.getPaths().add(coord47);  
	        polyline.getPaths().add(coord48);  
	        polyline.getPaths().add(coord49);
	        polyline.getPaths().add(coord50);  
	        polyline.getPaths().add(coord51);  
	        polyline.getPaths().add(coord52);  
	        polyline.getPaths().add(coord53); 
	        polyline.getPaths().add(coord54);  
	        polyline.getPaths().add(coord55);  
	        polyline.getPaths().add(coord56);  
	        polyline.getPaths().add(coord57);
	        polyline.getPaths().add(coord58);  
	        polyline.getPaths().add(coord59);  
	        polyline.getPaths().add(coord60);  
	        polyline.getPaths().add(coord61);
	        polyline.getPaths().add(coord62);  
	        polyline.getPaths().add(coord63);  
	        polyline.getPaths().add(coord64);  
	        polyline.getPaths().add(coord65); 
	        polyline.getPaths().add(coord66);  
	        polyline.getPaths().add(coord67);  
	        polyline.getPaths().add(coord68);  
	        polyline.getPaths().add(coord69);
	        polyline.getPaths().add(coord70);  
	        polyline.getPaths().add(coord71);  
	        polyline.getPaths().add(coord72); 
	       
	        
	       
	        polyline.getPaths().add(coord73);
	       
	        polyline.getPaths().add(coord74);  
	        polyline.getPaths().add(coord75);  
	        polyline.getPaths().add(coord76);  
	        polyline.getPaths().add(coord77); 
	        polyline.getPaths().add(coord78);  
	        polyline.getPaths().add(coord79);  
	        polyline.getPaths().add(coord80);  
	        polyline.getPaths().add(coord81);
	        
	   */
	        polyline.setStrokeWeight(3);  
	        polyline.setStrokeColor("#FFFFFF");  
	        polyline.setStrokeOpacity(0.9);  
	        /*
	        polyline2.setStrokeWeight(3);  
	        polyline2.setStrokeColor("#00ff00");  
	        polyline2.setStrokeOpacity(0.9);  
	        
	        polyline3.setStrokeWeight(4);  
	        polyline3.setStrokeColor("##964B00");  
	        polyline.setStrokeOpacity(0.9);  
	          
	        
	        polyline4.setStrokeWeight(3);  
	        polyline4.setStrokeColor("#c0c0c0");  
	        polyline4.setStrokeOpacity(0.9);  
	        */
	        polylineModel.addOverlay(polyline);  
	        /*
	        polylineModel.addOverlay(polyline2);  
	        polylineModel.addOverlay(polyline3);  
	        polylineModel.addOverlay(polyline4);  
	        */
	        
	       
	        for (int i = 0; i <30; i++) {
	           
	        	 tour2 =tour2+"||"+"Tur Adýmý:"+i+"__"+ best.getCity(i).getX()+","+best.getCity(i).getY();
		            
	         
	        } 
	      
	     
	     
	    }  
	   
	    public String getTour2() {
			return tour2;
		}

		public void setTour2(String tour2) {
			this.tour2 = tour2;
		}

		public MapModel getSimpleModel() {  
	        return simpleModel;  
	    }  
	    public MapModel getPolylineModel() {  
	        return polylineModel;  
	    } 
	    public void calis(){
	    	
	    	
	    }
	    	
	    	
	    	
	    
	    public void onPolylineSelect(OverlaySelectEvent event) {  
	        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Polyline Selected", null));  
	    }  
	      
	    public void addMessage(FacesMessage message) {  
	        FacesContext.getCurrentInstance().addMessage(null, message);  
	    }

	

		 // Calculate the acceptance probability
	 
	   
}
	
	                      