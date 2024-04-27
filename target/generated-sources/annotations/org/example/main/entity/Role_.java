package org.example.main.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Role.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Role_ extends org.example.main.entity.BaseEntity_ {

	
	/**
	 * @see org.example.main.entity.Role#title
	 **/
	public static volatile SingularAttribute<Role, String> title;
	
	/**
	 * @see org.example.main.entity.Role
	 **/
	public static volatile EntityType<Role> class_;
	
	/**
	 * @see org.example.main.entity.Role#users
	 **/
	public static volatile ListAttribute<Role, User> users;

	public static final String TITLE = "title";
	public static final String USERS = "users";

}

