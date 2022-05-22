#!/bin/bash
TOMCAT_LINK='https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.zip'
TOMCAT_ZIP='apache-maven-3.8.5-bin.zip'
TOMCAT_UNPACKED='apache-maven-3.8.5'
TOMCAT_FOLDER='../tools/maven'
if [ ! -d $TOMCAT_FOLDER ] || [ ! -d $TOMCAT_FOLDER/$TOMCAT_UNPACKED ]; then
	[ ! -d $TOMCAT_FOLDER ] && mkdir $TOMCAT_FOLDER
	[ ! -f ./$TOMCAT_ZIP ] && curl -O --insecure $TOMCAT_LINK
	[ -f ./$TOMCAT_ZIP ] && unzip ./$TOMCAT_ZIP -d $TOMCAT_FOLDER
	[ -f ./$TOMCAT_ZIP ] && rm $TOMCAT_ZIP
fi


