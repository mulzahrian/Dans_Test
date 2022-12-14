SELECT C.CUST_FIRSTNAME || ? ? || C.CUST_LASTNAME, COUNT(A.ACC_NUMBER)
  FROM CUSTOMER C
  LEFT JOIN ACCOUNT A
    ON A.ACC_OWNER = C.CUST_ID
 GROUP BY C.CUST_FIRSTNAME || ? ? || C.CUST_LASTNAME, C.CUST_ID
