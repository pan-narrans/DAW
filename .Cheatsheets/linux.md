
    Comandos de Linux 

- [Commandos Básicos](#commandos-básicos)
  - [Movernos - `cd`](#movernos---cd)
  - [Listar Archivos - `ls`](#listar-archivos---ls)
  - [Trabajar con Directorios](#trabajar-con-directorios)
- [Editar Archivos](#editar-archivos)
- [Usar el manual](#usar-el-manual)
- [otros](#otros)
  - [tratar el contenido de los archivos](#tratar-el-contenido-de-los-archivos)
    - [grep](#grep)
    - [sed](#sed)
  - [mover y copiar](#mover-y-copiar)
  - [permisos](#permisos)


# Commandos Básicos
## Movernos - `cd`

| Comando     | Resultado                                            |
| ----------- | ---------------------------------------------------- |
| `cd `       | nos lleva a nuestra "home"                           |
| `cd /`      | nos lleva al "root"                                  |
| `cd ..`     | nos sube al directorio inmediatamente superior       |
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

| Comando            | Resultado             |
| ------------------ | --------------------- |
| `mkdir [dir_name]` | crea un directorio    |
| `rmdir [dir_name]` | elimina un directorio |
| `rm -d [dir_name]` | elimina un directorio |

# Editar Archivos

# Usar el manual

# otros
## tratar el contenido de los archivos
### grep
### sed
## mover y copiar
## permisos
##