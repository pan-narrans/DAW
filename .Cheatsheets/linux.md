
    Comandos de Linux:

- [Commandos Básicos](#commandos-básicos)
  - [Movernos - `cd`](#movernos---cd)
  - [Listar Archivos - `ls`](#listar-archivos---ls)
  - [Trabajar con Directorios](#trabajar-con-directorios)
  - [Permisos - `chmod`](#permisos---chmod)
    - [Forma simbólica:](#forma-simbólica)
    - [Forma numérica:](#forma-numérica)
  - [Metacaracteres - Wildcards](#metacaracteres---wildcards)
- [Editar Archivos](#editar-archivos)
- [otros](#otros)
  - [tratar el contenido de los archivos](#tratar-el-contenido-de-los-archivos)
    - [grep](#grep)
    - [sed](#sed)
  - [mover y copiar](#mover-y-copiar)
  - [permisos](#permisos)


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

## Listar Archivos - `ls`

| Comando | Resultado                               |
| ------- | --------------------------------------- |
| `ls `   | muestra por nombre los archivos         |
| `ls -a` | muestra también los archivos ocultos    |
| `ls -l` | muestra los archivos de forma detallada |
| `ls -r` | muestra los archivos en orden inverso   |

## Trabajar con Directorios

| Comando            | Resultado                            |
| ------------------ | ------------------------------------ |
| `mkdir [dir_name]` | crea un directorio                   |
| `rmdir [dir_name]` | elimina un directorio                |
| `rm -d [dir_name]` | elimina un directorio                |
| `rm -r [dir_name]` | elimina un directorio y su contenido |

## Permisos - `chmod`
### Forma simbólica:

<table>
<tr>
  <th>A quien afecta</th>
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

### Forma numérica:

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

## Metacaracteres - Wildcards


# Editar Archivos


# otros
## tratar el contenido de los archivos
### grep
### sed
## mover y copiar
## permisos
##