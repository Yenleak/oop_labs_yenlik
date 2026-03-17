public  abstract class Circuit {
    public abstract double getResistance();
    public abstract double getPotentialDiff();
    public abstract void applyPotentialDiff(double V);

    public double getCurrent() {
        return getPotentialDiff() / getResistance();
    }

    public double getPower() {
        double v = getPotentialDiff();
        return (v * v) / getResistance();
    }
}

class Resistor extends Circuit {
    private double resistance;
    private double potentialDifference;

    public Resistor(double r) {
        this.resistance = r;
    }

    @Override
    public double getResistance() { return resistance; }

    @Override
    public double getPotentialDiff() { return potentialDifference; }

    @Override
    public void applyPotentialDiff(double V) {
        this.potentialDifference = V;
    }
}


class Series extends Circuit {
    private Circuit c1, c2;
    private double v;

    public Series(Circuit c1, Circuit c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public double getResistance() {
        return c1.getResistance() + c2.getResistance();
    }

    @Override
    public void applyPotentialDiff(double V) {
        this.v = V;
        double current = this.getCurrent(); 
        c1.applyPotentialDiff(current * c1.getResistance());
        c2.applyPotentialDiff(current * c2.getResistance());
    }

    @Override
    public double getPotentialDiff() { return v; }
}


class Parallel extends Circuit {
    private Circuit c1, c2;
    private double v;

    public Parallel(Circuit c1, Circuit c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public double getResistance() {
        double r1 = c1.getResistance();
        double r2 = c2.getResistance();
        return (r1 * r2) / (r1 + r2);
    }

    @Override
    public void applyPotentialDiff(double V) {
        this.v = V;
        c1.applyPotentialDiff(V);
        c2.applyPotentialDiff(V);
    }

    @Override
    public double getPotentialDiff() { return v; }
}

 class Main {
    public static void main(String[] args) {
        Circuit a = new Resistor(3.0);
        Circuit b = new Resistor(3.0);
        Circuit c = new Resistor(6.0);
        Circuit d = new Resistor(3.0);
        Circuit e = new Resistor(2.0);

        Circuit f = new Series(a, b);         // 3 + 3 = 6.0
        Circuit g = new Parallel(c, d);       // (6*3)/(6+3) = 2.0
        Circuit h = new Series(g, e);         // 2 + 2 = 4.0
        Circuit circuit = new Parallel(h, f); // (4*6)/(4+6) = 2.4


        System.out.println("Расчет цепи");
        System.out.println("Общее сопротивление (Req): " + circuit.getResistance() + " Ohm");


        circuit.applyPotentialDiff(12.0);
        
        System.out.println("Суммарный ток (I): " + circuit.getCurrent() + " A");
        System.out.println("Суммарная мощность (P): " + circuit.getPower() + " W");
        

        System.out.println("Напряжение в секции f составляет: " + f.getPotentialDiff() + " V");
        System.out.println("Напряжение в секции h составляет: " + h.getPotentialDiff() + " V");
    }
}