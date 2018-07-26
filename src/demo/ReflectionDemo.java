package demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * Created by maninder on 7/8/17.
 *
 */
public class ReflectionDemo {
   public Long offer_id;
    public String offer_title;
    public Integer dailyCount;
    public String extra ;
    public String another ;
    ReflectionDemo()
    {
        offer_id = 123L;
        offer_title ="demo";
        dailyCount=12;
        extra = null;
        another = "value";
    }


    private static final List<String> FIELDS = Arrays.asList("offer_id","offer_title","daily_count","extra");

    public static void main(String[] args) {
        ReflectionDemo object = new ReflectionDemo();
        String query  = "";
        for(String field : FIELDS)
        {
            try {

                Field field1 = object.getClass().getField(field);
                Object o = field1.get(object);
                String columnName  = field1.getName();
                if(o!=null)
                {
                    Annotation[] declaredAnnotations = field1.getDeclaredAnnotations();
                    if(declaredAnnotations != null){

                    }

                }
            }
            catch (Exception e)
            {

            }
        }
    }
}
