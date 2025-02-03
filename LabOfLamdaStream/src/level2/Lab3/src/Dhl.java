package LabOfLamdaStream.src.level2.Lab3.src;

public class Dhl extends Carier {
    PackageDetails packageDetails;

    protected Dhl(PackageDetails packageDetails) {
        this.packageDetails = packageDetails;
    }

    @Override
    public String showCostDetails(Carier carier) {
        StringBuilder result = new StringBuilder();
        result.append(((Dhl) carier).packageDetails.getPackageName());
        result.append("\t$" + "$"+computePrice(carier));
        result.append("\t"+carier.getClass().getSimpleName());
        return result.toString();
    }

    public double computePrice(Carier carier) {
        return Double.parseDouble(String.format("%.2f", ((Dhl) carier).packageDetails.getWeight() * 0.6));
    }
}
