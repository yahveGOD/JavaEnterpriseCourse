package org.example.main.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PickedHero.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class PickedHero_ {

	
	/**
	 * @see org.example.main.entity.PickedHero#heroes
	 **/
	public static volatile ListAttribute<PickedHero, Hero> heroes;
	
	/**
	 * @see org.example.main.entity.PickedHero#pickedHeroId
	 **/
	public static volatile SingularAttribute<PickedHero, PickedHeroId> pickedHeroId;
	
	/**
	 * @see org.example.main.entity.PickedHero#inventory
	 **/
	public static volatile SingularAttribute<PickedHero, Inventory> inventory;
	
	/**
	 * @see org.example.main.entity.PickedHero
	 **/
	public static volatile EntityType<PickedHero> class_;
	
	/**
	 * @see org.example.main.entity.PickedHero#matches
	 **/
	public static volatile ListAttribute<PickedHero, Match> matches;
	
	/**
	 * @see org.example.main.entity.PickedHero#user
	 **/
	public static volatile SingularAttribute<PickedHero, User> user;
	
	/**
	 * @see org.example.main.entity.PickedHero#statistics
	 **/
	public static volatile SingularAttribute<PickedHero, Statistics> statistics;

	public static final String HEROES = "heroes";
	public static final String PICKED_HERO_ID = "pickedHeroId";
	public static final String INVENTORY = "inventory";
	public static final String MATCHES = "matches";
	public static final String USER = "user";
	public static final String STATISTICS = "statistics";

}

