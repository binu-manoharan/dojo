FROM ubuntu

RUN apt-get update && \
  apt-get install -y tree && \
  apt-get install -y curl && \
  curl -sSL https://get.haskellstack.org/ | sh && \
  cd /home && \
  mkdir smash-the-code

CMD ["/bin/bash"]
