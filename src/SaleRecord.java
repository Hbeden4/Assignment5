
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaleRecord {
    private Date date;
    private String salesperson;
    private String customerName;
    private String carMake;
    private String carModel;
    private int carYear;
    private double salePrice;
    private double commissionRate;
    private double commissionEarned;

    public SaleRecord(Date date, String salesperson, String customerName, String carMake, String carModel,
                      int carYear, double salePrice, double commissionRate, double commissionEarned) {
        this.date = date;
        this.salesperson = salesperson;
        this.customerName = customerName;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carYear = carYear;
        this.salePrice = salePrice;
        this.commissionRate = commissionRate;
        this.commissionEarned = commissionEarned;
    }

    public Date getDate() {
        return date;
    }

    public String getCarMake() {
        return carMake;
    }
}
