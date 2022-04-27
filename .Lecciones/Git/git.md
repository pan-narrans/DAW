# Git

```cmd
@author: Alejandro Pérez
```

- [Git](#git)
  - [Introduction](#introduction)
  - [Basic Commands](#basic-commands)
    - [Init](#init)
    - [Add](#add)
    - [Commit](#commit)
    - [Reset](#reset)
  - [Advanced stuff](#advanced-stuff)
    - [Amend](#amend)
    - [Rebase](#rebase)

## Introduction

- Limbo
- Staging Area
- Repository

## Basic Commands

### Init

Crea un nuevo repositorio.

### Add

Añade archivos a la staging area.

### Commit

Pasa los archivos de la staging area al repositorio.

### Reset

Nos devuelve a un commit anterior.

## Advanced stuff

### Amend

Permite modificar el último commit que hemos realizado en la rama:

- añadir archivos o modificaciones que se nos habían olvidado
- modificar el mensaje

```bash
git commit --amend -m "an updated commit message"
```

```bash
git commit --amend --no-edit  #Sin mensaje nuevo
```

No es recomendable hacer amend de un commit público ya que realmente no modifica el commit antiguo si no que **crea uno nuevo y los sustituye**. Esto puede crear problemas de merging en commits públicos.

### Rebase