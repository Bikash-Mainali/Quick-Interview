package LabOfLamdaStream.src.level2.Lab3.src;

public class Ups extends Carier {
    PackageDetails packageDetails;

    public Ups(PackageDetails packageDetails) {
        this.packageDetails = packageDetails;
    }
    @Override
    public String showCostDetails(Carier carier) {
        StringBuilder result = new StringBuilder();
        result.append(((Ups) carier).packageDetails.getPackageName());
        result.append("\t" + "$"+computePrice(carier));
        result.append("\t"+carier.getClass().getSimpleName());
        return result.toString();
    }
    public double computePrice(Carier carier) {
        //System.out.println(packageDetails.getWeight() * 0.45);
        return Double.parseDouble(String.format("%.2f",((Ups) carier).packageDetails.getWeight() * 0.45));
    }
}
