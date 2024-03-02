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
                                "The northern cardinal (Cardinalis cardinalis), known colloquially as the redbird, common cardinal, red cardinal, or just cardinal, is a bird in the genus Cardinalis. It can be found in southeastern Canada, through the eastern United States from Maine to Minnesota to Texas, New Mexico, southern Arizona, southern California, and south through Mexico, Belize, and Guatemala.",
                                "https://en.wikipedia.org/wiki/Northern_cardinal",
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
                                "The bald eagle (Haliaeetus leucocephalus) is a bird of prey found in North America. A sea eagle, it has two known subspecies and forms a species pair with the white-tailed eagle (Haliaeetus albicilla), which occupies the same niche as the bald eagle in the Palearctic. Its range includes most of Canada and Alaska, all of the contiguous United States, and northern Mexico. It is found near large bodies of open water with an abundant food supply and old-growth trees for nesting.",
                                "https://en.wikipedia.org/wiki/Bald_eagle",
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
                                "The European robin (Erithacus rubecula), known simply as the robin or robin redbreast in Great Britain and Ireland, is a small insectivorous passerine bird that belongs to the chat subfamily of the Old World flycatcher family.",
                                "https://en.wikipedia.org/wiki/European_robin",
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
                                "The grey parrot (Psittacus erithacus), also known as the Congo grey parrot, Congo African grey parrot or African grey parrot, is an Old World parrot in the family Psittacidae. The Timneh parrot (Psittacus timneh) once was identified as a subspecies of the grey parrot, but has since been elevated to a full species.",
                                "https://en.wikipedia.org/wiki/Grey_parrot",
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
                                "The ruby-throated hummingbird (Archilochus colubris) is a species of hummingbird that generally spends the winter in Central America, Mexico, and Florida, and migrates to Canada and other parts of Eastern North America for the summer to breed. It is the most common hummingbird in eastern North America, having population estimates of about 35 million in 2021.",
                                "https://en.wikipedia.org/wiki/Ruby-throated_hummingbird",
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
                                "The peregrine falcon (Falco peregrinus), also known simply as the peregrine, and historically as the duck hawk in North America, is a cosmopolitan bird of prey (raptor) in the family Falconidae. A large, crow-sized falcon, it has a blue-grey back, barred white underparts, and a black head. The peregrine is renowned for its speed. It can reach over 320 km/h (200 mph) during its characteristic hunting stoop (high-speed dive), making it the fastest member of the animal kingdom.",
                                "https://en.wikipedia.org/wiki/Peregrine_falcon",
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
                                "The emperor penguin (Aptenodytes forsteri) is the tallest and heaviest of all living penguin species and is endemic to Antarctica. The male and female are similar in plumage and size, reaching 100 cm (39 in) in length and weighing from 22 to 45 kg (49 to 99 lb). Feathers of the head and back are black and sharply delineated from the white belly, pale-yellow breast and bright-yellow ear patches.",
                                "https://en.wikipedia.org/wiki/Emperor_penguin",
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
                                "The blue jay (Cyanocitta cristata) is a passerine bird in the family Corvidae, native to eastern North America. It lives in most of the eastern and central United States; some eastern populations may be migratory. Resident populations are also in Newfoundland, Canada; breeding populations are found across southern Canada.",
                                "https://en.wikipedia.org/wiki/Blue_jay",
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
                                "The golden eagle (Aquila chrysaetos) is a bird of prey living in the Northern Hemisphere. It is the most widely distributed species of eagle. Like all eagles, it belongs to the family Accipitridae. They are one of the best-known birds of prey in the Northern Hemisphere. These birds are dark brown, with lighter golden-brown plumage on their napes. Immature eagles of this species typically have white on the tail and often have white markings on the wings.",
                                "https://en.wikipedia.org/wiki/Golden_eagle",
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
                                "The rainbow lorikeet (Trichoglossus moluccanus) is a species of parrot found in Australia. It is common along the eastern seaboard, from northern Queensland to South Australia. Its habitat is rainforest, coastal bush and woodland areas. Six taxa traditionally listed as subspecies of the rainbow lorikeet are now treated as separate species.",
                                "https://en.wikipedia.org/wiki/Rainbow_lorikeet",
                                new ArrayList<>(List.of("Blue", "Yellow", "Green", "Orange")),
                                new ArrayList<>(List.of(Continent.AUSTRALIA))
                        )
                ));
            }
        };
    }
}
