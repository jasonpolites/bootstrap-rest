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

Download and build the app from this repo::

    cd ~/
    git clone https://github.com/socialize/bootstrap-rest.git
    cd bootstrap-rest
    mvn package

This will produce a WAR file in::

    ~/bootstrap-rest/target

Setup Tomcat
~~~~~~~~~~~~

Edit the tomcat-users config::

    sudo vim /etc/tomcat7/tomcat-users.xml

Then copy the contents of::

    ~/bootstrap-rest/deploy/etc/tomcat-users.xml

Then copy the WAR file::

    mkdir ~/opt
    mkdir ~/opt/bootstrap-rest
    cp ~/bootstrap-rest/target/bootstrap-rest-1.0-SNAPSHOT.war ~/opt/bootstrap-rest

Create the symlink to the home folder (tomcat deploy can't follow ~/)::

    sudo ln -s ~/opt/bootstrap-rest/ /opt

Create a group for the tomcat user::

    sudo groupadd bootstrap-rest

Add the current user and the tomcat user to the same group::

    sudo usermod -a -G bootstrap-rest tomcat
    sudo usermod -a -G bootstrap-rest ec2-user

Start the server::

    sudo service tomcat7 start
