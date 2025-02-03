package LabOfLamdaStream.src.level2.Lab3.src;

import java.util.Scanner;

public class Application {

    /**
     * instantiating parent class using anonymous child class since Carier class is abstract
     * OR we can extend Carier and instantiate Carier class using instance of Application
     */
    /**
     * NOTE: static method only access static variables
     */
    static Carier carier = new Carier() {
        @Override
        public String showCostDetails(Carier carier) {
            return null;
        }
    };


    static String packageName;
    static double weight;
    static String zone;
    static char carierFlag;

    public static void main(String[] args) {
        Carier fedEx;
        Carier ups;
        Carier usMail;
        Carier dhl;
        System.out.println("How many packages?");
        int totalPackage = getScanner().nextInt();
        for (int i = 1; i <= totalPackage; i++) {
            askQuestion(i);
            carierFlag = getScanner().nextLine().charAt(0);
            PackageDetails pack;
            switch (carierFlag) {
                case 'f':
                    //FedEx
                    pack = new PackageDetails(packageName, weight, zone);
                    fedEx = new FedEx(pack);
                    carier.arrangeCariers(fedEx);
                    break;
                case 'u':
                    //UPS
                    pack = new PackageDetails(packageName, weight, zone);
                    ups = new Ups(pack);
                    carier.arrangeCariers(ups);
                    break;
                case 'm':
                    //UsMail
                    pack = new PackageDetails(packageName, weight, zone);
                    usMail = new UsMail(pack);
                    carier.arrangeCariers(usMail);
                    break;
                case 'd':
                    //DHL
                    pack = new PackageDetails(packageName, weight, zone);
                    dhl = new Dhl(pack);
                    carier.arrangeCariers(dhl);
                    break;
            }
        }
        carier.displayCost();
    }

    static Scanner getScanner() {
        Scanner s = new Scanner(System.in);
        return s;
    }

    static void askQuestion(int sn) {
        System.out.println("Enter package description " + sn);
        packageName = getScanner().nextLine();
        System.out.println("Enter package weight");
        weight = getScanner().nextDouble();
        System.out.println("Enter zone that package send to");
        zone = getScanner().nextLine();
        System.out.println("Enter carier name");
    }
}
