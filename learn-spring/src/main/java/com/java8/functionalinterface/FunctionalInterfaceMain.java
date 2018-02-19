package com.java8.functionalinterface;

public class FunctionalInterfaceMain {

    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer convert = converter.convert("100");
        System.out.println(convert);

        Something something = new Something();
        Converter<String, String> stringToStringConverter = something::startsWith;
        String converted = stringToStringConverter.convert("Java");
        System.out.println(converted);

        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Jan", "Kowalski");

        final int num = 1;
        Converter<Integer, String> stringConverter = (from)-> String.valueOf(from + num);

        System.out.println(
                stringConverter.convert(2));

    }

    static class Lambda4 {
        static int outerStaticNum;
        int outerNum;

        void testScopes() {
            Converter<Integer, String> stringConverter1 = (from) -> {
                outerNum = 23;
                return String.valueOf(from);
            };

            Converter<Integer, String> stringConverter2 = (from) -> {
                outerStaticNum = 72;
                return String.valueOf(from);
            };
        }
    }
}
