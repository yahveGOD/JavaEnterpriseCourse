package org.example.main.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class User_ extends org.example.main.entity.BaseEntity_ {

	
	/**
	 * @see org.example.main.entity.User#password
	 **/
	public static volatile SingularAttribute<User, String> password;
	
	/**
	 * @see org.example.main.entity.User#pickedHeroes
	 **/
	public static volatile ListAttribute<User, PickedHero> pickedHeroes;
	
	/**
	 * @see org.example.main.entity.User#averageMatchmakingRating
	 **/
	public static volatile SingularAttribute<User, Integer> averageMatchmakingRating;
	
	/**
	 * @see org.example.main.entity.User#roles
	 **/
	public static volatile ListAttribute<User, Role> roles;
	
	/**
	 * @see org.example.main.entity.User#steamApiKey
	 **/
	public static volatile SingularAttribute<User, String> steamApiKey;
	
	/**
	 * @see org.example.main.entity.User#name
	 **/
	public static volatile SingularAttribute<User, String> name;
	
	/**
	 * @see org.example.main.entity.User#description
	 **/
	public static volatile SingularAttribute<User, String> description;
	
	/**
	 * @see org.example.main.entity.User
	 **/
	public static volatile EntityType<User> class_;
	
	/**
	 * @see org.example.main.entity.User#matches
	 **/
	public static volatile ListAttribute<User, Match> matches;

	public static final String PASSWORD = "password";
	public static final String PICKED_HEROES = "pickedHeroes";
	public static final String AVERAGE_MATCHMAKING_RATING = "averageMatchmakingRating";
	public static final String ROLES = "roles";
	public static final String STEAM_API_KEY = "steamApiKey";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String MATCHES = "matches";

}

