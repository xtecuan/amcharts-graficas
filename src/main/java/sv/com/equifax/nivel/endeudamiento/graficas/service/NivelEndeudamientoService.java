package sv.com.equifax.nivel.endeudamiento.graficas.service;

import org.springframework.stereotype.Service;
import sv.com.equifax.nivel.endeudamiento.graficas.model.NivelEndeudamientoDTO;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class NivelEndeudamientoService {
    private static List<NivelEndeudamientoDTO> dataBanca = new ArrayList<>();
    private static List<NivelEndeudamientoDTO> dataTarjetas = new ArrayList<>();
    private static List<NivelEndeudamientoDTO> dataComerico = new ArrayList<>();
    private static List<NivelEndeudamientoDTO> dataImf = new ArrayList<>();
    private static List<NivelEndeudamientoDTO> dataTotal = new ArrayList<>();

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/M/YYYY");



    private Date getDate(String date){
        Date result = null;
        try{
            result = sdf.parse(date);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    private Date getDate(int year,int month,int day){
        Date r = null;
        Calendar calendar = new GregorianCalendar(year,month-1,day);
        r = calendar.getTime();
        return r;
    }

    public Map<String,Object> getData(){
        Map<String,Object> result = new HashMap<>();
        List<NivelEndeudamientoDTO> banca = new ArrayList<>();
        banca.add(new NivelEndeudamientoDTO(getDate(2018,9,1),1.25));
        banca.add(new NivelEndeudamientoDTO(getDate(2018,12,1),12.25));
        banca.add(new NivelEndeudamientoDTO(getDate(2019,3,1),10.25));
        banca.add(new NivelEndeudamientoDTO(getDate(2019,6,1),11.25));
        banca.add(new NivelEndeudamientoDTO(getDate(2019,9,1),25.25));
        banca.add(new NivelEndeudamientoDTO(getDate(2019,12,1),45.25));
        banca.add(new NivelEndeudamientoDTO(getDate(2020,3,1),12.25));
        banca.add(new NivelEndeudamientoDTO(getDate(2020,6,1),15.75));
        result.put("banca",banca);

        List<NivelEndeudamientoDTO> tarjetas = new ArrayList<>();
        tarjetas.add(new NivelEndeudamientoDTO(getDate(2018,9,1),5.25));
        tarjetas.add(new NivelEndeudamientoDTO(getDate(2018,12,1),10.25));
        tarjetas.add(new NivelEndeudamientoDTO(getDate(2019,3,1),16.25));
        tarjetas.add(new NivelEndeudamientoDTO(getDate(2019,6,1),3.25));
        tarjetas.add(new NivelEndeudamientoDTO(getDate(2019,9,1),13.25));
        tarjetas.add(new NivelEndeudamientoDTO(getDate(2019,12,1),40.25));
        tarjetas.add(new NivelEndeudamientoDTO(getDate(2020,3,1),13.25));
        tarjetas.add(new NivelEndeudamientoDTO(getDate(2020,6,1),17.75));
        result.put("tarjetas",tarjetas);

        List<NivelEndeudamientoDTO> comercio = new ArrayList<>();
        comercio.add(new NivelEndeudamientoDTO(getDate(2018,9,1),3.25));
        comercio.add(new NivelEndeudamientoDTO(getDate(2018,12,1),7.25));
        comercio.add(new NivelEndeudamientoDTO(getDate(2019,3,1),8.25));
        comercio.add(new NivelEndeudamientoDTO(getDate(2019,6,1),17.25));
        comercio.add(new NivelEndeudamientoDTO(getDate(2019,9,1),28.25));
        comercio.add(new NivelEndeudamientoDTO(getDate(2019,12,1),41.25));
        comercio.add(new NivelEndeudamientoDTO(getDate(2020,3,1),11.25));
        comercio.add(new NivelEndeudamientoDTO(getDate(2020,6,1),9.75));
        result.put("comercio",comercio);

        List<NivelEndeudamientoDTO> imf = new ArrayList<>();
        imf.add(new NivelEndeudamientoDTO(getDate(2018,9,1),4.25));
        imf.add(new NivelEndeudamientoDTO(getDate(2018,12,1),6.05));
        imf.add(new NivelEndeudamientoDTO(getDate(2019,3,1),4.45));
        imf.add(new NivelEndeudamientoDTO(getDate(2019,6,1),18.55));
        imf.add(new NivelEndeudamientoDTO(getDate(2019,9,1),20.15));
        imf.add(new NivelEndeudamientoDTO(getDate(2019,12,1),33.25));
        imf.add(new NivelEndeudamientoDTO(getDate(2020,3,1),16.25));
        imf.add(new NivelEndeudamientoDTO(getDate(2020,6,1),6.75));
        result.put("imf",imf);

        List<NivelEndeudamientoDTO> total = new ArrayList<>();
        total.add(new NivelEndeudamientoDTO(getDate(2018,9,1),8.25));
        total.add(new NivelEndeudamientoDTO(getDate(2018,12,1),9.25));
        total.add(new NivelEndeudamientoDTO(getDate(2019,3,1),23.25));
        total.add(new NivelEndeudamientoDTO(getDate(2019,6,1),14.25));
        total.add(new NivelEndeudamientoDTO(getDate(2019,9,1),23.25));
        total.add(new NivelEndeudamientoDTO(getDate(2019,12,1),45.25));
        total.add(new NivelEndeudamientoDTO(getDate(2020,3,1),18.25));
        total.add(new NivelEndeudamientoDTO(getDate(2020,6,1),19.75));
        result.put("total",total);

        return result;
    }










}
