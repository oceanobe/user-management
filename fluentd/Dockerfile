FROM fluent/fluentd:v1.18.0-1.0

# Use root account for package installation
USER root

# Install build dependencies and Ruby
RUN apk add --no-cache --virtual .build-deps \
    build-base bash sudo \
    openssl-dev libffi-dev libxml2-dev libxslt-dev ruby-dev && \
    gem install fluent-plugin-elasticsearch && \
    gem sources --clear-all && \
    # Clean up build dependencies and cache to reduce image size
    apk del --purge .build-deps && \
    rm -rf /tmp/* /var/tmp/* /usr/lib/ruby/gems/*/cache/*.gem

# Copy Fluentd configuration
COPY conf/fluent.conf /fluentd/etc/

# Switch back to Fluentd user
USER fluent
