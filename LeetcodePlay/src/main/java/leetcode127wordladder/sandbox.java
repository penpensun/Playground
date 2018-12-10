package leetcode127wordladder;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Sandbox implements java.io.Serializable {
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

    public Sandbox(String name, long sandboxNummer) {
        this.name = name;
        this.sandboxNummer = sandboxNummer;
    }

    @Override
    public String toString() {
        return new StringBuilder(this.name).append(" ").append(sandboxNummer).toString();
    }


    public static void serialization() throws IOException {
        Sandbox s = new Sandbox("name", 1);
        System.out.println("Sandbox initiated.");
        FileOutputStream fos = new FileOutputStream("./test-object.obj");
        ObjectOutputStream objos = new ObjectOutputStream(fos);

        objos.writeObject(s);
        objos.flush();
        objos.close();
        fos.close();
    }

    public static void deserialization () throws IOException {
        String filePath = "./test-object.obj";
        FileInputStream fin = new FileInputStream(filePath);
        ObjectInputStream objin = new ObjectInputStream(fin);
        Sandbox s = null;
        try{
            s = (Sandbox) objin.readObject();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.print("The name of the sandbox: ");
        System.out.println(s.name);
        System.out.print("The number of the sandbox: ");
        System.out.println(s.sandboxNummer);

        System.out.print("to string: ");
        System.out.println(s.toString());
    }

    public static void main(String args[]) throws IOException {
        serialization();
        deserialization();
    }
}
