package java8.StreamAPI.collectingAndThen;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 11/13/23
 */
class Ticker {
    int companyId;
    int price;
    long timestamp;

    Ticker(int companyId, int price, long timestamp) {
        this.companyId = companyId;
        this.price = price;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "companyId=" + companyId +
                ", price=" + price +
                ", timestamp=" + timestamp +
                '}';
    }

    public int getCompanyId() {
        return companyId;
    }

    public int getPrice() {
        return price;
    }

    public long getTimeStamp() {
        return timestamp;
    }
}
