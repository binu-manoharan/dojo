## Notes

- Stack is a build system for Haskell projects
- This project sets up this build system using docker (can be tested on ../smash-the-code)
- Use docker with with volume option to the haskell project directory `docker run -d -i -v /home/binu/playground/dojo/smash-the-code:/home/smash-the-code stack`
- Get into container ```docker exec -it `docker ps -q` /bin/bash```
- `cd /home/smash-the-code` then run stack like normal

## TODO

- mount the volume and do a stack build as part of the image?
