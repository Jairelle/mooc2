package FlightControl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Logic {

    private Map<String, Airplane> airplanes;
    private List<Flight> flights;

    public Logic() {
        this.airplanes = new LinkedHashMap<>();
        this.flights = new ArrayList<>();
    }

    public void addAirplane(String id, int capacity) {
        this.airplanes.put(id, new Airplane(id, capacity));
    }

    public void addFlight(String airplaneId, String departure, String target) {
        Airplane airplane = this.airplanes.get(airplaneId);
        if (airplane == null) {
            return;
        }

        this.flights.add(new Flight(airplane, departure, target));
    }

    public Collection<Airplane> getAirplanes() {
        return this.airplanes.values();
    }

    public List<Flight> getFlights() {
        return this.flights;
    }

    public Airplane getAirplane(String id) {
        return this.airplanes.get(id);
    }
}
