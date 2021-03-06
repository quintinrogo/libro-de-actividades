
```
Curso       : 202021, 201920, 201819, 201817
Area        : Sistemas operativos, instalar aplicaciones
Descripción : Diversas formas de instalar aplicaciones en los SSOO
Requisitos  : Windows 10 y OpenSUSE
Tiempo      :
```

---
# Instalar aplicaciones y actualizar el sistema (Windows + OpenSUSE)

En esta actividad vamos a practicar diversas formas de realizar la instalación de aplicaciones en varios sistemas operativos, así como la forma de mantener nuestros sistemas actualizados.

---
# 1. Windows 7 usando el GUI

* Partimos de una [MV con Windows](../../global/configuracion/windows.md).

## 1.1 Agregar característica

El SO viene con software que se puede instalar si se necesita. Estas reciben el nombre de características del sistema.

* Capturar imagen del resultado final.
* Vamos a las `Herramientas de Windows -> Panel de control -> Programas y características -> Activar o desactivar características de Windows`.
* Instalar `características -> Juegos/Buscaminas`.

## 1.2 Instalar aplicación

Capturar imágenes de los pasos realizados.
* Descargar un programa GnuWin32 de la página oficial [http://gnuwin32.sourceforge.net/packages.html](http://gnuwin32.sourceforge.net/packages.html). Por ejemplo: tree, gcal, stat, file.
Hay que elegir la descargar del paquete completo sin las fuentes.
* Instalar el programa.
* `cd c:\Program Files (x86)\GnuWin32\bin`. Debe estar el programa instalado con la extensión `.exe`.
* Comprobar su funcionamiento.

## 1.3 Instalar un programa MSI

Los ficheros de instalación MSI, son programas de instalación que no nos hacen preguntas durante el proceso porque ya viene configurado con opciones por defecto.

* Abre un navegador web y pon URL siguiente `https://download.gnome.org/binaries/`.
* Descargar un MSI. Por ejemplo: `https://download.gnome.org/binaries/win64/gedit/gedit-VERSION.msi`. Cambiar VERSION por el valor adecuado.
* Instalar el programa MSI. La instalación de un MSI no hace ninguna pregunta durante el proceso.

# 2. Windows usando los comandos

Capturar imágenes de los pasos realizados.

## 2.1 Instalar desde la terminal Windows al estilo de GNU/Linux

* Descargar a instalar Chocolatey desde http://chocolatey.org/.
    * Ir a la web de Chocolatey -> Get Started -> Chocolate Install -> Individual. Seguir los pasos para instalar la herramienta.
* Elegir una aplicación disponible de la lista http://chocolatey.org/packages (Por ejemplo VLC).
* Abrir una consola como administrador.
* Ejecutar comando para instalar el programa. Por ejemplo, para instalar VLC pondremos `choco install vlc`.

## 2.2 Gestor de paquetes

* Vamos a usar la aplicación [Ninite](https://ninite.com/) para crearnos un paquete de instalación que contenga los siguiente programas:
    * Firefox
    * VLC
    * 7z
    * Steam

# 3. Windows - Actualización del sistema

Punto de restauración de seguridad:
* Hacer un snapshot de la MV por seguridad.
* Usar un usuario con privilegios de administrador.

Vamos a instalar un paquete de actualizaciones para Windows7.
De esta forma las actualizaciones tardarán menos tiempo.
* Reiniciamos el servicio Windows Update
    * `Equipos -> Botón derecho -> Administrar -> Servicios y Aplicaciones -> Servicios`
    * Buscar Windows Update.
    * Botón derecho -> Reiniciar
* [SOLO PARA Windows7] Descargar e instalar el paquete [KB3102810x64](https://www.microsoft.com/es-ES/download/details.aspx?id=49540)
* Reiniciar la máquina.

Actualizar algunos paquetes:
* Ir a `Panel de control -> Windows Update`. Debe de estar desactivado.
* Consultar las actualizaciones pendientes.
* Elegir 3 y aplicar actualización.

---

# 4. GNU/Linux usando el GUI

* Partimos de una [MV con OpenSUSE](../../global/configuracion/opensuse.md).

## 4.1 Instalar paquetes

Las distribuciones GNU/Linux como OpenSUSE, usan un gestor de paquetes para instalar/desinstalar software. Esto funciona igual que un AppStore.

> * Enlaces de interés:
>     * [Gestión de software con Yast](https://es.opensuse.org/SDB:Gesti%C3%B3n_de_software_con_YaST)

* Iniciar el gestor de paquetes ( `Inicio -> Yast -> Inst. Software`).
* Instalar por ejemplo algunos de los siguientes programas: `geany`, `gkrellm` y `gtk-recordmydesktop`.
* Comprobar que funcionan los programas que hemos instalado.

## 4.2 Desinstalar paquetes

* Desinstalar la aplicación con el gestor de paquetes.
* Comprobarlo.

---

# 5. GNU/Linux usando los comandos

Capturar imágenes de los pasos realizados.

> Enlace de interés:
> * [Zypper](https://es.opensuse.org/Zypper)

## 5.1 Instalar software

* Entramos en la consola como `root`.
* Instalar algún programa con el comando `zypper ...` (`man zypper` para consultar ayuda).
* `zypper search nombre-programa`, comprobamos que el programa está instalado.
* Ejecutar el programa y ver funciona.
* Buscar el programa en el sistema de ficheros: `whereis nombre-programa`

## 5.2 Desinstalar software

* Desinstalar el programa con `zypper ...`.
* `zypper se nombre-programa`, comprobar que el programa no está instalado.
* Ejecutar el programa y ver que funciona.
* Buscar el programa en el sistema de ficheros: `whereis nombre-programa`, y no encontrarlo.

## 5.3 Instalar programa nativo de Windows en GNU/Linux

* Instalar el emulador Windows (`wine`).
* Elegir un de programa Windows. Por ejemplo: Jhonny Simulator.
* Ejecutarlo usando `wine`.

## 5.4 Instalar programa desde rpm

> * `.rpm`, extensión de los ficheros de instalación para los sistemas operativos OpenSUSE y Red Hat.
> * `.deb`, extensión de los ficheros de instalación para los sistemas operativos Debian y Ubuntu.

* Comprobar que el programa `atom` no está disponible en los respositorios.
* Buscamos en la web de [atom.io](https://atom.io) el instalador para nuestro sistema.
* Descargamos el fichero `.rpm`.
* `rpm -i atom-VERSION.rpm`, para instalar el programa mediante el fichero rpm.
* Si la instalación de atom requiere alguna dependencia, ésta hay que instalarla manualmente. Por ejemplo:
    * `zypper search lsb*`, para buscar todos los paquetes lsb algo.
    * `zypper install lsb`, para instalar el paquete lsb.

> NOTA: El paquete libgconf2 se llama gconf2 en OpenSUSE

* Para comprobar que está el paquete instalado:
    * `rpm -q atom`
    * `atom`
* Comprobamos que funciona bien el editor `atom`.

## 5.5 Instalación desde el código fuente

GitHub es una plataforma donde los desarrolladores ponen sus proyectos de forma
pública. Vamos a realizar la instalación de un programa alojado en este repositorio,
desde el código fuente.

* Consultar la lista [Games on GitHub](https://github.com/leereilly/games)
* Dentro de la sección `Native`, elegir un programa  de la lista. Ejemplos:
    * Dyna Dungeons
    * Dungeon Monkey Eternal
    * Space Shooter
    * Super Mario Bros Level 1
* Consultar las instrucciones de instalación.
* Descargar el proyecto.
* Instalar el juego.

---

## 6. GNU/Linux actualización del sistema

* Hacer un snapshot de la MV.
* Entramos en la consola como `root`.
* `zypper refresh`, para actualizar el catálogo de productos software disponible.
* `zypper update`, para actualizar todas las aplicaciones del sistema.

---

# ANEXO

El ANEXO sólo contiene información extra. No hay que realizar ninguna tarea con el contenido de esta sección.

## A.1 Instalación desde las fuentes

Realizar las siguientes tareas:
* Elegir un programa/software/aplicación para instalar desde las fuentes. Ejemplos:
    * [ASEprite](https://github.com/aseprite/aseprite)
    * http://www.juegoslibres.net/linux/ghouls-and-ghost-version-libre.html
    * http://www.valarsoft.com/
    * http://goonies.jorito.net/ (SO recomendado Debian7)
    * http://www.gameover.es/juegos-gratis/
    * [Jhonny_Simulator sources](http://sourceforge.net/projects/johnnysimulator/files/?source=navbar)
    * Si elijen otro programa deben consultarlo con el profesor. Por ejemplo Geany.
    El [código fuente de Geany](https://github.com/geany/geany) está alojado en GitHub.
    * [Instalar node.js en Ubuntu](http://lobotuerto.com/blog/2013/02/19/como-instalar-node-js-en-ubuntu/)
    * [Instalar el editor Atom desde las fuentes alojadas en GitHub](https://github.com/atom/atom/blob/master/docs/build-instructions/linux.md)
* Descargar el código fuente desde internet.
* Realizar la instalación según se indique en el documento README, INSTALL o SETUP.
