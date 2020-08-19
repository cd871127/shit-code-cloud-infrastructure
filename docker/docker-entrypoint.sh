#!/usr/bin/dumb-init /bin/bash
set -e

if [ ! ${CONSUL_CONFIG_DIR} ]; then
  CONSUL_CONFIG_DIR_PARAM=/consul/config
else
  CONSUL_CONFIG_DIR_PARAM=${CONSUL_CONFIG_DIR}
fi

if [ ! ${PROFILE} ]; then
  PROFILE=cluster
fi

if [ "$(ls -A ${CONSUL_CONFIG_DIR_PARAM})" = "" ]; then
  echo 'consul配置目录为空, dev模式启动'
  nohup consul agent -dev -bind=0.0.0.0 -client=0.0.0.0 >/consul/data/1 2>&1 &
else
  echo "consul配置目录: ${CONSUL_CONFIG_DIR_PARAM}"
  nohup consul agent -config-dir=${CONSUL_CONFIG_DIR_PARAM} >/dev/null 2>&1 &
fi

java -Xmx512m -Xms512m -Xmn192m -jar app.jar --spring.profiles.active=${PROFILE} -xmx
