package com.techelevator.dao;

import com.techelevator.model.Comic;
import com.techelevator.model.MarvelDataModels.MarvelThumbnail;
import com.techelevator.model.MarvelDataModels.OverallMarvelResults;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcComicDao implements ComicDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcComicDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public OverallMarvelResults getComicByComicId(int id) {
        OverallMarvelResults comic = null;
        String sql = "SELECT comic_id, title, thumbnail_url FROM comics WHERE comic_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            comic = mapRowToComic(results);
        }
        return comic;
    }

    @Override
    public boolean hasAuthor(int comicId, int authorId) {
        String sql = "SELECT comic_id FROM comics_creators WHERE comic_id = ? AND creator_id =?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, comicId, authorId);
        return results.next();
    }

    @Override
    public List<OverallMarvelResults> getComicsByCollectionId(int id) {
        List<OverallMarvelResults> comics = new ArrayList<>();
        String sql = "SELECT c.comic_id, c.title, c.thumbnail_url FROM comics_collections AS cc " +
                "INNER JOIN comics AS c ON c.comic_id = cc.comic_id WHERE cc.collection_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()) {
            comics.add(mapRowToComic(results));
        }
        return comics;
    }

    @Override
    public String getThumbnailById(int id) {
        String sql = "SELECT thumbnail_url FROM comics WHERE comic_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return results.getString("thumbnail_url");
        }
        return "";
    }

    private OverallMarvelResults mapRowToComic(SqlRowSet rowSet) {
        OverallMarvelResults comic = new OverallMarvelResults();
        comic.setId(rowSet.getInt("comic_id"));
        comic.setTitle(rowSet.getString("title"));
        comic.setThumbnail(new MarvelThumbnail(rowSet.getString("thumbnail_url"), ""));
        return comic;
    }
}
