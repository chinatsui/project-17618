package me.chinatsui.research.javase;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectMapperTest {

    public static void main(String[] args) throws IOException {
        Map map = new HashMap<>();

        List results = new ArrayList();
        results.add("a");
        results.add("b");
        results.add("c");

        map.put("code", results);


        String output = new ObjectMapper().writeValueAsString(map);

        String input = "[{\"key1\":\"value1\"},{\"key2\":\"value2\"}]";

        List<Map> list = new ObjectMapper().readValue(input, List.class);

        System.out.println(output);
        System.out.println(list.size());
    }

}
