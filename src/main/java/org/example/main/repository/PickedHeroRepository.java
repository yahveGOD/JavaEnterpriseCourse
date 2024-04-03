package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.Inventory;
import org.example.main.entity.PickedHero;
import org.example.main.entity.Replay;
import org.example.main.entity.Statistics;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PickedHeroRepository {
    private HeroRepository heroRepository;
    private MatchRepository matchRepository;
    private StatisticsRepository statisticsRepository;
    private InventoryRepository inventoryRepository;

    private UserRepository userRepository;
    @Getter
    private List<PickedHero> pickedHeroList;
    public PickedHeroRepository()
    {
        pickedHeroList = new ArrayList<>();
        PickedHero pickedHero1 = new PickedHero(heroRepository.getHeroes().get(0), userRepository.getUserList().get(0), matchRepository.getMatchList().get(0), statisticsRepository.getStatisticsList().get(0), inventoryRepository.getInventories().get(0));
        PickedHero pickedHero2 = new PickedHero(heroRepository.getHeroes().get(1), userRepository.getUserList().get(1), matchRepository.getMatchList().get(1), statisticsRepository.getStatisticsList().get(1), inventoryRepository.getInventories().get(1));
        pickedHeroList.add(pickedHero1);
        pickedHeroList.add(pickedHero2);
    }
}
