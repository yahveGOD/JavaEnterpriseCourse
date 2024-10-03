package org.example.main.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(TalentTree.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class TalentTree_ extends org.example.main.entity.BaseEntity_ {

	
	/**
	 * @see org.example.main.entity.TalentTree#cells
	 **/
	public static volatile SingularAttribute<TalentTree, String> cells;
	
	/**
	 * @see org.example.main.entity.TalentTree#levelRequired
	 **/
	public static volatile SingularAttribute<TalentTree, Integer> levelRequired;
	
	/**
	 * @see org.example.main.entity.TalentTree#hero
	 **/
	public static volatile SingularAttribute<TalentTree, Hero> hero;
	
	/**
	 * @see org.example.main.entity.TalentTree
	 **/
	public static volatile EntityType<TalentTree> class_;

	public static final String CELLS = "cells";
	public static final String LEVEL_REQUIRED = "levelRequired";
	public static final String HERO = "hero";

}

