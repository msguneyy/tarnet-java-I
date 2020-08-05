package com.tarnet.managers;

import com.tarnet.MenuItem;
import com.tarnet.entity.Personel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EntityManager {
    // list
    // findById
    // findByKeyword
   public void list(List<Personel> personel){
       personel
               .stream()
               .forEach(System.out::println);
   }
   public  void findById(List<Personel> personel, int id){
       personel
               .stream()
               .filter(p -> p.getId() == id)
               .forEach(System.out::println);
   }
    public  void findByKey(List<Personel> personel, String  key){
        personel
                .stream()
                .filter(p -> p.getFirstName().equals(key))
                .forEach(System.out::println);
    }

}
