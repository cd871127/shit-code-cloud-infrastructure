#!/usr/bin/dumb-init /bin/bash
set -e

if [ ! ${CONSUL_CONFIG_DIR} ]; then
  CONSUL_CONFIG_DIR_PARAM=/consul/config
else
  CONSUL_CONFIG_DIR_PARAM=${CONSUL_CONFIG_DIR}
fi

if [ ! ${PROFILE} ]; then
  PROFILE=stg
fi

if [ "$(ls -A ${CONSUL_CONFIG_DIR_PARAM})" = "" ]; then
  echo 'consul配置目录为空, dev模式启动'
  nohup consul agent -dev -bind=0.0.0.0 -client=0.0.0.0 >/consul/data/1 2>&1 &
else
  echo "consul配置目录: ${CONSUL_CONFIG_DIR_PARAM}"
  nohup consul agent -config-dir=${CONSUL_CONFIG_DIR_PARAM} >/dev/null 2>&1 &
fi

APP_CLASSPATH=.:/app:/app/app.jar
if [ ! ${JAVA_OPTS} ]; then
  java -Xmx256m -Xms256m -Xmn96m -Xbootclasspath/a:./ -jar app.jar --spring.profiles.active=${PROFILE}
else
  java ${JAVA_OPTS} -Xbootclasspath/a:./ -jar app.jar --spring.profiles.active=${PROFILE}
fi


#//特定的jar到classpath
#java -Xbootclasspath/a:/usrhome/thirdlib1.jar:/usrhome/thirdlib2.jar -jar yourJarExe.jar
#//添加目录到classpath
#java -Xbootclasspath/a:/usrhome/thirdlib1/:/usrhome/thirdlib1/ -jar yourJarExe.jar
#//添加当前目录（可执行的jar所在的目录）到classpath
#java -Xbootclasspath/a:./ -jar yourJarExe.jar