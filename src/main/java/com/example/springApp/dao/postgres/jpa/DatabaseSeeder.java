package com.example.springApp.dao.postgres.jpa;

import com.example.springApp.model.ConservationStatus;
import com.example.springApp.model.Continent;
import com.example.springApp.model.Diet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Configuration
public class DatabaseSeeder {
    @Bean
    CommandLineRunner commandLineRunner(BirdRepository birdRepository){
        return args -> {
            if (birdRepository.findAll().isEmpty()) {
                birdRepository.saveAll(List.of(
                        new BirdEntity(
                                UUID.randomUUID(),
                                "Northern Cardinal",
                                "Cardinal Cardinalis",
                                28,
                                ConservationStatus.LEAST_CONCERN,
                                Diet.HERBIVORES,
                                "https://a57.foxnews.com/static.foxnews.com/foxnews.com/content/uploads/2023/10/1200/675/cardinal-on-tree-branch.jpg?ve=1&tl=1",
                                new ArrayList<>(List.of("Red")),
                                new ArrayList<>(List.of(Continent.NORTH_AMERICA))
                        ),
                        new BirdEntity(
                                UUID.randomUUID(),
                                "Bald Eagle",
                                "Haliaeetus leucocephalus",
                                203,
                                ConservationStatus.LEAST_CONCERN,
                                Diet.CARNIVOROUS,
                                "https://peregrinefund.org/sites/default/files/styles/raptor_banner_600x430/public/2019-11/raptor-er-bald-eagle-portrait-screaming-james-bodkin.jpg?itok=ruN52TUp",
                                new ArrayList<>(List.of("Brown", "White")),
                                new ArrayList<>(List.of(Continent.NORTH_AMERICA))
                        ),
                        new BirdEntity(
                                UUID.randomUUID(),
                                "European Robin",
                                "Erithacus rubecula",
                                22,
                                ConservationStatus.LEAST_CONCERN,
                                Diet.HERBIVORES,
                                "https://a-z-animals.com/media/2022/02/European-Robin-header.jpg",
                                new ArrayList<>(List.of("Brown", "White", "Orange")),
                                new ArrayList<>(List.of(Continent.EUROPE, Continent.AFRICA, Continent.ASIA))
                        ),
                        new BirdEntity(
                                UUID.randomUUID(),
                                "African Grey Parrot",
                                "Psittacus erithacus",
                                46,
                                ConservationStatus.ENDANGERED,
                                Diet.HERBIVORES,
                                "https://www.thehappychickencoop.com/wp-content/uploads/2022/07/African-Grey-Parrot.jpg",
                                new ArrayList<>(List.of("Grey")),
                                new ArrayList<>(List.of(Continent.AFRICA))
                        ),
                        new BirdEntity(
                                UUID.randomUUID(),
                                "Ruby-throated Hummingbird",
                                "Archilochus colubris",
                                10,
                                ConservationStatus.LEAST_CONCERN,
                                Diet.HERBIVORES,
                                "https://www.allaboutbirds.org/guide/assets/og/75367911-1200px.jpg",
                                new ArrayList<>(List.of("Green", "Red")),
                                new ArrayList<>(List.of(Continent.NORTH_AMERICA))
                        ),
                        new BirdEntity(
                                UUID.randomUUID(),
                                "Peregrine Falcon",
                                "Falco peregrinus",
                                95,
                                ConservationStatus.LEAST_CONCERN,
                                Diet.CARNIVOROUS,
                                "https://www.nwf.org/-/media/NEW-WEBSITE/Shared-Folder/Wildlife/Birds/bird_peregrine-falcon_600x300.ashx",
                                new ArrayList<>(List.of("Brown")),
                                new ArrayList<>(List.of(
                                        Continent.EUROPE,
                                        Continent.NORTH_AMERICA,
                                        Continent.SOUTH_AMERICA,
                                        Continent.ASIA,
                                        Continent.AFRICA,
                                        Continent.AUSTRALIA
                                ))
                        ),
                        new BirdEntity(
                                UUID.randomUUID(),
                                "Emperor Penguin",
                                "Aptenodytes forsteri",
                                122,
                                ConservationStatus.NEAR_THREATENED,
                                Diet.HERBIVORES,
                                "https://media-cldnry.s-nbcnews.com/image/upload/t_nbcnews-fp-1200-630,f_auto,q_auto:best/rockcms/2023-08/230821-emperor-penguins-jm-1317-b4b87e.jpg",
                                new ArrayList<>(List.of("Black", "White", "Yellow")),
                                new ArrayList<>(List.of(Continent.ANTARCTICA))
                        ),
                        new BirdEntity(
                                UUID.randomUUID(),
                                "Blue Jay",
                                "Cyanocitta cristata",
                                30,
                                ConservationStatus.LEAST_CONCERN,
                                Diet.HERBIVORES,
                                "https://images.birdfact.com/production/where-do-blue-jays-live.jpg?w=800&h=418&q=82&auto=format&fit=crop&dm=1646403968&s=8745cfeb979d785fe7a8030eef4a6fa5",
                                new ArrayList<>(List.of("Blue", "White")),
                                new ArrayList<>(List.of(Continent.NORTH_AMERICA))
                        ),
                        new BirdEntity(
                                UUID.randomUUID(),
                                "Golden Eagle",
                                "Aquila chrysaetos",
                                200,
                                ConservationStatus.LEAST_CONCERN,
                                Diet.CARNIVOROUS,
                                "https://www.allaboutbirds.org/guide/assets/og/75361861-1200px.jpg",
                                new ArrayList<>(List.of("Brown")),
                                new ArrayList<>(List.of(
                                        Continent.NORTH_AMERICA,
                                        Continent.EUROPE,
                                        Continent.ASIA,
                                        Continent.AFRICA
                                ))
                        ),
                        new BirdEntity(
                                UUID.randomUUID(),
                                "Rainbow Lorikeet",
                                "Trichoglossus moluccanus",
                                17,
                                ConservationStatus.LEAST_CONCERN,
                                Diet.HERBIVORES,
                                "https://www.kidsinaustralia.com.au/wp-content/uploads/2023/07/rainbow-lorrikeet.jpg",
                                new ArrayList<>(List.of("Blue", "Yellow", "Green", "Orange")),
                                new ArrayList<>(List.of(Continent.AUSTRALIA))
                        )
                ));
            }
        };
    }
}
