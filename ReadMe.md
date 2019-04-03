# Simple RESTful Service using quarkus.io


maven build create uberjar
using  **quarkus-maven-plugin** with option:

         <configuration>
            <uberJar>true</uberJar>
        </configuration>

## Deploy on OpenShift (tested with v3.11)

Create project:

        oc new-project nmquarkus
        
Application data is written to  mysql database deployed in OpenShift in the same
namespace. First deploy mysql db  with script:

        ./ose-deploy-mysql.sh       
        
        
Second  deploy app with a scripts

        ./ose-create-app.sh
                


        

