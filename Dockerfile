
FROM tomcat
WORKDIR /usr/local/tomcat/webapps
ADD /var/lib/jenkins/workspace/Complete_CI_CD/target/addressbook.war /usr/local/tomcat/webapps
EXPOSE 8080
CMD /usr/local/tomcat/bin/catalina.sh run
