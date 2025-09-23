class ComplexNumCalculator {
    int nOpDone;
    ComplexNum lastRes;

    void build(){
        this.nOpDone = 0;
        this.lastRes = null;
    }

    ComplexNum add(ComplexNum x , ComplexNum y) {
        this.nOpDone++;
        this.lastRes.re = x.re + y.re;
        this.lastRes.im = x.im + y.im;
        return this.lastRes;    
    }

    ComplexNum sub(ComplexNum x, ComplexNum y) {
        this.nOpDone++;
        this.lastRes.re = x.re - y.re;
        this.lastRes.im = x.im - y.im;
        return this.lastRes;
    }

    ComplexNum mul(ComplexNum x , ComplexNum y) {
        this.nOpDone++;
        this.lastRes.re = x.re * y.re - x.im * y.im;
        this.lastRes.im = x.re * y.im + x.im * y.re;
        return this.lastRes;
    }

    ComplexNum div(ComplexNum x, ComplexNum y) {
        this.nOpDone++;
        this.lastRes.re = (x.re * y.re + x.im * y.im) / (y.re * y.re + y.im * y.im);
        this.lastRes.im = (x.im * y.re + x.re * y.im) / (y.re * y.re + y.im * y.im);
        return this.lastRes;
    }
}