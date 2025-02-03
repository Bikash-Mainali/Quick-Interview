package LabOfLamdaStream.src.level2.Lab3.src;

public class PackageDetails {

    String packageName;
    double weight;
    String zone;

    public String getPackageName() {
        return packageName;
    }


    public double getWeight() {
        return weight;
    }

    public String getZone() {
        return zone;
    }

    public PackageDetails(String packageName, double weight, String zone) {
        this.packageName = packageName;
        this.weight = weight;
        this.zone = zone;
    }
}
