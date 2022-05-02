# MySQL Views

```cmd
@autor: Alejandro Pérez
```

## Syntax

```sql
CREATE VIEW customerPayments AS 
SELECT 
    customerName, checkNumber, paymentDate, amount
FROM customers
INNER JOIN payments USING (customerNumber);
```
