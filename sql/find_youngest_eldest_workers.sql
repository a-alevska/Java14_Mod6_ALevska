WITH EmployeeRanking AS (
    SELECT
        NAME,
        BIRTHDAY,
        RANK() OVER (ORDER BY BIRTHDAY) AS oldest_rank,
        RANK() OVER (ORDER BY BIRTHDAY DESC) AS youngest_rank
    FROM
        worker
)
SELECT
    'YOUNGEST' AS TYPE,
    NAME,
    BIRTHDAY
FROM
    EmployeeRanking
WHERE
        youngest_rank = 1

UNION

SELECT
    'OLDEST' AS TYPE,
    NAME,
    BIRTHDAY
FROM
    EmployeeRanking
WHERE
        oldest_rank = 1;
