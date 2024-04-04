package org.example.main.repository;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.example.main.entity.TalentTree;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TalentTreeRepository extends AbstractRepository<TalentTree>{

    public TalentTreeRepository() {
        save(TalentTree.builder()
                .talentRight("123")
                .talentLeft("zxc")
                .levelRequired(5)
                .build());
        save(TalentTree.builder()
                .talentRight("111")
                .talentLeft("qwe")
                .levelRequired(10)
                .build());
    }
}
