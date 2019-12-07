SELECT movie_title, movie_year,
concat(director_first_name,director_last_name) as director_name,
concat(actor_first_name,actor_last_name) as actor_name,
role
FROM movies
NATURAL JOIN movies_directors
NATURAL JOIN directors
NATURAL JOIN movies_cast
NATURAL JOIN actors
WHERE movie_time = (SELECT MIN(movie_time) FROM movies);