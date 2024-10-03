package org.example.main.dto.creationDto;

import lombok.*;
import org.example.main.entity.PickedHeroId;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PickedHeroCreationDto {
    private PickedHeroId pickedHeroId;

}
