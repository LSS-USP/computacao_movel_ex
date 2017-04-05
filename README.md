# Geral

## Como criar um projeto android do zero usando CLI:

```
 android create project --target 1 --path $(pwd)/<nomeDaPasta>
                        --activity SeuAppName --package com.usp.android.SeuAppName
```

## Listar dispositivos com adb:

```
adb devices -l
```

## Gerar o APK

```
ant clean
ant debug # Usado durante o desenvolvimento
ant release # App final
```

## Instalar o apk no dispositivo:

```
adb install -r bin/SeuAppName-debug.apk
```

## Debug do app usando o Logcat

```
adb logcat ActiveDoSeuApp:I OutroLocalComLog:D *:S
```

## Trazer dados do aparelho

```
adb pull /storage/extSdCard
```

## Empurrar dados para o aparelho

```
adb push pastaAlvo/ /storage/extSdCard
```

# Dica de emulador

> Genymotion é um emulador para android realmente muito bom e leve. Recomendamos
o uso dele.
