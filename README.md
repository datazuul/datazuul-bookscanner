# Eazy BookScanner

OpenSource Book Scanner application for digitizing books with two cameras.
Usage for two digital cameras like described at <http://diybookscanner.org/>.

![Screenshot GUI Eazy BookScanner](./screenshot-20201221.jpg)

## Features

* Supported output image formats: JPG, TIF, PNG
* Setup Mode: take unsaved test pictures for adjusting/exchanging left/right camera, image rotation and zoom before starting production shots with save
* Synchronous two camera shots

## Requirements

* Java 1.8 or above

## Installation

* Download ZIP <./dist/eazy-bookscanner-app-0.1.0-SNAPSHOT.zip>
* Unzip and change into folder.

## Usage

* Connect cameras to USB-ports
* Turn on cameras
* Run `bin/eazybookscanner`
* Take test shots in "Setup Mode" until adjustings and desired setup are feasible
* Uncheck "Setup Mode"
* Start scanning

## Supported cameras

* CHDK Canon Digital cameras

```
WARNING: Using this software is at your own risk!

See also https://chdk.fandom.com/wiki/FAQ:
"CHDK comes with no warranty for any use; you use it at your own risk."
```

Successfully tested on:

|Camera Vendor (Id)|Product (Id)|Operating System|Java Version|
|-----|-----|-----|-----|
|Canon (0x04a9)|A2200 (0x322a)|Linux (Debian GNU/Linux 10)|OpenJDK 11.0.8|
|Canon (0x04a9)|A2200 (0x322a)|Linux (Ubuntu 20.04.1 LTS) |OpenJDK 11.0.4|

Happy book scanning!

## Feedback

Please start discussions here: <https://github.com/datazuul/eazy-bookscanner/discussions>