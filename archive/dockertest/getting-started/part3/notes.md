`docker swarm init`

Swarm initialized: current node (wbrdz1y6bq7llhagbi7nvyxza) is now a manager.

To add a worker to this swarm, run the following command:

    docker swarm join --token SWMTKN-1-58dp8ad43pfuuqotbe9b10cye3osqm06lvxx16a6lhful27jcp-dixmo2tvateucbo0qnrtqaa9f 192.168.1.103:2377

To add a manager to this swarm, run 'docker swarm join-token manager' and follow the instructions.


`docker stack deploy -c docker-compose.yml getstartedlab` getstartedlab is the name of the app. Updating the YAML file and running this command again would update running services in place.

`docker service ls` would show web prefixed with the name of the app.

A single container running in a service is called a task. Tasks are given unique IDs that numerically increment, up to the number of replicas you defined in docker-compose.yml. List the tasks for your service: `docker service ps getstartedlab_web`

`docker stack rm getstartedlab` take down the app

`docker swarm leave --force` take down the swarm
