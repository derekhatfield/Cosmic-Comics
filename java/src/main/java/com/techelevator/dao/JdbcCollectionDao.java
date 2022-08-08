package com.techelevator.dao;

import com.techelevator.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCollectionDao implements CollectionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection getCollectionByCollectionId(int collectionId) {
        Collection collection = null;
        String sql = "SELECT * FROM collections WHERE collection_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionId);
        if (results.next()) {
            collection = mapRowToCollection(results);
        }
        return collection;
    }

    @Override
    public List<Collection> getAllCollectionsByUserId(int userId) {
        List<Collection> allCollections = new ArrayList<>();
        String sql = "SELECT * FROM collections WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            allCollections.add(mapRowToCollection(results));
        }
        return allCollections;
    }

    @Override
    public Collection createNewCollection(Collection collectionToCreate, int userId) {
        String sql = "INSERT INTO collections (user_id, name, visibility) " +
                "VALUES (?, ?, ?) RETURNING collection_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, collectionToCreate.getUserId(), collectionToCreate.getName(), collectionToCreate.getVisibility());

        return getCollectionByCollectionId(newId);
    }

    @Override
    public void deleteCollectionByCollectionId(int collectionId) {
        String sql = "DELETE FROM comics_collections WHERE collection_id = ?;";
        jdbcTemplate.update(sql, collectionId);
        sql = "DELETE FROM collections WHERE collection_id = ?;";
        jdbcTemplate.update(sql, collectionId);
    }

    private Collection mapRowToCollection(SqlRowSet rowSet) {
        Collection collection = new Collection();
        collection.setCollectionId(rowSet.getInt("collection_id"));
        collection.setUserId(rowSet.getInt("user_id"));
        collection.setName(rowSet.getString("collection_name"));
        collection.setVisibility(rowSet.getString("visibility"));
        return collection;
    }
}
