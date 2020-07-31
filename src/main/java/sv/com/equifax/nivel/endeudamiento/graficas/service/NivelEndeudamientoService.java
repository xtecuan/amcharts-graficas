package sv.com.equifax.nivel.endeudamiento.graficas.service;

import org.springframework.stereotype.Service;
import sv.com.equifax.commons.bean.das.report.NEndeudamientoAmchats4Bean;
import sv.com.equifax.das.util.nendeuda.OrderUtils;
import sv.com.equifax.nivel.endeudamiento.graficas.model.NivelEndeudamientoDTO;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import org.josql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class NivelEndeudamientoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NivelEndeudamientoService.class);
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

    public Map<String,List<NEndeudamientoAmchats4Bean>> getData1(){
        Map<String,List<NEndeudamientoAmchats4Bean>> result = new HashMap<>();
        List<NEndeudamientoAmchats4Bean> banca =new ArrayList<>();
        // Banca=[{"time":1243836000000,"value":5.33, "date" : "2009-06-01"}, {"time":1259647200000,"value":4.83, "date" : "2009-12-01"}, {"time":1267423200000,"value":0.9, "date" : "2010-03-01"}]
        banca.add(new NEndeudamientoAmchats4Bean("200906",5.33 ));
        banca.add(new NEndeudamientoAmchats4Bean("200912",4.83 ));
        banca.add(new NEndeudamientoAmchats4Bean("201003",0.9 ));
        result.put("Banca",OrderUtils.orderByTime(banca));

        
        List<NEndeudamientoAmchats4Bean> tarjetas =new ArrayList<>();
        //Tarjetas=[{"time":1243836000000,"value":0.12, "date" : "2009-06-01"}, {"time":1259647200000,"value":0.09, "date" : "2009-12-01"}, {"time":1267423200000,"value":0.05, "date" : "2010-03-01"}, {"time":1251784800000,"value":0.15, "date" : "2009-09-01"}]
        tarjetas.add(new NEndeudamientoAmchats4Bean("200906",0.12 ));
        tarjetas.add(new NEndeudamientoAmchats4Bean("200912",0.09 ));
        tarjetas.add(new NEndeudamientoAmchats4Bean("201003",0.05 ));
        tarjetas.add(new NEndeudamientoAmchats4Bean("200909",0.15 ));
        result.put("Tarjetas",OrderUtils.orderByTime(tarjetas));
        

        List<NEndeudamientoAmchats4Bean> comercio =new ArrayList<>();
        //Comercio=[{"time":1243836000000,"value":0.67, "date" : "2009-06-01"}, {"time":1259647200000,"value":0.67, "date" : "2009-12-01"}, 
        //{"time":1267423200000,"value":0.0, "date" : "2010-03-01"}, {"time":1251784800000,"value":0.67, "date" : "2009-09-01"}]
        comercio.add(new NEndeudamientoAmchats4Bean("200906",0.67 ));
        comercio.add(new NEndeudamientoAmchats4Bean("200912",0.67 ));
        comercio.add(new NEndeudamientoAmchats4Bean("201003",0.00 ));
        comercio.add(new NEndeudamientoAmchats4Bean("200909",0.67 ));
        result.put("Comercio",OrderUtils.orderByTime(comercio));

        List<NEndeudamientoAmchats4Bean> imf =new ArrayList<>();
        


        List<NEndeudamientoAmchats4Bean> hipotecario =new ArrayList<>();
        //Hipotecario=[{"time":1259647200000,"value":0.9, "date" : "2009-12-01"}, {"time":1267423200000,"value":0.9, "date" : "2010-03-01"}]
        hipotecario.add(new NEndeudamientoAmchats4Bean("200912",0.9 ));
        hipotecario.add(new NEndeudamientoAmchats4Bean("201003",0.9 ));
        result.put("Hipotecario",OrderUtils.orderByTime(hipotecario));

        List<NEndeudamientoAmchats4Bean> total =new ArrayList<>();
        total.addAll(banca);
        total.addAll(tarjetas);
        total.addAll(comercio);
        total.addAll(hipotecario);
        
        total = OrderUtils.summarizeSeries(total);
        if(!total.isEmpty()){
            result.put("Total", total);
        }

        return result;
       
    }

}
