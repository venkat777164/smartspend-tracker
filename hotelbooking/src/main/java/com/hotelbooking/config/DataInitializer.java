package com.hotelbooking.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hotelbooking.model.Hotel;
import com.hotelbooking.model.Room;
import com.hotelbooking.repository.HotelRepository;
import java.util.Arrays;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner init(HotelRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                Hotel h1 = new Hotel("Seaside Hotel", "Chennai", "Marina Beach Rd",
                   "Comfortable stay near the seashore", 4.3,
                   Arrays.asList(new Room("r1","101","SINGLE",1200), new Room("r2","102","DOUBLE",2200)));
                Hotel h2 = new Hotel("City Lights Inn", "Bengaluru", "MG Road",
                   "Modern hotel in city center", 4.0,
                   Arrays.asList(new Room("r3","201","DOUBLE",1800), new Room("r4","202","SUITE",4200)));
                repo.saveAll(Arrays.asList(h1, h2));
            }
        };
    }
}
