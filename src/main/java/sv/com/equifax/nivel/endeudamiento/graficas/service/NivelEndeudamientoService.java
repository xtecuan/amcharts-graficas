package sv.com.equifax.nivel.endeudamiento.graficas.service;

import org.springframework.stereotype.Service;
import sv.com.equifax.nivel.endeudamiento.graficas.model.NivelEndeudamientoDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class NivelEndeudamientoService {
    private static List<NivelEndeudamientoDTO> dataBanca = new ArrayList<>();
    private static List<NivelEndeudamientoDTO> dataTarjetas = new ArrayList<>();
    private static List<NivelEndeudamientoDTO> dataComerico = new ArrayList<>();
    private static List<NivelEndeudamientoDTO> dataImf = new ArrayList<>();
    private static List<NivelEndeudamientoDTO> dataTotal = new ArrayList<>();

    private static final int CURRENT_YEAR=2020;
    private static final int CURRENT_MONTH=7;
    private static final int START_YEAR=2019;


}
