FROM java:7
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac $(find . -name "*.java")
CMD ["java", "queriesonfile.QueriesOnFile", "queriesonfile/files/cidades.csv"]

