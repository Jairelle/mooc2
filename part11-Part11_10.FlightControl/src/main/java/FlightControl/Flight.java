package FlightControl;

public class Flight {

    private Airplane airplane;
    private String departureAirport;
    private String targetAirport;

    public Flight(Airplane airplane, String departureAirport, String targetAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.targetAirport = targetAirport;
    }

    public Airplane getAirplane() {
        return this.airplane;
    }

    @Override
    public String toString() {
        return this.airplane + " (" + this.departureAirport + "-" + this.targetAirport + ")";
    }
}
