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
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/BasstianJacome/docker_lab3.git']])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image') {
            steps{
                script{
                    sh 'docker build -t vjacomeg/docker-app .'
                }
            }
        }
        stage('Docker Login') {
            steps{
                script{
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'


                }
            }
        }
        stage('Docker Push image') {
            steps {
                sh 'docker push vjacomeg/devops_lab3:tagname'
           }
        }
    }
}