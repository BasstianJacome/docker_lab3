pipeline{
    agent any
        environment {
        DOCKERHUB_CREDENTIALS = credentials('docker-hub-login')
    }
    tools{
        maven 'Maven'
    }
    stages{
        stage('Build Maven') {
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/BasstianJacome/devOpsLab3.git']])
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