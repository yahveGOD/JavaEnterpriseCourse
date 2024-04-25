package org.example.main.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(GameMode.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class GameMode_ {

	
	/**
	 * @see org.example.main.entity.GameMode#numberOfPLayers
	 **/
	public static volatile SingularAttribute<GameMode, Short> numberOfPLayers;
	
	/**
	 * @see org.example.main.entity.GameMode#name
	 **/
	public static volatile SingularAttribute<GameMode, String> name;
	
	/**
	 * @see org.example.main.entity.GameMode#description
	 **/
	public static volatile SingularAttribute<GameMode, String> description;
	
	/**
	 * @see org.example.main.entity.GameMode#id
	 **/
	public static volatile SingularAttribute<GameMode, Long> id;
	
	/**
	 * @see org.example.main.entity.GameMode
	 **/
	public static volatile EntityType<GameMode> class_;
	
	/**
	 * @see org.example.main.entity.GameMode#matches
	 **/
	public static volatile ListAttribute<GameMode, Match> matches;
	
	/**
	 * @see org.example.main.entity.GameMode#isEvent
	 **/
	public static volatile SingularAttribute<GameMode, Boolean> isEvent;

	public static final String NUMBER_OF_PLAYERS = "numberOfPLayers";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String MATCHES = "matches";
	public static final String IS_EVENT = "isEvent";

}

