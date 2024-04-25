package org.example.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.dialect.MySQLCastingJsonJdbcType;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "talant_tree")
public class TalentTree extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    private Hero hero;

    @Column(name = "level_required")
    private Integer levelRequired;

    @Column(name = "cells")
    @JdbcTypeCode(SqlTypes.JSON)
    private TalentBranch talentBranch;
}
