#!/bin/bash
clear 
echo "**********************  BUILDING MODULE  ***********************"
mvn install

echo "*******************  COLLECTING DEPENDENCIES  *******************"
mvn dependency:copy-dependencies
export CLASPATH=""
for file in 'target/dependency';do export CLASSPATH=$CLASSPATH:target/dependency/$file; done
export CLASSPATH=$CLASSPATH:target/classes

echo "*********************  EXECUTING PROGRAM  **********************"
java -cp $CLASSPATH com.Grateds.Reversi.App

