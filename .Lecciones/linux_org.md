
    https://linuxhandbook.com/ 💘

- [Movernos](#movernos)
  - [`pwd` - (print working directory)](#pwd---print-working-directory)
  - [`cd` - (change directory)](#cd---change-directory)
- [Visualizar](#visualizar)
  - [`ls` - (list)](#ls---list)
  - [`cat` - (catenate)](#cat---catenate)
  - [`tail`](#tail)
  - [`head`](#head)
  - [`nl` - (number lines)](#nl---number-lines)
  - [`wc` - (word count)](#wc---word-count)
- [Crear cosas](#crear-cosas)
  - [`touch`](#touch)
  - [`mkdir` - (make directory)](#mkdir---make-directory)
  - [`mv` - (move)](#mv---move)
  - [`cp` - (copy)](#cp---copy)
  - [`rm` - (remove)](#rm---remove)
  - [`rmdir` - (remove directory)](#rmdir---remove-directory)
- [Modificar Archivos](#modificar-archivos)
  - [`nano`](#nano)
  - [`sort`](#sort)
  - [`grep` - (global, regular expression and print)](#grep---global-regular-expression-and-print)
  - [cut](#cut)
  - [sed](#sed)
  - [`>` & `>>`](#--)
- [Enlaces](#enlaces)
  - [`ln` - (link)](#ln---link)
  - [`ln -s` - (soft link)](#ln--s---soft-link)
- [`chmod` - (change access mode)](#chmod---change-access-mode)
  - [Forma simbólica:](#forma-simbólica)
  - [Forma numérica:](#forma-numérica)
- [Compresión](#compresión)
  - [`tar`](#tar)
  - [`zip`](#zip)
  - [`rar`](#rar)
- [Fecha](#fecha)
  - [date](#date)
  - [cal](#cal)
- [Wildcards o comodines](#wildcards-o-comodines)
- [sudo apt install](#sudo-apt-install)
- [Shell](#shell)
  - [Requisitos](#requisitos)
  - [Parámetros](#parámetros)
  - [Variables](#variables)
  - [Condicionales](#condicionales)
  - [Ejemplo](#ejemplo)

# Movernos
## `pwd` - (print working directory)
Nos indica la ruta absoluta al directorio actual:
```console
alex@alex-vm:~$ pwd
/home/alex/Desktop
```
## `cd` - (change directory)

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

**Ruta absoluta:** Desde el root hasta el archivo:
> \Users\grupo1\Documents\DAW-Alex\Cheatsheets\linux.md

**Ruta relativa:** Desde el directorio actual (DAW-Alex)
> Cheatsheets\linux.md

# Visualizar
## `ls` - (list)
Lista los contenidos de un directorio.

| Comandos | Resultado                                                |
| -------- | -------------------------------------------------------- |
| `ls `    | el nombre de los archivos                                |
| `ls -a`  | también los archivos ocultos                             |
| `ls -l`  | los archivos de forma detallada                          |
| `ls -r`  | los archivos en orden inverso                            |
| `ls -t`  | los archivos por orden de modificación (+nuevos primero) |
| `ls -i`  | el inodo del archivo (algo así como un id)               |

Ejemplo de `ls -l`

```bash
alex@alex-vm:~$ ls -l
-rw-rw---- 1 alex alex 32 feb 11 08:47 fichero.txt
```

| tipo de fichero | permisos  | propietario | grupo | tamaño | fecha y hora | nombre      |
| --------------: | --------- | ----------- | ----- | ------ | ------------ | ----------- |
|               - | rw-rw---- | alex        | alex  | 32     | feb 11 08:47 | fichero.txt |

| signo  | tipo de fichero   |
| :----: | ----------------- |
|  `-`   | fichero ordinario |
|  `d`   | directorio        |
| `b, c` | archivo especial  |
|  `l`   | enlace            |

## `cat` - (catenate)
Su principal función es concatenar archivos *(de ahí el nombre* 🐵 *)*. Pero también se usa de forma general para mostrar por el terminal los contenidos de un archivo.

```bash
alex@alex-vm:~$ cat file.txt
linea 1
linea 2
linea 3
```
## `tail`
Muestra el final *(la cola)* de un archivo.
| Modificador | Resultado                                        |
| :---------: | ------------------------------------------------ |
|    `-n`     | Muestra las n últimas líneas del archivo.        |
|    `+n`     | Muestra todas las líneas a partir de la enésima. |

## `head`
Muestra el principio *(la cabeza)* de un archivo.

Con el modificador `+n` podemos escoger el nº de líneas que queremos mostrar.

## `nl` - (number lines)
Muestra el contenido del fichero con la líneas numeradas.

## `wc` - (word count)
Lista el nº de lineas, palabras, caracteres y el nombre del archivo.

```bash
alex@alex-vm:~$ cat fichero1.txt
 16  32 135 fichero.txt
```

# Crear cosas
## `touch`
Actualiza la fecha de modificación de un archivo sin necesidad de abrirlo.

> Si el archivo no existe, lo crea.

## `mkdir` - (make directory)
Crear directorios.

## `mv` - (move)

Lo usamos para mover archivos o cambiarles el nombre.

```bash
# mueve el archivo
mv file.txt Folder/file.txt
```
```bash
# le cambia el nombre
mv old_name.txt new_name.txt
```
```bash
# mueve el archivo y le cambia el nombre
mv file.txt Folder/file1.txt
```

## `cp` - (copy)
Parecido al `mv` pero copiando, no moviendo.

## `rm` - (remove)
Se usa para eliminar archivos, pero podemos aprovecharlo también para eliminar directorios con estos modificadores:

| Comando            | Resultado                            |
| ------------------ | ------------------------------------ |
| `rm -d [dir_name]` | elimina un directorio                |
| `rm -r [dir_name]` | elimina un directorio y su contenido |

## `rmdir` - (remove directory)
Elimina directorios.

# Modificar Archivos
## `nano`
Abre el archivo escogido en el editor de texto Nano.

## `sort`
Ordena el contenido por líneas de un archivo, en orden alfabético y carácter a carácter.

## `grep` - (global, regular expression and print)
```bash
# mueve el archivo y le cambia el nombre
grep 'regex' file_name
```

## cut 
## sed

## `>` & `>>`
| Comando                     | Resultado                                                          |
| --------------------------- | ------------------------------------------------------------------ |
| `something > [file_name] `  | Sobrescribe el contenido del archivo con lo que haya al otro lado. |
| `something >> [file_name] ` | Añade al final del archivo lo que haya al otro lado.               |

# Enlaces

## `ln` - (link)
Enlace duro. Son a efectos prácticos el mismo archivo pero en dos sitios distintos *(comparten inodo)*. Si borramos el archivo original, al enlace no le pasa nada. 
```bash
ln file linked_file
```

## `ln -s` - (soft link)
Enlace simbólico. No es más que un puntero a la dirección del archivo original. Si el original desaparece este sigue apuntando, a un lugar vacío a lo que ocupe su lugar en un futuro.
```bash
ln -s file linked_file
```

# `chmod` - (change access mode)

Permite cambiar los permisos de un archivo o directorio.

## Forma simbólica:
<table>
<tr>
  <th>Afectado</th>
  <th>Asignación</th>
  <th>Permisos</th>
</tr>
<tr><td>

|  Mod | Significado |
| ---: | ----------- |
|  `u` | usuario     |
|  `g` | grupo       |
|  `o` | otros       |

</td><td>

|  Mod | Significado |
| ---: | ----------- |
|  `+` | añade       |
|  `-` | quita       |
|  `=` | asigna      |

</td><td>

|  Mod | Significado |
| ---: | ----------- |
|  `r` | lectura     |
|  `w` | escritura   |
|  `x` | ejecución   |

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

| Valor | Significado |
| :---: | ----------- |
| `100` | lectura     |
| `010` | escritura   |
| `001` | ejecución   |

</td><td>

Permite asignar los permisos de forma absoluta.

Sumamos en binario los valores de la tabla según los permisos que queramos conceder.

Hay 3 números, uno por cada grupo de usuarios (u g o).

</td></tr>
</table>

```console
alex@alex-vm:~$ ls -l
---------- 1 alex alex 32 feb 11 08:47 fichero.txt
alex@alex-vm:~$ chmod 750 fichero.txt
alex@alex-vm:~$ ls -l
-rwxr-x--- 1 alex alex 32 feb 11 08:47 fichero.txt
```


# Compresión
## `tar`
```bash
# Comprime una serie de archivos
tar -cvf file_name file1 file2 ...
```
```bash
# Descomprime el archivo en un directorio
tar -xvf file_name --directory ~/aquí
```

|  Mod  | Significado                                                     |
| :---: | --------------------------------------------------------------- |
|  `c`  | create - crear un archivo                                       |
|  `v`  | visualize - muestra lo que vamos comprimiendo / descomprimiendo |
|  `f`  | file_name - el siguiente argumento es el nombre del fichero     |
|  `x`  | descomprimir                                                    |
|  `t`  | listar el contenido del fichero                                 |

## `zip`
```bash
# Comprime una serie de archivos
zip file_name file1 file2 ...
```
```bash
# Descomprime el archivo en un directorio
unzip file_name -d directory
```
```bash
# Ver el contenido del archivo
unzip -v file_name 
```

## `rar`
```bash
# Comprime una serie de archivos
rar a file_name file1 file2 ...
```
```bash
# Descomprime el archivo en un directorio
rar x file_name directory/
```

# Fecha
## date
## cal

# Wildcards o comodines
|     Mod      | Significado                                       | Ejemplo                                                                                         |
| :----------: | ------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
|     `*`      | cualquier carácter o grupo de caracteres          | `ls *.txt` : todos los .txt                                                                     |
|     `?`      | un solo carácter                                  | `ls ?.txt` : todos los .txt cuyo nombre tenga un solo carácter.                                 |
|    `[..]`    | cualquier carácter de los incluidos dentro        | `ls [abc].txt` : a.txt, b.txt y c.txt                                                           |
|   `[!..]`    | cualquier carácter de los **no** incluidos dentro | `ls [!abc].txt` : todos los .txt cuyo nombre tenga un solo carácter y sea distinto de a, b y c. |
|   `{x..x}`   | todos los elementos entre los dos (incluidos)     | `ls {A..M}.txt` : igual que arriba pero con todos de la A a la M.                               |
| `{x1,x2,x3}` | todos los elementos de la lista                   | `mkdir {carpeta1,carpeta2,carpeta3}` : crea las 3 carpetas                                      |


# sudo apt install

# Shell

Podemos ejecutar los scripts con el comando `sh` o `bash`.

## Requisitos
- Permisos de ejecución (*es un archivo ejecutable* 😬).
- Cabecera: indica que el archivo de texto en cuestión es un shell script. 

  ```shell
  #! /bin/bash
  ```


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
| `$#` | nº de parámetros recibidos (int)                      |

## Variables

```shell
var = "hola"  # asignar valor
echo $var     # acceder a su contenido
echo {$var}   # acceder a su contenido
```

Variables predefinidas:
| icon | ¿Qué representa?                                |
| ---- | ----------------------------------------------- |
| `$0` | nombre del script                               |
| `$$` | PID del proceso asignado al script en ejecución |
| `$?` | resultado del último proceso ejecutado          |

## Condicionales
```bash
if test $# le 0 
then
  # let here be code
else
  # let here be code
fi
```

```bash
for i in ${foo[@]}
do
	# let here be code
done
```

```bash
while [ condition ]
do
	# let here be code
done
```




## Ejemplo
El `;` únicamente hace falta si queremos poner más de un comando en una línea.

```bash
#! /bin/bash

# función de ayuda
ayuda() {
cat << DESC_AYUDA
SYNOPSIS
  $0 NOMBRE_1 [NOMBRE_2] ... [NOMBRE_N]
DESCRIPCIÓN
  Muestra "Hola NOMBRE_1, NOMBRE_2, ... NOMBRE_N!" por pantalla.
CÓDIGOS DE RETORNO
  1 Si el número de parámetros es menor que 1
DESC_AYUDA
}

# si número de parámetros <= 0
if test $# le 0 ; then
  echo "Hay que introducir al menos un parámetro."
  ayuda # llama a la función de ayuda
  exit 1
fi

MENSAJE="Hola"
PRIMERO=1

# mientras haya parámetros
while [ n "$1" ]; do
  if [ $PRIMERO eq 1 ]; then
    MENSAJE="$MENSAJE $1"
    PRIMERO=0
  else
    MENSAJE="$MENSAJE, $1"
  fi

  # pasamos al siguiente parámetro
  shift
done

# mostramos la salida por pantalla
echo $MENSAJE"!"
exit 0
```
