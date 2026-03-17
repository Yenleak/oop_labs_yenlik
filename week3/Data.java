public class Data {
    private double sum;
    public double maximum;
    public int count;

    public Data(){
        sum=0;
        maximum=Double.NEGATIVE_INFINITY;
        count=0;
    }

    public void Add(double number){
        sum+=number;
        count++;
        if(maximum<number) maximum=number;
    }

    public double Average(){
        if(count==0) return  0;
        return sum/count;
    }

    public double Maximum(){
        return maximum;
    }
}
