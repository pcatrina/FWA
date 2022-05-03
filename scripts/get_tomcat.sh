#!/bin/bash
TOMCAT_LINK='https://dlcdn.apache.org/tomcat/tomcat-10/v10.0.20/bin/apache-tomcat-10.0.20.zip'
TOMCAT_ZIP='apache-tomcat-10.0.20.zip'
TOMCAT_UNPACKED='apache-tomcat-10.0.20'
TOMCAT_FOLDER='../tools/tomcat'
if [ ! -d $TOMCAT_FOLDER ] || [ ! -d $TOMCAT_FOLDER/$TOMCAT_UNPACKED ]; then
	[ ! -d $TOMCAT_FOLDER ] && mkdir $TOMCAT_FOLDER
	[ ! -f ./$TOMCAT_ZIP ] && curl -O --insecure $TOMCAT_LINK
	[ -f ./$TOMCAT_ZIP ] && unzip ./$TOMCAT_ZIP -d $TOMCAT_FOLDER
	[ -f ./$TOMCAT_ZIP ] && rm $TOMCAT_ZIP
	[ -d .$TOMCAT_FOLDER/$TOMCAT_UNPACKED ] && chmod +x $TOMCAT_FOLDER/$TOMCAT_UNPACKED/bin/catalina.sh
fi


