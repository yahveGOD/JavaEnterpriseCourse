package org.example.main.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Replay.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Replay_ extends org.example.main.entity.BaseEntity_ {

	
	/**
	 * @see org.example.main.entity.Replay#match
	 **/
	public static volatile SingularAttribute<Replay, Match> match;
	
	/**
	 * @see org.example.main.entity.Replay
	 **/
	public static volatile EntityType<Replay> class_;
	
	/**
	 * @see org.example.main.entity.Replay#steamApiMatchReplayKey
	 **/
	public static volatile SingularAttribute<Replay, Long> steamApiMatchReplayKey;

	public static final String MATCH = "match";
	public static final String STEAM_API_MATCH_REPLAY_KEY = "steamApiMatchReplayKey";

}

