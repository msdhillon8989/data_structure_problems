package reflections;

import java.lang.reflect.Field;
import java.util.Date;

public class MergeObjects {
    public static void main(String[] args) {
        DataObject object1 = new DataObject(3L, "Maninder", null, "Address",new Date());
        DataObject object2 = new DataObject(3L, null, "8660320660", null,null);

        DataObject updated = (DataObject) mergeObject(object1, object2);

        System.out.println(updated.toString());
    }

    private static Object mergeObject(Object dbObject, Object updates) {

        Field[] declaredFields = updates.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                Object value = field.get(updates);
                if (value == null) {
                    field.set(updates, field.get(dbObject));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return updates;
    }
}



