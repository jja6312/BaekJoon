SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM 
(   SELECT *
    FROM ANIMAL_INS
    WHERE SEX_UPON_INTAKE LIKE 'Intact%') A
JOIN (SELECT *
    FROM ANIMAL_OUTS
    WHERE SEX_UPON_OUTCOME LIKE 'Spayed%' OR SEX_UPON_OUTCOME LIKE 'Neutered%' ) B
ON A.ANIMAL_ID = B.ANIMAL_ID
