package org.example.main.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.sql.Time;

@StaticMetamodel(Match.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Match_ {

	
	/**
	 * @see org.example.main.entity.Match#duration
	 **/
	public static volatile SingularAttribute<Match, Time> duration;
	
	/**
	 * @see org.example.main.entity.Match#direKills
	 **/
	public static volatile SingularAttribute<Match, Long> direKills;
	
	/**
	 * @see org.example.main.entity.Match#pickedHero
	 **/
	public static volatile ListAttribute<Match, PickedHero> pickedHero;
	
	/**
	 * @see org.example.main.entity.Match#radiantKills
	 **/
	public static volatile SingularAttribute<Match, Long> radiantKills;
	
	/**
	 * @see org.example.main.entity.Match#id
	 **/
	public static volatile SingularAttribute<Match, Long> id;
	
	/**
	 * @see org.example.main.entity.Match#replay
	 **/
	public static volatile SingularAttribute<Match, Replay> replay;
	
	/**
	 * @see org.example.main.entity.Match#victorySide
	 **/
	public static volatile SingularAttribute<Match, String> victorySide;
	
	/**
	 * @see org.example.main.entity.Match#gameMode
	 **/
	public static volatile SingularAttribute<Match, GameMode> gameMode;
	
	/**
	 * @see org.example.main.entity.Match
	 **/
	public static volatile EntityType<Match> class_;
	
	/**
	 * @see org.example.main.entity.Match#users
	 **/
	public static volatile ListAttribute<Match, User> users;

	public static final String DURATION = "duration";
	public static final String DIRE_KILLS = "direKills";
	public static final String PICKED_HERO = "pickedHero";
	public static final String RADIANT_KILLS = "radiantKills";
	public static final String ID = "id";
	public static final String REPLAY = "replay";
	public static final String VICTORY_SIDE = "victorySide";
	public static final String GAME_MODE = "gameMode";
	public static final String USERS = "users";

}

