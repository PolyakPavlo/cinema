package com.movieland.cinema.dao.jdbc.mapper;

import com.movieland.cinema.domain.Genre;
import com.movieland.cinema.domain.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class GenreRowMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Genre genre = new Genre();
        genre.setGenre_id(resultSet.getLong("genre_id"));
        genre.setName(resultSet.getString("name"));
        Set<Movie> set = new HashSet<>();
        while (resultSet.next()) {
            Movie movie = new Movie();
            movie.setMovieId(resultSet.getLong(1));
            movie.setNameTranslate(resultSet.getString("name"));
            set.add(movie);
        }
        genre.setMovies(set);

        return genre;
    }
}