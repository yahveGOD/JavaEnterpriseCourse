package org.example.main.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Item.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Item_ extends org.example.main.entity.BaseEntity_ {

	
	/**
	 * @see org.example.main.entity.Item#boughtTimes
	 **/
	public static volatile SingularAttribute<Item, Integer> boughtTimes;
	
	/**
	 * @see org.example.main.entity.Item#name
	 **/
	public static volatile SingularAttribute<Item, String> name;
	
	/**
	 * @see org.example.main.entity.Item#description
	 **/
	public static volatile SingularAttribute<Item, String> description;
	
	/**
	 * @see org.example.main.entity.Item#inventoryList
	 **/
	public static volatile ListAttribute<Item, Inventory> inventoryList;
	
	/**
	 * @see org.example.main.entity.Item#winRate
	 **/
	public static volatile SingularAttribute<Item, Float> winRate;
	
	/**
	 * @see org.example.main.entity.Item#useRate
	 **/
	public static volatile SingularAttribute<Item, Float> useRate;
	
	/**
	 * @see org.example.main.entity.Item
	 **/
	public static volatile EntityType<Item> class_;
	
	/**
	 * @see org.example.main.entity.Item#abilityDescription
	 **/
	public static volatile SingularAttribute<Item, String> abilityDescription;

	public static final String BOUGHT_TIMES = "boughtTimes";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String INVENTORY_LIST = "inventoryList";
	public static final String WIN_RATE = "winRate";
	public static final String USE_RATE = "useRate";
	public static final String ABILITY_DESCRIPTION = "abilityDescription";

}

