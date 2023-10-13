package SaleRecord;
import java.util.Date;

public class SaleRecord {
    private Date date;
    private String carMake;
    public SaleRecord(Date date, String salesperson, String customerName, String carMake, String carModel,
                      int carYear, double salePrice, double commissionRate, double commissionEarned) {
        this.date = date;
        this.carMake = carMake;
    }

    public Date getDate() {
        return date;
    }

    public String getCarMake() {
        return carMake;
    }
}
