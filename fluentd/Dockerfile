FROM fluent/fluentd:v1.6-1

# Use root account to use apk
USER root

# install elasticsearch plugin
RUN apk add --no-cache --update --virtual .build-deps \
        sudo build-base ruby-dev bash \
        libffi-dev libxml2-dev libxslt-dev

#RUN apk add --no-cache openssl-dev
#
#RUN apk update && \
#    apk add --no-cache perl

#RUN apk update && \
#    apk add --no-cache \
#    ruby \
#    ruby-dev \
#    build-base \
#    libressl-dev \
#    zlib-dev

#RUN wget https://www.cpan.org/src/5.0/perl-5.34.0.tar.gz
#RUN tar -xzf perl-5.34.0.tar.gz
#WORKDIR ./perl-5.34.0
#RUN ./Configure -des -Dprefix=/usr/local
#RUN make
#RUN make install
#RUN cd ..
#RUN rm -rf perl-5.34.0 perl-5.34.0.tar.gz

#RUN wget https://github.com/openssl/openssl/releases/download/openssl-3.4.1/openssl-3.4.1.tar.gz
#RUN tar -xzvf openssl-3.4.1.tar.gz
#WORKDIR openssl-3.4.1
#RUN ./openssl-3.4.1/config --prefix=/usr/local/openssl --openssldir=/usr/local/openssl && make && make install

RUN wget https://cache.ruby-lang.org/pub/ruby/3.0/ruby-3.0.0.tar.gz
RUN tar -xzvf ruby-3.0.0.tar.gz
WORKDIR ./ruby-3.0.0
RUN ./configure
RUN make
RUN make install
RUN cd ..
RUN rm -rf ruby-3.0.0 ruby-3.0.0.tar.gz

RUN sudo gem install fluent-plugin-elasticsearch
RUN sudo gem sources --clear-all
RUN apk del .build-deps
RUN rm -rf /tmp/* /var/tmp/* /usr/lib/ruby/gems/*/cache/*.gem

# Clean up to reduce image size
#RUN apk del build-base ruby-dev libffi-dev libxml2-dev libxslt-dev \
#    && rm -rf /tmp/* /var/tmp/* /usr/lib/ruby/gems/*/cache/*.gem

COPY conf/fluent.conf /fluentd/etc/
#COPY entrypoint.sh /bin/

USER fluent

#https://www.cpan.org/src/5.0/latest_5.10