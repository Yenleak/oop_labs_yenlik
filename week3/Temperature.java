public class Temperature {
    
    private double temperature;
    private char scale;

    public Temperature(){
        this.temperature=0;
        this.scale='C';
    }

    public Temperature(char scale){
        this.temperature=0;
        this.scale=scale;
    }

    public Temperature(double  temperature){
        this.temperature= temperature;
        this.scale='C';
    }

    public Temperature(double temperature, char scale){
        this.temperature=temperature;
        this.scale= scale;
    }
//цельсийге айналдыру
    public double toCelsius() {
        if (scale == 'C') return temperature;
        return 5 * (temperature - 32) / 9;
    }

//фаренгейтке айналдыру
    public double toFahrenheit() {
        if (scale == 'F') return temperature;
        return 9 * temperature / 5 + 32;
    }

    public void setScale(char scale) {
        this.scale = scale;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public void setBoth(double temperature, char scale) {
        this.temperature = temperature;
        this.scale = scale;
    }
    
    public double getTemperature() {
        return temperature;
    }

    public char getScale() {
        return scale;
    }

    public static void main(String[] args) {
        Temperature t1 = new Temperature(100, 'F');

        System.out.println("Initial temperature: " + t1.getTemperature() + " " + t1.getScale());

        double inC = t1.toCelsius();
        System.out.println("In Celsius: " + inC + " C");

        double backToF = t1.toFahrenheit();
        System.out.println("Back to Fahrenheit: " + backToF + " F");
    }
}
