package org.example.main.repository;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.example.main.entity.TalentTree;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TalentTreeRepository {
    private HeroRepository hr = new HeroRepository();
    @Getter
    private List<TalentTree> talentTreeList;

    public TalentTreeRepository() {
        talentTreeList = new ArrayList<>();
        TalentTree talentTree1 = new TalentTree(0, hr.getHeroes().get(0), 5, "zxc", "qwe");
        TalentTree talentTree2 = new TalentTree(0, hr.getHeroes().get(0), 5, "zxc", "qwe");
        talentTreeList.add(talentTree1);
        talentTreeList.add(talentTree2);
    }
}
