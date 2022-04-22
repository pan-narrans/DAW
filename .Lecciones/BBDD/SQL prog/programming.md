# SQL Programming basics

```cmd
@autor: Alejandro Pérez
```

- [SQL Programming basics](#sql-programming-basics)
  - [Delimiter](#delimiter)
  - [Variables](#variables)
  - [Parameters](#parameters)
  - [Statements](#statements)
    - [If statement](#if-statement)
    - [Case statement](#case-statement)
    - [While statement](#while-statement)
    - [Repeat Until statement](#repeat-until-statement)
    - [Loop statement](#loop-statement)

## Delimiter

The delimiter changes the end line character. We change it so SQL doesn't interpret the `;` of the function as dividing SQL statements.

The new delimiter can be set to whatever and in truth, doesn't need to be changed back, but we do.

```sql
-- At the start.
DELIMITER $$
```

```sql
-- At the end.
DELIMITER ;
```

## Variables

Local and thus, only used inside the script. They only have power between the `BEGIN` and `END` keywords.

> There might another, more complex type of variable called *global variables*. But as of today they are not standardized and have not a set vay of declaring them.

Declaration of a **local variable** and assignment of value:

```SQL
DECLARE foo BOOLEAN;
SET foo = TRUE;
```

Assignment of value based on result of a query:

```SQL
DECLARE foo INTEGER DEFAULT 0;
SELECT COUNT(*) INTO foo;
```

## Parameters

You can pass on parameters onto a function or procedure.

## Statements

### If statement

It behaves as you'd expect. It's and `if` statement, don't fret about it.

Syntax:

```SQL
IF <condition> THEN
  <command>;
ELSEIF <condition> THEN
  <command>;
...
ELSE
  <command>;
END IF;
```

Example:

```SQL
DECLARE canLend BOOLEAN;
SET canLend = TRUE;

IF getNumPrestamos(socio) > 3 THEN
  SET canLend = FALSE;
END IF;
```

### Case statement

Just as the switch in java, you pass in an expression, variable, thingumajig, you name it and depending on its value you do stuff.

Syntax:

```SQL
CASE <case expression>
WHEN <expression1> THEN <command1>
WHEN <expression2> THEN <command2>
...
ELSE <commandN>
END CASE;
```

Example:

```SQL
CASE empDept
WHEN 1 THEN
  SET bonus = 10000;
WHEN 4 THEN
  SET bonus = 5000;
ELSE
  SET bonus = 0;
END CASE;
```

### While statement

Just a good 'ol `while` loop.

Syntax:

```SQL
WHILE <condition> DO
<commands>
END WHILE;
```

### Repeat Until statement

A `do while` loop. It will iterate at least one time.

Syntax:

```SQL
REPEAT
<commands>
UNTIL <condition>
END REPEAT;
```

### Loop statement

We don't have no fancy `for` loops here in SQL. All we have is this old school, reliable and `spaghetti loop`.

Syntax:

```SQL
<loopName>: LOOP
  <commands>
  IF <condition> THEN
    LEAVE <loopName>    -- break
  ELSE IF <condition> THEN
    ITERATE <loopName>  -- continue
  END IF;
END LOOP;
```

Example:

```SQL
L: LOOP
  SET x = x + 1;
  IF (x >= 5) THEN
    LEAVE L;
  END IF;
  IF (x mod 2 = 0) THEN
    ITERATE L;
  END IF;
  SELECT x;
END LOOP;
```

---

> Go back to the [index](.index.md#index).
