package me.chinatsui.research.other;

import java.util.Optional;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class OptionalTest {

    @Test
    public void test_basic_usage() {
        UUID id = null;
        Optional<UUID> opId = Optional.ofNullable(id);
        Assert.assertEquals("Optional.empty", opId.toString());

        String name = "abc";
        Optional<String> opName = Optional.<String>of(name);
        Assert.assertEquals("Optional[abc]", opName.toString());

        UUID userId = null;

        String userIdStr = Optional.ofNullable(userId).map(UUID::toString).orElse(null);
        Assert.assertNull(userIdStr);

        Object obj = Optional.ofNullable(userId).map(UUID::toString);
        Assert.assertTrue(obj instanceof Optional);
    }

    @Test
    public void test_if_present() {
        Foo foo = new Foo();

        Inner inner = new Inner();
        inner.setFoo(foo);

        Nested nested = new Nested();
//        nested.setInner(inner);

        Outer outer = new Outer();
        outer.setNested(nested);

        Optional.of(outer)
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(f -> System.out.println(f.getName()));
    }

    @Test
    public void test_mapper() {
        Optional.ofNullable("1")
                .map(e -> null)
                .map(e -> get999());
    }

    @Test
    public void test_orElse() {
        Optional.ofNullable("1")
                .map(e -> null)
                .map(e -> get999())
                .orElse(get999());
    }

    @Test
    public void test_orElseGet() {
        Optional.ofNullable("10").orElseGet(() -> {
            get999();
            return "";
        });
    }

    private String get999() {
        System.out.println("Hello World!");
        return "999";
    }

    static class Outer {
        Nested nested;

        public Nested getNested() {
            return nested;
        }

        public void setNested(Nested nested) {
            this.nested = nested;
        }
    }

    static class Nested {
        Inner inner;

        public Inner getInner() {
            return inner;
        }

        public void setInner(Inner inner) {
            this.inner = inner;
        }
    }

    static class Inner {
        Foo foo;

        public Foo getFoo() {
            return foo;
        }

        public void setFoo(Foo foo) {
            this.foo = foo;
        }
    }

    static class Foo {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
