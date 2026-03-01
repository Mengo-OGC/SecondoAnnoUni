class MyTrain {
    int nTotSeats;
    int nFirstClassSeats;
    int nSecodClassSeats;
    int nFirstClassReservedSeats;
    int nSecodClassReservedSeats;

    void build(int nTotSeats, int nFirstClassSeats, int nSecodClassSeats) {
        this.nTotSeats = nTotSeats;
        this.nFirstClassSeats = nFirstClassSeats;
        this.nSecodClassSeats = nSecodClassSeats;
    }

    void reserveFirstClassSeats(int x) {
        this.nFirstClassReservedSeats = x;
    }

    void reserveSecondClassSeats(int x) {
        this.nSecodClassReservedSeats = x;
    }

    double percentuale(int x, int y) {
        return x * 100.0 / y;
    }

    double getTotOccupancyRatio() {
        return percentuale(this.nFirstClassReservedSeats + this.nSecodClassReservedSeats, this.nTotSeats);
    }

    double getFirstClassOccupancyRatio() {
        return percentuale(this.nFirstClassReservedSeats, this.nFirstClassSeats);
    }

    double getSecondClassOccupancyRatio() {
        return percentuale(this.nSecodClassReservedSeats, this.nSecodClassSeats);
    }

    void deleteAllReservations() {
        this.nFirstClassReservedSeats = 0;
        this.nSecodClassReservedSeats = 0;
    }
}