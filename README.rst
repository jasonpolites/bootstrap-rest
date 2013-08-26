ShareThis Bootstrap REST API
----------------------------

This is a simple REST API that provides a baseline bootstrap project for creating RESTful services in Java


Installing EC2/Tomcat
=====================

Create a new EC2 instance with the default Amazon Linux, then::


Install Tomcat & Maven
~~~~~~~~~~~~~~~~~~~~~~

From the command line::

    sudo yum update
    sudo yum install tomcat7 tomcat7-admin-webapps
    sudo yum install maven
    sudo chkconfig tomcat7 on

Install the app
~~~~~~~~~~~~~~~

<INSTALL PATH> is used as a placeholder for where ever you choose to install:

    mkdir <INSTALL PATH>
    cd <INSTALL PATH>
    git clone https://github.com/socialize/bootstrap-rest.git
    cd bootstrap-rest
    mvn package

This will produce a WAR file in::

    build/bootstrap-rest/lib

Setup Tomcat
~~~~~~~~~~~~

Edit the tomcat-users config::

    sudo vim /etc/tomcat7/tomcat-users.xml

Then copy the contents of::

    <INSTALL PATH>/bootstrap-rest/deploy/etc/tomcat-users.xml