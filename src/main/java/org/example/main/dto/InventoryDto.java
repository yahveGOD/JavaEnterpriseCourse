package org.example.main.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {
    private long uuid;
    private float buildEffectivity;
}
