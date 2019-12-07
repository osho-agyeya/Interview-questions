SELECT DISTINCT movies.movie_title 
FROM movies
WHERE movies.movie_id IN
(   
    SELECT movie_id 
    FROM movies_cast
    WHERE actor_id IN
    (
        SELECT actor_id 
        FROM movies_cast 
        GROUP BY actor_id 
        HAVING COUNT(movie_id)>=2
    )
);