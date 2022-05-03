#!/bin/bash
CATALINA_HOME='tools/tomcat/apache-tomcat-10.0.20'
TOMCAT_EXECUTABLE=$CATALINA_HOME'/bin/catalina.sh'
MAVEN_EXECUTABLE='tools/maven/apache-maven-3.8.5/bin/mvn'
WAR='target/cinema-1.0-SNAPSHOT.war'

cd scripts
bash ./get_tomcat.sh
bash ./get_maven.sh
bash ./start_db.sh
cd ..

$MAVEN_EXECUTABLE clean package
cp $WAR $CATALINA_HOME/webapps/cinema.war
$TOMCAT_EXECUTABLE run

