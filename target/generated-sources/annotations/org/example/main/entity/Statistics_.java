package org.example.main.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Statistics.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Statistics_ extends org.example.main.entity.BaseEntity_ {

	
	/**
	 * @see org.example.main.entity.Statistics#kills
	 **/
	public static volatile SingularAttribute<Statistics, Integer> kills;
	
	/**
	 * @see org.example.main.entity.Statistics#assists
	 **/
	public static volatile SingularAttribute<Statistics, Integer> assists;
	
	/**
	 * @see org.example.main.entity.Statistics#networth
	 **/
	public static volatile SingularAttribute<Statistics, Integer> networth;
	
	/**
	 * @see org.example.main.entity.Statistics
	 **/
	public static volatile EntityType<Statistics> class_;
	
	/**
	 * @see org.example.main.entity.Statistics#deaths
	 **/
	public static volatile SingularAttribute<Statistics, Integer> deaths;
	
	/**
	 * @see org.example.main.entity.Statistics#pickedHeroList
	 **/
	public static volatile ListAttribute<Statistics, PickedHero> pickedHeroList;

	public static final String KILLS = "kills";
	public static final String ASSISTS = "assists";
	public static final String NETWORTH = "networth";
	public static final String DEATHS = "deaths";
	public static final String PICKED_HERO_LIST = "pickedHeroList";

}

