# queriesOnFile

Requirements: docker.io

### How to run the program:

`$ git clone git@github.com:RenanDeMedeirosPorto/queriesOnFile.git`

`$ cd queriesOnFile/src/`

`$ docker build -t queriesonfileapp .`

`$ docker run -it --rm --name queriesonfile queriesonfileapp`

### Examples of commands:

* `Count *` For the total count of imported records
* `Count distinct [property]` For the total of separate property values (column) sent
* `Filter [property] [value]` For all rows in which the property sent has the value sent
* `Exit` To close program "
