package org.example.main.repository;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.main.annotation.Transaction;
import org.example.main.entity.Ability;
import org.example.main.entity.Hero;
import org.example.main.util.ConnectionHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AbilityRepository {
    private final ConnectionHolder connectionHolder;
    private static final String SELECT_ABILITY_BY_ID = "SELECT abil.id as abil_id,abil.name as ability_name,abil.description as description,abil.damage_type as damage_type,abil.is_passive as is_passive,abil.fixed_damage as fixed_damage,abil.hero_id as hero_id,\n" +
            "h.id as id,h.name as hero_name,h.pick_rate as pick_rate,h.win_rate as win_rate,h.picked_times as picked_times,h.agility as agility, h.strength as strength,h.intelligence as intelligence" +
            " FROM ability abil INNER JOIN hero h on abil.hero_id = h.id WHERE abil.id=?";
    private static final String INSERT_ABILITY = "INSERT INTO ability (name, description, damage_type, fixed_damage, is_passive, hero_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String INSERT_HERO = "INSERT INTO hero (name, win_rate, pick_rate, picked_times, strength, agility, intelligence) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_ABILITY = "SELECT abil.id as abil_id,abil.name as ability_name,abil.description as description,abil.damage_type as damage_type,abil.is_passive as is_passive,abil.fixed_damage as fixed_damage,abil.hero_id as hero_id," +
            "            h.id as id,h.name as hero_name,h.pick_rate as pick_rate,h.win_rate as win_rate,h.picked_times as picked_times,h.agility as agility, h.strength as strength,h.intelligence as intelligence" +
            "            FROM ability abil INNER JOIN hero h on abil.hero_id = h.id";
    private static final String SELECT_HERO_BY_ID = "SELECT * FROM hero where id=?";
    private static final String DELETE_ABILITY_BY_ID = "DELETE FROM ability WHERE id = ?";

    public Optional<Ability> findById(long abilityId) {
        Ability ability = null;
        try (Connection connection = connectionHolder.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ABILITY_BY_ID)) {
            preparedStatement.setLong(1, abilityId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ability = new Ability();
                    Hero hero = new Hero();
                    ability.setId(resultSet.getLong("id"));
                    ability.setName(resultSet.getString("ability_name"));
                    ability.setDescription(resultSet.getString("description"));
                    ability.setDamageType(resultSet.getString("damage_type"));
                    ability.setPassive(resultSet.getBoolean("is_passive"));
                    ability.setFixedDamage(resultSet.getInt("fixed_damage"));
                    hero.setId(resultSet.getLong("id"));
                    hero.setName(resultSet.getString("hero_name"));
                    hero.setPickRate(resultSet.getFloat("pick_rate"));
                    hero.setWinRate(resultSet.getFloat("win_rate"));
                    hero.setPickedTimes(resultSet.getInt("picked_times"));
                    hero.setAgility(resultSet.getInt("agility"));
                    hero.setStrength(resultSet.getInt("strength"));
                    hero.setIntelligence(resultSet.getInt("intelligence"));
                    ability.setHero(hero);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(ability);
    }

    public void deleteById(long abilityId) {
        try (Connection connection = connectionHolder.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ABILITY_BY_ID)) {
            preparedStatement.setLong(1, abilityId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Ability ability) {
        try (Connection connection = connectionHolder.getConnection()) {

            if (ability.getHero() != null) {
                saveHero(ability.getHero(), connection);
            }

            saveAbility(ability, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveAbility(Ability ability, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ABILITY)) {
            preparedStatement.setString(1, ability.getName());
            preparedStatement.setString(2, ability.getDescription());
            preparedStatement.setString(3, ability.getDamageType());
            preparedStatement.setInt(4, ability.getFixedDamage());
            preparedStatement.setBoolean(5, ability.isPassive());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveHero(Hero hero, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HERO)) {
            preparedStatement.setString(1, hero.getName());
            preparedStatement.setFloat(2, hero.getWinRate());
            preparedStatement.setFloat(3, hero.getPickRate());
            preparedStatement.setInt(4, hero.getPickedTimes());
            preparedStatement.setInt(5, hero.getStrength());
            preparedStatement.setInt(6, hero.getAgility());
            preparedStatement.setInt(7, hero.getIntelligence());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ability> findAll() {
        List<Ability> abilities = new ArrayList<>();

        try (Connection connection = connectionHolder.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ABILITY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Ability ability = new Ability();
                Hero hero = new Hero();
                ability.setId(resultSet.getLong("id"));
                ability.setName(resultSet.getString("ability_name"));
                ability.setDescription(resultSet.getString("description"));
                ability.setDamageType(resultSet.getString("damage_type"));
                ability.setPassive(resultSet.getBoolean("is_passive"));
                ability.setFixedDamage(resultSet.getInt("fixed_damage"));
                hero.setId(resultSet.getLong("id"));
                hero.setName(resultSet.getString("hero_name"));
                hero.setPickRate(resultSet.getFloat("pick_rate"));
                hero.setWinRate(resultSet.getFloat("win_rate"));
                hero.setPickedTimes(resultSet.getInt("picked_times"));
                hero.setAgility(resultSet.getInt("agility"));
                hero.setStrength(resultSet.getInt("strength"));
                hero.setIntelligence(resultSet.getInt("intelligence"));
                ability.setHero(hero);
                abilities.add(ability);
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abilities;
    }
}

