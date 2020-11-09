package lesson4;

import java.util.Objects;

public class Seat {
    // номер ряда
    private final int row;
    // номер места
    private final int seat;


    public Seat(int row, int seat) {
        this.row = row;
        this.seat = seat;
    }

    public int getRow() {
        return this.row;
    }

    public int getSeat() {
        return this.seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat1 = (Seat) o;
        return row == seat1.row &&
                seat == seat1.seat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, seat);
    }
}
