#!/bin/sh
mvn clean package && docker build -t ma.alaouiIsmaili/tpCustomerApplicationAlaouiIsmaili .
docker rm -f tpCustomerApplicationAlaouiIsmaili || true && docker run -d -p 9080:9080 -p 9443:9443 --name tpCustomerApplicationAlaouiIsmaili ma.alaouiIsmaili/tpCustomerApplicationAlaouiIsmaili