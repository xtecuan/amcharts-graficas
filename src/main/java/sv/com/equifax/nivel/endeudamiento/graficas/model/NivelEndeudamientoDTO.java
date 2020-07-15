package sv.com.equifax.nivel.endeudamiento.graficas.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


public class NivelEndeudamientoDTO implements Serializable {

    private Date periodo;
    private Double valor;
}
