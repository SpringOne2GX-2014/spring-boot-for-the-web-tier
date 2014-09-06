FROM ubuntu:14.04

RUN apt-get update && apt-get install -y apache2 libapache2-mod-proxy-html && apt-get clean && rm -rf /var/lib/apt/lists/*
RUN a2enmod proxy_http
RUN a2enmod ssl
RUN a2enmod headers
RUN rm -v /etc/apache2/sites-available/000-default.conf
RUN mkdir -p /var/run/apache2 && mkdir -p /var/lock/apache2 && chown www-data /var/lock/apache2

ADD 000-default.conf /etc/apache2/sites-available/
ADD apache.crt /etc/apache2/ssl/
ADD apache.key /etc/apache2/ssl/


ENV APACHE_RUN_USER www-data
ENV APACHE_RUN_GROUP www-data
ENV APACHE_LOG_DIR /var/log/apache2
ENV APACHE_PID_FILE /var/run/apache2.pid
ENV APACHE_RUN_DIR /var/run/apache2
ENV APACHE_LOCK_DIR /var/lock/apache2

EXPOSE 80
EXPOSE 443

ENTRYPOINT ["/usr/sbin/apache2"]
CMD ["-D", "FOREGROUND"]
