package sv.com.equifax.commons.bean.das.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NEndeudamientoAmchats4Bean implements Serializable {

    public static final String CEROUNO="01";
    private static SimpleDateFormat sdfDASConvert = new SimpleDateFormat("YYYYMMdd");
    private static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
    private Date date;
    private Double value;
    private String label;
    private Long time;

    public NEndeudamientoAmchats4Bean() {
    }

    public NEndeudamientoAmchats4Bean(Date date, Double value) {
        this.date = date;
        this.value = value;
        this.time = date.getTime();
    }

    public NEndeudamientoAmchats4Bean(String strDate,Double value){
        try {
            this.date = getDate(strDate + CEROUNO);
            this.value = value;
            this.time = date.getTime();
        }catch (Exception pe){
            pe.printStackTrace();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setTime(Long time){
        this.time = time;
    }

    public Long getTime(){
        return this.date.getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NEndeudamientoAmchats4Bean that = (NEndeudamientoAmchats4Bean) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(value, that.value) &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, value, label);
    }

    @Override
    public String toString() {
        return "{\"time\":"+time+",\"value\":"+value+",\"date\":\""+sdf.format(date)+"\"}";
    }

    private static Date getDate(String strDate){
        Date r = null;
        if(strDate.length()==8) {
            Calendar calendar = new GregorianCalendar(
                    Integer.parseInt( strDate.substring(0,4)),
                    Integer.parseInt(strDate.substring(4,6)) - 1,
                    Integer.parseInt(strDate.substring(6,8)));
            r = calendar.getTime();
        }

        return r;
    }
}
