
public class Complex {
    public double x,y;
    public Complex(double x,double y){
        this.x=x;
        this.y=y;
    }
    public Complex(String s1,String s2)throws NumberFormatException
    {
        this.parseComplex(s1,s2);
    }
    public void parseComplex(String s1,String s2) throws NumberFormatException
    {

            x=Double.parseDouble(s1);
            y=Double.parseDouble(s2);
    }
    public Complex add(Complex c)
    {
        return new Complex(x+c.x,y+c.y);
    }
    public Complex minus(Complex c)
    {
        return new Complex(x-c.x,y-c.y);
    }
    public Complex mult(Complex c){
        return new Complex(x*c.x-y*c.y,x*c.y+y*c.x);
    }
    public Complex dev(Complex c){
        double p = c.x*c.x+c.y*c.y;
        return new Complex((x*c.x+y*c.y)/p,(x*c.y-y*c.x)/p);
    }


}