-- 코드를 입력하세요

SELECT FP.PRODUCT_ID as PRODUCT_ID, PRODUCT_NAME, SUM(AMOUNT * PRICE) TOTAL_SALES
FROM FOOD_PRODUCT FP join (
    SELECT *
    FROM FOOD_ORDER
    WHERE PRODUCE_DATE LIKE '2022-05%'
) FO on FP.PRODUCT_ID = FO.PRODUCT_ID
GROUP BY FP.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID
;