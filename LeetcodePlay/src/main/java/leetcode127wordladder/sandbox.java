package leetcode127wordladder;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class sandbox implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private long sandboxNummer;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSandboxNummer(long sandboxNummer){
        this.sandboxNummer = sandboxNummer;
    }

    public long getSandboxNummer(){
        return sandboxNummer;
    }

    public sandbox(String name, long sandboxNummer){
        
    }

}
