ShareThis Bootstrap REST API
----------------------------

This is a simple REST API that provides a baseline bootstrap project for creating RESTful services in Java


Installing EC2/Tomcat
=====================

Create a new EC2 instance with the default Amazon Linux, then::


Install Tomcat
~~~~~~~~~~~~~~

From the command line::

    sudo yum update
    sudo yum install tomcat7 tomcat7-admin-webapps
    sudo chkconfig tomcat7 on

Setup Tomcat
~~~~~~~~~~~~

Edit the tomcat-users config::

    sudo vim /etc/tomcat7/tomcat-users.xml

Then copy the contents of::

    deploy/tomcat-users.xml