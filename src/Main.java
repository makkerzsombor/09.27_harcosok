import java.io.*;
import java.util.ArrayList;

public class Main {

    static ArrayList<Harcos> harcosok = new ArrayList<>();
    public static void main(String[] args) {

        try {
            fel2b("harcosok.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        kiir();

    }
    public static void fel2b(String fileName) throws IOException {
        harcosok = new ArrayList<>();
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while(sor != null && !sor.equals("")){
            String[] tomb = sor.split(";");
            Harcos harcos = new Harcos(tomb[0],Integer.valueOf(tomb[1]));
            harcosok.add(harcos);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }

    public static void kiir(){
        harcosok.toString();
    }

}
