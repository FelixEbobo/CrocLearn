package lesson4;

import java.util.LinkedHashSet;
import java.util.Set;

public class ShowTime {

    private LinkedHashSet<Seat> freeSeats = new LinkedHashSet<>();
    private Cinema cinema;

    public ShowTime(Cinema cinema) {
        this.cinema = cinema;
        generateFreeSeats();
    }

    public Set<Seat> getFreeSeats() {
        return freeSeats;
    }

    // бронирует место на текущий сеанс;
    // возвращает true, если место успешно забронировано
    // или false, если бронирование не удалось
    // (кто-то успел раньше)
    public boolean bookSeat(Seat seat) {
        if (checkSeat(seat)) {
            freeSeats.remove(seat);
//            System.out.println("Booked!");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check in freeSeats Set if there's a free set matching specified Seat
     * @param seat object that you want to check
     * @return true if Seat is free otherwise false
     */
    private boolean checkSeat(Seat seat) {
        for (Seat freeSeat: freeSeats) {
            if (freeSeat.equals(seat)) {
                return true;
            }
        }
        return false;
    }

    private void generateFreeSeats() {
        for (int i = 1; i <= this.cinema.getRowsNumber(); i++) {
            for (int j = 1; j <= this.cinema.getSeatsRowNumber(); j++) {
                freeSeats.add(new Seat(i, j));
            }
        }
    }

    public int getCinemaRows() {
        return cinema.getRowsNumber();
    }

    public int getCinemaRowSeats() {
        return cinema.getSeatsRowNumber();
    }

    // Test function. not for production
    public void testFreeSeats() {
        for (Seat seat: freeSeats) {
            System.out.println(seat.getRow() + " | " + seat.getSeat());
        }
//        System.out.println(freeSeats);
    }
}
