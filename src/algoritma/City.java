/*
* City.java
* Models a city
*/

package algoritma;

public class City {
    double x;
    double y;

    // kurucu fonksiyon(Rastgele secilen sehir) 
    public City(){
        this.x = (double)(Math.random()*200);
        this.y = (double)(Math.random()*200);
    }

    //  kurucu fonksiyon(X,y kordinatlar�nda secilen sehir)
    public City(double x, double y){
        this.x = x;
        this.y = y;
    }

    // X kordinatlar�n� getir
    public double getX(){
        return this.x;
    }

    // Y kordinatlar�n� getir
    public double getY(){
        return this.y;
    }

    // Sehirler aras� mesafeyi hesapla
    public double distanceTo(City city){
        double xDistance = (Math.abs(getX() - city.getX()))/111;
        double yDistance = (Math.abs(getY() - city.getY()))/111;
        double distance = (Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) ))*25;

        return distance;
    }

    @Override
    public String toString(){
        return getX()+", "+getY();
    }
}