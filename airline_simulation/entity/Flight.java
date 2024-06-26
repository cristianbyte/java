package entity;

public class Flight {
    private int id;
    private String destination;
    private String departure_date;
    private String departure_time;
    private int id_airplane;
    private int airplane_capacity;
    private String model_airplane;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAirplane_capacity() {
        return airplane_capacity;
    }

    public void setAirplane_capacity(int airplane_capacity) {
        this.airplane_capacity = airplane_capacity;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public int getId_airplane() {
        return id_airplane;
    }

    public void setId_airplane(int id_airplane) {
        this.id_airplane = id_airplane;
    }

    public String getModel_airplane() {
        return model_airplane;
    }

    public void setModel_airplane(String model_airplane) {
        this.model_airplane = model_airplane;
    }

    public Flight(){}

    public Flight(int id, String destination, String departure_date, String departure_time, int id_airplane) {
        this.id = id;
        this.destination = destination;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.id_airplane = id_airplane;
    }

    public Flight(int id, String destination, String departure_date, String departure_time, int id_airplane, int airplane_capacity, String model_airplane) {
        this.id = id;
        this.destination = destination;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.id_airplane = id_airplane;
        this.airplane_capacity = airplane_capacity;
        this.model_airplane = model_airplane;
    }

    @Override
    public String toString() {
        return STR."Flight{id=\{id}, destination='\{destination}\{'\''}, departure_date='\{departure_date}\{'\''}, departure_time='\{departure_time}\{'\''}, id_airplane=\{id_airplane}, model_airplane='\{model_airplane}\{'\''}\{'}'}";
    }

    public String toString(boolean names) {
        return STR."Flight{id=\{id}, destination='\{destination}\{'\''}, departure_date='\{departure_date}\{'\''}, departure_time='\{departure_time}\{'\''}\{names ? STR.", model_airplane=\{model_airplane}" : STR.", id_airplane=\{id_airplane}"}\{'}'}";
    }
}
