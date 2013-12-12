package algoritma;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


public class SimulatedAnnealing {
	

    // Baslangýc sýcaklýgýný ata
 // public  double temp = 5000;

    // Soðuma katsayýsý
 //  public  double coolingRate = 0.003;

    // Kabul edeilebilirliði hesapla
    public static double acceptanceProbability(int engery, int newEngery, double temperature) {
        // If the new solution is better, accept it
        if (newEngery < engery) {
            return 1.0;
        }
        // Yeni çözüm kötü ise kabul edilebilirligini hesapla
        return Math.exp((engery - newEngery) / temperature);
    }

    public static void main(String[] args) {
        //  Sehirleri olustur
        City city = new City(35.33,53.00);
        TourManager.addCity(city);
        City city2 = new City(38.28,52.23);
        TourManager.addCity(city2);
        City city3 = new City(30.55,51.23);
        TourManager.addCity(city3);
        City city4 = new City(30.55,51.23);
        TourManager.addCity(city4);
        City city5 = new City(35.83,49.33);
        TourManager.addCity(city5);
        City city6 = new City(32.85,50.05);
        TourManager.addCity(city6);
        City city7 = new City(30.70,53.10);
        TourManager.addCity(city7);
        City city8 = new City(41.83,48.80);
        TourManager.addCity(city8);
        City city9 = new City(27.83,52.17);
        TourManager.addCity(city9);
        City city10 = new City(27.87,50.35);
        TourManager.addCity(city10);
        City city11 = new City(29.98,49.85);
        TourManager.addCity(city11);
        City city12 = new City(40.48,51.12);
        TourManager.addCity(city12);
        City city13 = new City(42.10,51.63);
        TourManager.addCity(city13);
        City city14 = new City(31.62,49.27);
        TourManager.addCity(city14);
        City city15 = new City(30.27,52.28);
        TourManager.addCity(city15);
        City city16 = new City(29.03,49.82);
        TourManager.addCity(city16);
        City city17 = new City(26.42,49.87);
        TourManager.addCity(city17);
        City city18 = new City(33.61,49.40);
        TourManager.addCity(city18);
        City city19 = new City(34.95,49.45);
        TourManager.addCity(city19);
       City city20 = new City(29.07,52.23);
        TourManager.addCity(city20);

        // Set initial temp
        double temp = 10000;

        // Cooling rate
        double coolingRate = 0.003;

        // Initialize intial solution
        Tour currentSolution = new Tour();
        currentSolution.generateIndividual();

        System.out.println("Initial solution distance: " + currentSolution.getDistance());

        // Set as current best
    Tour best = new Tour(currentSolution.getTour());

        // Loop until system has cooled
        while (temp > 1) {
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
            if (acceptanceProbability(currentEngery, neighbourEngery, temp) > Math.random()) {
                currentSolution = new Tour(newSolution.getTour());
            }

            // Keep track of the best solution found
            if (currentSolution.getDistance() < best.getDistance()) {
                best = new Tour(currentSolution.getTour());
            }

            // Cool system
            temp *= 1-coolingRate;
        }

        System.out.println("Final solution distance: " + best.getDistance());
        System.out.println("Tour: " + best);
    }
}