FROM fluent/fluentd:v1.6-1

# Use root account for package installation
USER root

# Install build dependencies and Ruby
RUN apk add --no-cache --virtual .build-deps \
    build-base bash sudo \
    openssl-dev libffi-dev libxml2-dev libxslt-dev && \
    # Install Ruby 2.7.0 manually
    wget -q https://cache.ruby-lang.org/pub/ruby/2.7/ruby-2.7.0.tar.gz && \
    tar -xzf ruby-2.7.0.tar.gz && \
    cd ruby-2.7.0 && \
    ./configure && make -j$(nproc) && make install && \
    cd .. && rm -rf ruby-2.7.0 ruby-2.7.0.tar.gz && \
    # Install necessary gems (one at a time)
    gem install faraday-net_http -v 3.0.2  && \
    gem install fluent-plugin-elasticsearch -v 4.0.0 && \
    gem sources --clear-all && \
    # Clean up build dependencies and cache to reduce image size
    apk del --purge .build-deps && \
    rm -rf /tmp/* /var/tmp/* /usr/lib/ruby/gems/*/cache/*.gem

# Copy Fluentd configuration
COPY conf/fluent.conf /fluentd/etc/

# Switch back to Fluentd user
USER fluent
