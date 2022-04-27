# Triggers

- [Triggers](#triggers)
  - [Uses](#uses)
  - [Syntax](#syntax)
  - [Example](#example)

A trigger is a little script linked to a table which will activate and do its thing every time the table suffers one of the following events:

- **INSERT**
- **DELETE**
- **UPDATE**

The trigger will be executed either **BEFORE** or **AFTER** the table is affected.

> While a trigger is associated to a sole table, it can access other tables while doing its thing.

## Uses

Mainly, triggers are used to:

- **Validate** values before inserting them onto a table.
- **Update** values when a table is modified.

## Syntax

```sql
CREATE TRIGGER <tgr_name> trigger_time trigger_event
ON <tbl_name> FOR EACH ROW
BEGIN
<trigger_body>
END;
```

```sql
trigger_time: { BEFORE | AFTER }
trigger_event: { INSERT | UPDATE | DELETE }
```

When accessing a table row from a pointer you can use the keywords `OLD` and `NEW` to refer to the values:

- For an **INSERT** trigger, `OLD` contains no values, and `NEW` contains the new values.

- For an **UPDATE** trigger, `OLD` contains the old values, and `NEW` contains the new values.

- For a **DELETE** trigger, `OLD` contains the old values, and `NEW` contains no values.

|            |  OLD  |  NEW  |
| ---------- | :---: | :---: |
| **INSERT** |   -   |   X   |
| **UPDATE** |   X   |   X   |
| **DELETE** |   X   |   -   |

## Example

```sql
DROP TRIGGER IF EXISTS insertPrestamo;

DELIMITER //

CREATE TRIGGER insertPrestamo AFTER INSERT
ON prestamo FOR EACH ROW
BEGIN

UPDATE ejemplares SET disponible = disponible - 1
WHERE libro = NEW.libro;

END //

DELIMITER ;
```

---

> Go back to the [index](.index.md#index).
