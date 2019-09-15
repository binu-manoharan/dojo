## Prerequisites

### Install docker-machine

```
base=https://github.com/docker/machine/releases/download/v0.14.0 &&
  curl -L $base/docker-machine-$(uname -s)-$(uname -m) >/tmp/docker-machine &&
  sudo install /tmp/docker-machine /usr/local/bin/docker-machine
```

### compose file from part 3

Also, test to see if `docker run -p 4000:80 binumanoharan/playground:part2` still works.
