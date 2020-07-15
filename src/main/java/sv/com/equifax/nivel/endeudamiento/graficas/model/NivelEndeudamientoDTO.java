package sv.com.equifax.nivel.endeudamiento.graficas.model;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public class NivelEndeudamientoDTO implements Serializable {
    private static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
    private Date date;
    private Double value;
    private String label;
    private Long time;

    public NivelEndeudamientoDTO() {
    }

    public NivelEndeudamientoDTO(Date date, Double value) {
        this.date = date;
        this.value = value;
        this.time = date.getTime();
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
        NivelEndeudamientoDTO that = (NivelEndeudamientoDTO) o;
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
        return "{\"time\":"+time+",\"value\":"+value+", \"date\" : \""+sdf.format(date)+"\"}";
    }
}
