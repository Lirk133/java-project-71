[![Actions Status](https://github.com/Lirk133/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Lirk133/java-project-71/actions)
[![SonarQube](https://github.com/Lirk133/java-project-71/actions/workflows/build.yml/badge.svg)](https://github.com/Lirk133/java-project-71/actions/workflows/build.yml)
[![TestBuildApp](https://github.com/Lirk133/java-project-71/actions/workflows/build-run.yml/badge.svg)](https://github.com/Lirk133/java-project-71/actions/workflows/build-run.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Lirk133_java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Lirk133_java-project-71)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Lirk133_java-project-71&metric=bugs)](https://sonarcloud.io/summary/new_code?id=Lirk133_java-project-71)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Lirk133_java-project-71&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Lirk133_java-project-71)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Lirk133_java-project-71&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=Lirk133_java-project-71)

## Вычислитель отличий

Эта программа для вычисления отличий в ваших файлах JSON и YAML.

Для работы запустите файл с указанием путей к вашим JSON/YAML файлам.

***Пример:***
```
/build/install/app/bin/app file1.json file2.json
```

Вычислитель обладает возможностью изменять формат вывода (--format) (stylish - используется по умолчанию, plain, json).

**Пример вывода при дефолтном значении (stylish):**
```
    chars1: [a, b, c]
  - chars2: [d, e, f]
  + chars2: false
  - checked: false
  + checked: true
  - default: null
  + default: [value1, value2]
  - id: 45
  + id: null
  - key1: value1
  + key2: value2
    numbers1: [1, 2, 3, 4]
  - numbers2: [2, 3, 4, 5]
  + numbers2: [22, 33, 44, 55]
  - numbers3: [3, 4, 5]
  + numbers4: [4, 5, 6]
  + obj1: {nestedKey=value, isNested=true}
  - setting1: Some value
  + setting1: Another value
  - setting2: 200
  + setting2: 300
  - setting3: true
  + setting3: none
```


**Пример вывода при значении plain:**
```
Property 'chars2' was updated. From [complex value] to false<p>
Property 'checked' was updated. From false to true
Property 'default' was updated. From null to [complex value]
Property 'id' was updated. From 45 to null
Property 'key1' was removed
Property 'key2' was added with value: 'value2'
Property 'numbers3' was removed
Property 'numbers4' was added with value: [complex value]
Property 'obj1' was added with value: [complex value]
Property 'setting1' was updated. From 'Some value' to 'Another value'
Property 'setting2' was updated. From 200 to 300
Property 'setting3' was updated. From true to 'none'
```

**Пример вывода при значении json:**
```
{"setting2":300,"key1":"value1","setting3":"none","key2":"value2","chars2":false,"setting1":"Another value","chars1":["a","b","c"],"numbers4":[4,5,6],"numbers3":[3,4,5],"numbers2":[22,33,44,55],"numbers1":[1,2,3,4],"obj1":{"nestedKey":"value","isNested":true},"default":["value1","value2"],"checked":true,"id":null}
```



### Asciinema
https://asciinema.org/a/5yAvBxCJXkAV1x4WbqJ7OapDN
