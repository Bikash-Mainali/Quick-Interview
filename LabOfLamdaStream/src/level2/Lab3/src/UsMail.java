package LabOfLamdaStream.src.level2.Lab3.src;

public class UsMail extends Carier {
    PackageDetails packageDetails;

    public UsMail(PackageDetails packageDetails) {
        this.packageDetails = packageDetails;
    }

    @Override
    public String showCostDetails(Carier carier) {
        StringBuilder result = new StringBuilder();
        result.append(((UsMail) carier).packageDetails.getPackageName());
        result.append("\t" + "$"+computePrice(carier));
        result.append("\t"+carier.getClass().getSimpleName());
        return result.toString();
    }

    public double computePrice(Carier carier) {
        double cost = 0;
        if (packageDetails.getWeight() < 3) {
            //System.out.println("$" + 1.00);
            cost = 1.00;
        } else {
            //System.out.println(String.format("%.2f", packageDetails.getWeight() * 0.55));
            cost = Double.parseDouble(String.format("%.2f", ((UsMail) carier).packageDetails.getWeight() * 0.55, 2));
        }
        return cost;
    }
}
