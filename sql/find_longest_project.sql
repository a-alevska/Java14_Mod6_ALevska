SELECT
    project.ID AS project_id,
    DATE_PART('year', AGE(project.FINISH_DATE, project.START_DATE)) * 12 +
    DATE_PART('month', AGE(project.FINISH_DATE, project.START_DATE)) AS duration_months
FROM
    project
WHERE
                DATE_PART('year', AGE(project.FINISH_DATE, project.START_DATE)) * 12 +
                DATE_PART('month', AGE(project.FINISH_DATE, project.START_DATE)) = (
                    SELECT
                        MAX(DATE_PART('year', AGE(FINISH_DATE, START_DATE)) * 12 +
                            DATE_PART('month', AGE(FINISH_DATE, START_DATE)))
                    FROM
                        project
                );
