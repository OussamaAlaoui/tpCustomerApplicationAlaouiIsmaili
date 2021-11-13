@echo off
call mvn clean package
call docker build -t ma.alaouiIsmaili/tpCustomerApplicationAlaouiIsmaili .
call docker rm -f tpCustomerApplicationAlaouiIsmaili
call docker run -d -p 9080:9080 -p 9443:9443 --name tpCustomerApplicationAlaouiIsmaili ma.alaouiIsmaili/tpCustomerApplicationAlaouiIsmaili