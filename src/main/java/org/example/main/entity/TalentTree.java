package org.example.main.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TalentTree extends BaseEntity{
    private Hero hero;
    private int levelRequired;
    private String talentLeft;
    private String talentRight;
}
