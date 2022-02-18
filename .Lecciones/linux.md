
    Comandos de Linux:

- [Commandos Básicos](#commandos-básicos)
  - [Movernos - `cd`](#movernos---cd)
  - [Listar Contenidos - `ls`](#listar-contenidos---ls)
    - [Ejemplo de `ls -l`:](#ejemplo-de-ls--l)
    - [Tipos de fichero:](#tipos-de-fichero)
  - [Directorios](#directorios)
  - [Archivos](#archivos)
  - [Metacaracteres - Wildcards](#metacaracteres---wildcards)
- [Editar Archivos](#editar-archivos)
- [Permisos - `chmod`](#permisos---chmod)
  - [Forma simbólica:](#forma-simbólica)
  - [Forma numérica:](#forma-numérica)
- [otros](#otros)
  - [tratar el contenido de los archivos](#tratar-el-contenido-de-los-archivos)
    - [grep](#grep)
    - [sed](#sed)
  - [mover y copiar](#mover-y-copiar)
  - [permisos](#permisos)
- [Shell](#shell)
  - [Requisitos](#requisitos)
  - [Parámetros](#parámetros)
  - [Variables](#variables)
    - [Predefinidas](#predefinidas)


# Commandos Básicos
## Movernos - `cd`

| Comando     | Resultado                                                  |
| ----------- | ---------------------------------------------------------- |
| `cd `       | nos lleva a nuestra "home"                                 |
| `cd /`      | nos lleva al "root"                                        |
| `cd ..`     | nos sube al directorio inmediatamente superior             |
| `cd [path]` | nos lleva a la dirección introducida (absoluta o relativa) |

```console
alex@alex-vm:~$ cd /media
alex@alex-vm:/media$
```

> **Ruta absoluta:** Desde el root hasta el archivo:
> 
> \Users\grupo1\Documents\DAW-Alex\Cheatsheets\linux.md

> **Ruta relativa:** Desde el directorio actual (DAW-Alex)
> 
> Cheatsheets\linux.md

## Listar Contenidos - `ls`

| Comando | Resultado                               |
| ------- | --------------------------------------- |
| `ls `   | muestra por nombre los archivos         |
| `ls -a` | muestra también los archivos ocultos    |
| `ls -l` | muestra los archivos de forma detallada |
| `ls -r` | muestra los archivos en orden inverso   |

### Ejemplo de `ls -l`:

```console
alex@alex-vm:~$ ls -l
-rw-rw---- 1 alex alex 32 feb 11 08:47 fichero.txt
```


| tipo de fichero | permisos  | propietario | grupo | tamaño | fecha y hora | nombre      |
| --------------- | --------- | ----------- | ----- | ------ | ------------ | ----------- |
| -               | rw-rw---- | alex        | alex  | 32     | feb 11 08:47 | fichero.txt |


### Tipos de fichero:

| signo  | tipo de fichero   |
| :----: | ----------------- |
|  `-`   | fichero ordinario |
|  `d`   | directorio        |
| `b, c` | archivo especial  |
|  `l`   | enlace            |

## Directorios

| Comando            | Resultado                            |
| ------------------ | ------------------------------------ |
| `mkdir [dir_name]` | crea un directorio                   |
| `rmdir [dir_name]` | elimina un directorio                |
| `rm -d [dir_name]` | elimina un directorio                |
| `rm -r [dir_name]` | elimina un directorio y su contenido |

## Archivos

| Comando             | Resultado                           |
| ------------------- | ----------------------------------- |
| `touch [file_name]` | crea un archivo                     |
| `rm [file_name]`    | elimina un archivo                  |
| `cat [file_name]`   | abre un archivo de texto            |
| `nano [file_name]`  | abre un editor de archivos de texto |


## Metacaracteres - Wildcards


|   Mod   | Significado                                       | Ejemplo                                                                   |
| :-----: | ------------------------------------------------- | ------------------------------------------------------------------------- |
|   `*`   | cualquier carácter o grupo de caracteres          | `ls *.txt` : encuentra todos los .txt                                     |
|   `?`   | un solo carácter                                  | `ls ?.txt` : encuentra todos los .txt cuyo nombre tenga un solo carácter. |
| `[..]`  | cualquier carácter de los incluídos dentro        | `ls [abc].txt` :                                                          |
| `[!..]` | cualquier carácter de los **no** incluídos dentro | `ls [!abc].txt` :                                                         |

# Editar Archivos

| Comando                     | Resultado                           |
| --------------------------- | ----------------------------------- |
| `[comando] > [file_name] `  |                                     |
| `[comando] >> [file_name] ` |                                     |
| `nano [file_name]`          | abre un editor de archivos de texto |


# Permisos - `chmod`

## Forma simbólica:

<table>
<tr>
  <th>Afectado</th>
  <th>Asignación</th>
  <th>Permisos</th>
</tr>
<tr><td>

|  Mod  | Significado |
| :---: | ----------- |
| "`u`" | usuario     |
| "`g`" | grupo       |
| "`o`" | otros       |

</td><td>

|  Mod  | Significado |
| :---: | ----------- |
| "`+`" | añade       |
| "`-`" | quita       |
| "`=`" | asigna      |

</td><td>

|  Mod  | Significado |
| :---: | ----------- |
| "`r`" | lectura     |
| "`w`" | escritura   |
| "`x`" | ejecución   |

</td></tr>
</table>

Le añadimos permisos de lectura y escritura al usuario y al grupo:

```console
alex@alex-vm:~$ ls -l
---------- 1 alex alex 32 feb 11 08:47 fichero.txt
alex@alex-vm:~$ chmod ug+rw fichero.txt
alex@alex-vm:~$ ls -l
-rw-rw---- 1 alex alex 32 feb 11 08:47 fichero.txt
```

## Forma numérica:

<table>
<tr><td>

|  Valor  | Significado |
| :-----: | ----------- |
| "`100`" | lectura     |
| "`010`" | escritura   |
| "`001`" | ejecución   |

</td><td>

Permite asignar los permisos de forma absoluta.

Sumamos en binario los valores de la tabla según los permisos que queramos conceder.

Hay 3 nº, uno por cada grupo de usuarios (u g o).

</td></tr>
</table>

```console
alex@alex-vm:~$ ls -l
---------- 1 alex alex 32 feb 11 08:47 fichero.txt
alex@alex-vm:~$ chmod 750 fichero.txt
alex@alex-vm:~$ ls -l
-rwxr-x--- 1 alex alex 32 feb 11 08:47 fichero.txt
```



# otros
## tratar el contenido de los archivos
### grep
### sed
## mover y copiar
## permisos
##

# Shell
Cabecera, indica que el archivo de texto en cuestión es un shell script. 
```shell
#! /bin/bash
```

## Requisitos
Tiene que tener permisos de ejecución (*ya que es un archivo ejecutable* 😬).

## Parámetros
Cadenas de texto escritas después del nombre del script.
```console
alex@alex-vm:~$ sh shell.sh param1 param2 ...
```
| icon | ¿Qué representa?                                      |
| ---- | ----------------------------------------------------- |
| `$n` | info de un parámetro siento n el nº del parámetro     |
| `$*` | todos los parámetros (bajo forma de una única string) |
| `$@` | todos los parámetros (bajo forma de una lista)        |
| `$#`  | nº de parámetros recibidos (int)                      |

## Variables

```shell
var = "hola"  # asignar valor
echo $var     # acceder a su contenido
echo {$var}   # acceder a su contenido
```

### Predefinidas
| icon | ¿Qué representa?                                |
| ---- | ----------------------------------------------- |
| `$0` | nombre del script                               |
| `$$` | PID del proceso asignado al script en ejecución |
| `$?` | resultado del último proceso ejecutado          |
