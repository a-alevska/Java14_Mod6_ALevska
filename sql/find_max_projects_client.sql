SELECT
    client.NAME AS client_name,
    COUNT(project.ID) AS project_count
FROM
    client
        JOIN
    project ON client.ID = project.CLIENT_ID
GROUP BY
    client.ID, client.NAME
HAVING
        COUNT(project.ID) = (
        SELECT COUNT(ID)
        FROM project
        GROUP BY CLIENT_ID
        ORDER BY COUNT(ID) DESC
        LIMIT 1
    );
