
import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning 
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LicensePlate)) {
            return false;
        }
        LicensePlate otherPlate = (LicensePlate) object;
        return this.liNumber.equals(otherPlate.liNumber) &&
               this.country.equals(otherPlate.country);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.liNumber == null ? 0 : this.liNumber.hashCode());
        hash = 31 * hash + (this.country == null ? 0 : this.country.hashCode());
        return hash;
    }
}
