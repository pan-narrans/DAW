# MySQL views

```cmd
@autor: Alejandro Pérez
```

```sql
CREATE VIEW customerPayments
AS 
SELECT 
    customerName, 
    checkNumber, 
    paymentDate, 
    amount
FROM
    customers
INNER JOIN
    payments USING (customerNumber);
```
