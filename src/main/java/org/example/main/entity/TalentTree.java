package org.example.main.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TalentTree{
    private long id;
    private Hero hero;
    private int levelRequired;
    private String talentLeft;
    private String talentRight;
}
