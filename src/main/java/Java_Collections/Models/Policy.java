package Java_Collections.Models;

import java.time.LocalDate;

public class Policy {
    public final String number;
    public final String holder;
    public final LocalDate expiry;
    public final String coverage;
    public final long premium;

    public Policy(String number, String holder, LocalDate expiry, String coverage, long premium) {
        this.number = number;
        this.holder = holder;
        this.expiry = expiry;
        this.coverage = coverage;
        this.premium = premium;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Policy && number.equals(((Policy) obj).number);
    }

    @Override
    public int hashCode() { return number.hashCode(); }

    @Override
    public String toString() {
        return number + " | " + holder + " | " + expiry + " | " + coverage
                + " | Premium: " + premium;
    }
}
