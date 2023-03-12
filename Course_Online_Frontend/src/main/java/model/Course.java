package model;

import lombok.*;

import javax.xml.bind.DatatypeConverter;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    public int id;
    public String courseName;
    public String description;
    public String objective;
    public String suitable;
    public int slot;
    public int tuitionFee;
    public String imageUrl;
    public Date createDate;
    public Date startDate;
    public Date endDate;
    public boolean status;
    public Date lastUpdateDate;
    public User createBy;
    public User teacher;
    public User lastUpdateUser;
    public Set<OrderDetail> orderDetails;
    public Set<Category> categories;
    public Set<Feedback> feedbacks;


    public String getTuitionFeeFormat() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return  (formatter.format(this.tuitionFee) + " VNĐ").replace(",", ".");
    }
    public String formatDate (Date d){
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(d);
    }
    public String getStartDate(){
        return formatDate(this.startDate);
    }
    public String getEndDate(){
        return formatDate(this.endDate);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "1";
        System.out.println("My Hash: " + getHashCode(getHashCode(password)));

    }

    public static String getHashCode(String s) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(s.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }
}
