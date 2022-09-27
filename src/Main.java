import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        System.out.print("Kérem adja meg, hogy mi legyen a harcosának a neve");
        String harcosNeve = sc.nextLine();
        while(harcosNeve.equals("")){
            System.out.print("\nKérem adja meg, hogy mi legyen a harcosának a neve");
            harcosNeve = sc.nextLine();
        }
        System.out.println("\n Kérem adja meg a harcos classját (1-3):");
        int harcosClass = sc.nextInt();
        sc.nextLine();
        while(harcosClass > 3 || harcosClass <= 0){
            System.out.println("Rossz számot adott meg a szám minimum 1 maximum 3 lehet.");
            System.out.print("\n Kérem adja meg a harcos classját (1-3):");
            harcosClass = sc.nextInt();
        }
        Harcos sHarcos = new Harcos(harcosNeve,harcosClass);
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
        for (int i = 0; i < harcosok.size(); i++) {
            System.out.println(harcosok.get(i).toString());
        }
    }



}
