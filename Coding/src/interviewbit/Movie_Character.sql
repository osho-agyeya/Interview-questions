SELECT concat(director_first_name,director_last_name) as director_name,
movie_title
FROM directors
NATURAL JOIN movies_directors
NATURAL JOIN movies
NATURAL JOIN movies_cast
WHERE movies_cast.role = 'SeanMaguire';