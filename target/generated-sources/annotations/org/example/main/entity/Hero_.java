package org.example.main.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Hero.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Hero_ extends org.example.main.entity.BaseEntity_ {

	
	/**
	 * @see org.example.main.entity.Hero#abilities
	 **/
	public static volatile ListAttribute<Hero, Ability> abilities;
	
	/**
	 * @see org.example.main.entity.Hero#strength
	 **/
	public static volatile SingularAttribute<Hero, Integer> strength;
	
	/**
	 * @see org.example.main.entity.Hero#pickedHeroes
	 **/
	public static volatile ListAttribute<Hero, PickedHero> pickedHeroes;
	
	/**
	 * @see org.example.main.entity.Hero#name
	 **/
	public static volatile SingularAttribute<Hero, String> name;
	
	/**
	 * @see org.example.main.entity.Hero#winRate
	 **/
	public static volatile SingularAttribute<Hero, Float> winRate;
	
	/**
	 * @see org.example.main.entity.Hero#pickedTimes
	 **/
	public static volatile SingularAttribute<Hero, Integer> pickedTimes;
	
	/**
	 * @see org.example.main.entity.Hero#agility
	 **/
	public static volatile SingularAttribute<Hero, Integer> agility;
	
	/**
	 * @see org.example.main.entity.Hero
	 **/
	public static volatile EntityType<Hero> class_;
	
	/**
	 * @see org.example.main.entity.Hero#pickRate
	 **/
	public static volatile SingularAttribute<Hero, Float> pickRate;
	
	/**
	 * @see org.example.main.entity.Hero#intelligence
	 **/
	public static volatile SingularAttribute<Hero, Integer> intelligence;

	public static final String ABILITIES = "abilities";
	public static final String STRENGTH = "strength";
	public static final String PICKED_HEROES = "pickedHeroes";
	public static final String NAME = "name";
	public static final String WIN_RATE = "winRate";
	public static final String PICKED_TIMES = "pickedTimes";
	public static final String AGILITY = "agility";
	public static final String PICK_RATE = "pickRate";
	public static final String INTELLIGENCE = "intelligence";

}

