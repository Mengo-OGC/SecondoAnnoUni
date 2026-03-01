class Calculator {
    int nOpDone;
    double lastRes;

    void build() {
        this.nOpDone = 0;
        this.lastRes = 0.0;
    }

    double add(double x, double y) {
        this.nOpDone++;
        this.lastRes = x + y;
        return lastRes;
    }
    double sub(double x, double y) {
        this.nOpDone++;
        this.lastRes = x - y;
        return lastRes;
    }
    double mul(double x, double y) {
        this.nOpDone++;
        this.lastRes = x * y;
        return lastRes;
    }
    double div(double x, double y) {
        this.nOpDone++;
        this.lastRes = x / y;
        return lastRes;
    }
}