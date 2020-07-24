






# Docker

mvn clean compile jib:build


docker-compose -f src/main/docker/docker-compose.yml up -d


但是通过本地无法访问

使用docker部署到docker环境后，通过pointer观察，运行正常

其中运行的时候，使用的是9082端口，但是在docker-compose映射的却是 5432，也就是说，我访问localhost:5432，相当于访问docker的5432，而在docker容器内，5432是没有应用映射到该端口的，所以，无法访问
