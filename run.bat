set "JAVA_HOME=C:\Work\Java\jdk8u252-b09"
set "MAVEN_HOME=C:\Work\Java\apache-maven-3.6.3"
set "PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%
set "MAVEN_OPTS=-DskipTests=true"
mvn  clean package spring-boot:run -P nexus-3-internacional,Naivessl-Profile