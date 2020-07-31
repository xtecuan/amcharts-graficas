package sv.com.equifax.das.util.nendeuda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import org.josql.*;
import sv.com.equifax.commons.bean.das.report.NEndeudamientoAmchats4Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import java.util.Date;
public class OrderUtils {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderUtils.class);

    public static List<NEndeudamientoAmchats4Bean> orderByTime(List<NEndeudamientoAmchats4Bean> list){
        List<NEndeudamientoAmchats4Bean> r = new ArrayList<>();
        Query q = new Query ();
        try{
            q.parse ("SELECT * FROM sv.com.equifax.commons.bean.das.report.NEndeudamientoAmchats4Bean ORDER BY  time ASC");
            QueryResults qr = q.execute (new ArrayList<NEndeudamientoAmchats4Bean> (list));
            //System.out.println(qr.getResults());
            r=qr.getResults();
        }catch(Exception e){
            LOGGER.error("Error ordering Graph serie collection: ", e);
        }
        return r;
    }

    public static List<NEndeudamientoAmchats4Bean> summarizeSeries(List<NEndeudamientoAmchats4Bean> list){
        List<NEndeudamientoAmchats4Bean> r = new ArrayList<>();
        
        Map<Long,Double> sum = list.stream().collect(
                Collectors.groupingBy(NEndeudamientoAmchats4Bean::getTime, 
                Collectors.summingDouble(NEndeudamientoAmchats4Bean::getValue)));
        for(Long key: sum.keySet()){
            r.add(new NEndeudamientoAmchats4Bean(new Date(key),sum.get(key)));
        }
        r = orderByTime(r);
        return r;
    }
}