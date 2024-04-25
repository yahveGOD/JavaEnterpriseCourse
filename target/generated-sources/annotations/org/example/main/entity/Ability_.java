package org.example.main.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Ability.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Ability_ extends org.example.main.entity.BaseEntity_ {

	
	/**
	 * @see org.example.main.entity.Ability#isPassive
	 **/
	public static volatile SingularAttribute<Ability, Boolean> isPassive;
	
	/**
	 * @see org.example.main.entity.Ability#name
	 **/
	public static volatile SingularAttribute<Ability, String> name;
	
	/**
	 * @see org.example.main.entity.Ability#fixedDamage
	 **/
	public static volatile SingularAttribute<Ability, Integer> fixedDamage;
	
	/**
	 * @see org.example.main.entity.Ability#description
	 **/
	public static volatile SingularAttribute<Ability, String> description;
	
	/**
	 * @see org.example.main.entity.Ability#hero
	 **/
	public static volatile SingularAttribute<Ability, Hero> hero;
	
	/**
	 * @see org.example.main.entity.Ability#damageType
	 **/
	public static volatile SingularAttribute<Ability, String> damageType;
	
	/**
	 * @see org.example.main.entity.Ability
	 **/
	public static volatile EntityType<Ability> class_;

	public static final String IS_PASSIVE = "isPassive";
	public static final String NAME = "name";
	public static final String FIXED_DAMAGE = "fixedDamage";
	public static final String DESCRIPTION = "description";
	public static final String HERO = "hero";
	public static final String DAMAGE_TYPE = "damageType";

}

