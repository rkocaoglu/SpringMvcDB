package com.example.springmvcdb;

import com.example.springmvcdb.mysqldb.Adress;
import com.example.springmvcdb.mysqldb.Teacher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

public class JsonSample {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Teacher teacher = mapper.readValue(ResourceUtils.getFile("classpath:teacher.json"), Teacher.class);
            Adress adress = teacher.getAdress();
            System.out.println(teacher.getId());
            System.out.println(teacher.getFirstName());
            System.out.println(teacher.getLastName());
            System.out.println("Adress:"+adress.getCity()+" "+adress.getPostalCode()+" "+adress.getCountry());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
