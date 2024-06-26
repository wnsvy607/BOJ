-- 코드를 입력하세요

SELECT CAR_ID, CAR_TYPE, FLOOR(FEE) as FEE
FROM (
    SELECT CC.CAR_ID, CC.CAR_TYPE, (CC.daily_fee * 30 * (100 - DP.discount_rate) / 100) as FEE
    FROM CAR_RENTAL_COMPANY_CAR as CC
    LEFT JOIN (
        SELECT *
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY      
        WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-11-30'
    )as RS
    ON CC.CAR_ID = RS.CAR_ID
    LEFT JOIN (
        SELECT *
        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
        WHERE duration_type = '30일 이상'
    ) as DP
    ON CC.CAR_TYPE = DP.CAR_TYPE
    WHERE (CC.CAR_TYPE = '세단' OR CC.CAR_TYPE = 'SUV') 
    AND RS.CAR_ID IS NULL
    ORDER BY FEE DESC, CC.CAR_TYPE ASC, CC.CAR_ID DESC
) as RS
WHERE FEE >= 500000 AND FEE < 2000000