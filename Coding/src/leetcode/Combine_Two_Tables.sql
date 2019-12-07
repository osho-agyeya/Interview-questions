# Write your MySQL query statement below
select a.FIRSTNAME, a.LASTNAME, b.CITY, b.STATE from PERSON a left join ADDRESS b on a.PERSONID = b.PERSONID;