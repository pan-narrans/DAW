# Procedures

- [Procedures](#procedures)
  - [Parameters](#parameters)
  - [Calling a procedure](#calling-a-procedure)
  - [Creating a procedure](#creating-a-procedure)

While a function can call another function and a procedure can call a function, a procedure **cannot call** another procedure.

## Parameters

- **IN** :
  - Se pasa por valor.
- **OUT** :
  - Se pasa por copia, pero se asume que no lo inicializamos.
- **INOUT** :
  - Se pasa por copia (como el OUT), pero se asume que lo inicializamos.

## Calling a procedure

## Creating a procedure

```sql
CREATE PROCEDURE <procedureName>([parameter1[,...]])
BEGIN
<routine_body>
END <DELIMITER>
```

---

> Go back to the [index](.index.md#index).
