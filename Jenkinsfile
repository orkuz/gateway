pipeline {
    agent any
    
    stages {
        stage('Prepare for build') {
            steps {
                sh 'chmod +x mvnw'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh './mvnw test -DskipTests'
            }
        }
        stage('Build spring app') {
            steps {
                echo 'Building application with maven...'
                sh './mvnw package -DskipTests'
            }
        }
        stage('Docker image') {
            steps {
                echo 'Builidng image...'
                sh 'docker build --tag=gateway:latest .'
            }
        }
    }
}