pipeline{
    agent any
        environment {
        DOCKERHUB_CREDENTIALS = credentials('docker_jenkins')
    }
    tools{
        maven 'MAVEN3'
    }
    stages{
        stage('Build Maven') {
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/BasstianJacome/docker_lab3.git']])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image') {
            steps{
                script{
                    bat 'docker build -t vjacomeg/docker-app .'
                }
            }
        }
        stage('Docker Login') {
            steps{
                script{
                    withCredentials([usernamePassword(credentialsId: 'DOCKERHUB_CREDENTIALS2', passwordVariable: 'password', usernameVariable: 'name')]) {
                               bat "docker login -u vjacomeg -p ${password} && docker push vjacomeg/devops_lab3:tagname"
                            }

                }
            }
        }
        stage('Docker Push image') {
            steps {
                script{
                        withCredentials([usernamePassword(credentialsId: 'DOCKERHUB_CREDENTIALS2', passwordVariable: 'password', usernameVariable: 'name')]) {
                                               bat "docker login -u vjacomeg -p ${password} && docker push vjacomeg/devops_lab3:tagname"
                                            }

                                }
           }
        }


    }
}