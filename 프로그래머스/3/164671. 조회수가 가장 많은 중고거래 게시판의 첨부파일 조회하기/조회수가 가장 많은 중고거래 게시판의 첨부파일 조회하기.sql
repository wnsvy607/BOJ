-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/', BA.BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) as FILE_PATH
FROM USED_GOODS_FILE as UG
JOIN (SELECT *
      FROM USED_GOODS_BOARD
      ORDER BY VIEWS DESC
      LIMIT 1
    ) as BA
ON BA.BOARD_ID = UG.BOARD_ID
ORDER BY UG.FILE_ID DESC