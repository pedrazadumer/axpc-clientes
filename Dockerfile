FROM pedrazadumer/axpc-tomcat-base:latest
COPY target/*.war /usr/local/tomcat/webapps/