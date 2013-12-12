/*
* Tour.java
* Stores a candidate tour through all cities
*/

package algoritma;

import java.util.ArrayList;
import java.util.Collections;

import javax.faces.bean.ManagedBean;
@ManagedBean(name="Tour")
public class Tour{

	private String geneString = "|";
    public String getGeneString() {
		return geneString;
	}

	public void setGeneString(String geneString) {
		this.geneString = geneString;
	}

	// Sehirlerimizin turlarýný tutan arraylist.
    private ArrayList tour = new ArrayList();
    // Cache
    private int distance = 0;

    // Constructs oluþtur(boþ)
    public Tour(){
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
            tour.add(null);
        }
    }

   
    public Tour(ArrayList tour){
        this.tour = (ArrayList) tour.clone();
    }

    // tour bilgileirin döndürür
    public ArrayList getTour(){
        return tour;
    }

    public void setTour(ArrayList tour) {
		this.tour = tour;
	}

	// Random þehirleri atar
    public void generateIndividual() {
        // atama iþlemleri yapýyorum
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
            setCity(cityIndex, TourManager.getCity(cityIndex));
        }
        // Shuffle ile þehirleri düzenler
        Collections.shuffle(tour);
    }

    // Tourdaki þehirleri get metoduyla getirir
    public City getCity(int tourPosition) {
        return (City)tour.get(tourPosition);
    }

    // Tourdaki þehirleri set eder
    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
        // tour deðiþince deðerleri tekrar kullanmak için sýfýrlar
        distance = 0;
    }

    // Toplam distanse getirir
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            // Tour þehirlerini döngüye sokuyor.
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
               
                City fromCity = getCity(cityIndex);
              
                City destinationCity;
                
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                // Get the distance between the two cities
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    //tour sayýsýný getirir
    public int tourSize() {
        return tour.size();
    }

    @Override
    public String toString() {
        
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }
}