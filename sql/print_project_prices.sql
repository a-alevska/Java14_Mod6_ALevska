WITH ProjectCost AS (
    SELECT
        p.ID AS project_id,
        SUM(w.SALARY * EXTRACT(MONTH FROM AGE(p.FINISH_DATE, p.START_DATE))) AS project_cost
    FROM
        project p
            JOIN
        project_worker pw ON p.ID = pw.PROJECT_ID
            JOIN
        worker w ON pw.WORKER_ID = w.ID
    GROUP BY
        p.ID
)
SELECT
        'Project '|| project_id as project, project_cost AS price
FROM
    ProjectCost
ORDER BY
    project_cost DESC;
