package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcComicDao implements ComicDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcComicDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Comic getComicByComicId(int comicId) {
        Comic comic = null;
        String sql = "SELECT * FROM comics WHERE comic_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, comicId);
        if (results.next()) {
            comic = mapRowToComic(results);
        }
        return comic; 
    }

    @Override
    public Comic addComicByComicId(Comic comicToAdd, int comicId) {
        Comic comic = null;
        String sql = "INSERT INTO comics (comic_author, comic_issue, comic_title, comic_series, comic_thumbnail_url) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING comic_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, comicToAdd.getComicAuthor(), comicToAdd.getComicIssue(), comicToAdd.getComicTitle(),
                comicToAdd.getComicSeries(), comicToAdd.getComicThumbnailUrl());

        return getComicByComicId(newId);
    }

    @Override
    public void removeComicByComicId(int comicId) {
        String sql = "DELETE FROM comics_collections WHERE comic_id = ?;";
        jdbcTemplate.update(sql, comicId);
        sql = "DELETE FROM comics WHERE comic_id = ?;";
        jdbcTemplate.update(sql, comicId);
    }

    private Comic mapRowToComic(SqlRowSet rowSet) {
        Comic comic = new Comic();
        comic.setComicId(rowSet.getInt("comic_id"));
        comic.setComicAuthor(rowSet.getString("comic_author"));
        comic.setComicIssue(rowSet.getInt("comic_issue"));
        comic.setComicTitle(rowSet.getString("comic_title"));
        comic.setComicSeries(rowSet.getString("comic_series"));
        return comic;
    }

}
