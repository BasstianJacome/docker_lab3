pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('vjacomeg')
    }

    tools {
        maven 'MAVEN3'
    }

    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/BasstianJacome/docker_lab3.git']])
                sh 'mvn clean install'
            }
        }

        stage('Build docker image') {
            steps {
                script {
                    sh 'docker build -t vjacomeg/docker-app .'
                }
            }
        }

        stage('Docker Login and Push image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'vjacomeg', passwordVariable: 'DOCKERHUB_CREDENTIALS_PSW', usernameVariable: 'DOCKERHUB_CREDENTIALS_USR')]) {
                        sh 'docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW && docker push vjacomeg/devops_lab3:tagname'
                    }
                }
            }
        }
    }
}
