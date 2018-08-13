package me.chinatsui.research.other;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

public class BooleanBoxingTest {

    @Test(expected = NullPointerException.class)
    public void testNullBooleanField() {
        Boolean flag = null;
        System.out.println(!flag);
    }

    @Test
    public void testPrimitiveBooleanFieldType() throws NoSuchFieldException {
        Field field = Pojo.class.getDeclaredField("isEnabled");
        field.setAccessible(true);
        Assert.assertTrue(field.getAnnotatedType().getType().equals(boolean.class));
        Assert.assertFalse(field.getAnnotatedType().getType().equals(Boolean.class));
    }

}

class Pojo {

    private boolean isEnabled;

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }
}