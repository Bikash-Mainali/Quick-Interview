package LabOfLamdaStream.src.level2.Lab3.src;

public class FedEx extends Carier {

    PackageDetails packageDetails;

    public FedEx(PackageDetails packageDetails) {
        this.packageDetails = packageDetails;
    }
    @Override
    public String showCostDetails(Carier carier) {
        StringBuilder result = new StringBuilder();
        result.append(((FedEx) carier).packageDetails.getPackageName());
        result.append("\t" + "$"+computePrice(carier));
        result.append("\t"+carier.getClass().getSimpleName());
        return result.toString();
    }

    public double computePrice(Carier carier) {
        double cost = 0;
        switch (packageDetails.getZone()) {
            case "IA":
            case "MT":
            case "OR":
            case "CA":
                //System.out.println(0.35 * packageDetails.getWeight());
                cost = Double.parseDouble(String.format("%.2f",0.35 * ((FedEx) carier).packageDetails.getWeight()));
                break;
            case "TX":
            case "UT":
                //System.out.println(0.30 * packageDetails.getWeight());
                cost = Double.parseDouble(String.format("%.2f",0.30 * ((FedEx) carier).packageDetails.getWeight()));
                break;
            case "FL":
            case "MA":
            case "OH":
                //System.out.println(0.55 * packageDetails.getWeight());
                cost = Double.parseDouble(String.format("%.2f",0.55 * ((FedEx) carier).packageDetails.getWeight()));
                break;
            default:
                //System.out.println(0.43 * packageDetails.getWeight());
                cost = Double.parseDouble(String.format("%.2f",0.43 * ((FedEx) carier).packageDetails.getWeight()));
        }
        return cost;
    }
}
