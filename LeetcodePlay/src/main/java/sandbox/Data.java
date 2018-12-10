package sandbox;
import java.io.Serializable;

public class Data implements Serializable{

    private static final long serialVersionUID = -132202207959738724L;
    public int n;
    public Data(int n){
        this.n = n;
    }
    public String toString() {
        return Integer.toString(n);
    }
}
