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

    private Comic mapRowToComic(SqlRowSet rowSet) {
        Comic comic = new Comic();
        comic.setComicId(rowSet.getInt("comic_id"));
        comic.setComicAuthor(rowSet.getString("comic_author"));
        comic.setComicIssue(rowSet.getInt("comic_issue"));
        comic.setComicTitle(rowSet.getString("comic_title"));
        comic.setComicSeries(rowSet.getString("comic_series"));
        comic.setComicPublisher(rowSet.getString("comic_publisher"));
        return comic;
    }

}
