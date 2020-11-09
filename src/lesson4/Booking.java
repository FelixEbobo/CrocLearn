package lesson4;

public class Booking implements Runnable{

    public static ShowTime showTime;

    public Booking(ShowTime setShowTime) {
        showTime = setShowTime;
    }

    @Override
    public void run() {
        synchronized (showTime) {
            for (int i = 1; i <= showTime.getCinemaRows(); i++) {
                for (int j = 1; j <= showTime.getCinemaRowSeats(); j++) {
                    bookSeat(i, j);
                }
            }
        }
    }

    public void bookSeat(int rowNumber, int seatNumber) {
        if (showTime.bookSeat(new Seat(rowNumber, seatNumber))) {
            System.out.printf("You booked a seat at %s row, %s seat!\n", rowNumber, seatNumber);
        } else {
            System.out.printf("You can't booked a seat at %s row, %s seat, " +
                    "because it's already booked!\n", rowNumber, seatNumber);
        }
    }

    public static void main(String[] args) {
        var cinemaObj = new Cinema("Жожо Референсы", 5, 5);
        var cinemaShowTime = new ShowTime(cinemaObj);

        Thread person1 = new Thread(new Booking(cinemaShowTime));
        person1.setName("Джотаро");
        Thread person2 = new Thread(new Booking(cinemaShowTime));
        person2.setName("Дио");

        person1.start();
        person2.start();
    }

}
