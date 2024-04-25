package org.example.main.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Inventory.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Inventory_ extends org.example.main.entity.BaseEntity_ {

	
	/**
	 * @see org.example.main.entity.Inventory#pickedHeroes
	 **/
	public static volatile ListAttribute<Inventory, PickedHero> pickedHeroes;
	
	/**
	 * @see org.example.main.entity.Inventory
	 **/
	public static volatile EntityType<Inventory> class_;
	
	/**
	 * @see org.example.main.entity.Inventory#items
	 **/
	public static volatile ListAttribute<Inventory, Item> items;
	
	/**
	 * @see org.example.main.entity.Inventory#buildEffectivity
	 **/
	public static volatile SingularAttribute<Inventory, Float> buildEffectivity;

	public static final String PICKED_HEROES = "pickedHeroes";
	public static final String ITEMS = "items";
	public static final String BUILD_EFFECTIVITY = "buildEffectivity";

}

