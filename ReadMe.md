# Simple RESTful Service using quarkus.io


maven build create uberjar
using  **quarkus-maven-plugin** with option:

         <configuration>
            <uberJar>true</uberJar>
        </configuration>

Deploy on openshift 3.11:

        oc new-project nmquarkus
        
then run scripts

        ./ose-create-app.sh
                

Application write data to local mysql database deployed in OpenShift in the same
namespace with script:

        ./ose-deploy-mysql.sh
        

