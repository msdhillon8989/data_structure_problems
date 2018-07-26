package demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by maninder on 9/5/17.
 */
public class PassDataType {
    static class Data{
        public Date date;
        public Integer age;
        public int age1;

        public Long id;
        public Long anotherLong;
        public Double rate;
        public String data;
        public Timestamp timestamp ;

        public Data(Date date, Integer age, Long id, Double rate, String data) {
            this.date = date;
            this.age = age;
            age1=age;
            this.id = id;
            this.rate = rate;
            this.data = data;
            anotherLong=908l;
            timestamp = new Timestamp(date.getTime());
        }
        public Data(){}
    }

    public static void main(String[] args) throws IllegalAccessException {
        String DATE = Date.class.getCanonicalName();
        String STRING = String.class.getCanonicalName();
        String TIMESTAMP = Timestamp.class.getCanonicalName();
        String LONG = Long.class.getCanonicalName();
        String DOUBLE = Double.class.getCanonicalName();
        String FLOAT = Float.class.getCanonicalName();
        String INTEGER = Integer.class.getCanonicalName();
        String INT_TYPE = "int";
        String DOUBLE_TYPE = "double";
        String FLOAT_TYPE = "float";
        String LONG_TYPE = "long";



        Data d = new Data(new Date(),23,435L,22.33,"maninder");

        ObjectNode node = JsonNodeFactory.instance.objectNode();
        Field[] fields = d.getClass().getDeclaredFields();
        for(Field f : fields)
        {

            ObjectNode child = node.with(f.getType().getCanonicalName());
            if(child==null)
            {
                child = JsonNodeFactory.instance.objectNode();
                node.putPOJO(f.getType().getCanonicalName(),child);
            }
            child.putPOJO(f.getName(),f.get(d));

        }

        System.out.println(node.toString());

        Data d2 = new Data();
        Iterator<String> keys =  node.fieldNames();
        while (keys.hasNext())
        {
            String key = keys.next();
            JsonNode dataNode = node.get(key);
            Iterator<String> jsonFields = dataNode.fieldNames();
            while(jsonFields.hasNext()) {
                try {
                    String jsonField = jsonFields.next();
                    System.out.println(key);
                    switch (key) {
                        case "STRING":
                            System.out.println("String " + dataNode.get(jsonField).asText());
                    }

                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                }
            }

        }

    }
}
