options {
        skipDefaultCheckout(true)
    }
    
pipeline {
    agent any
    
    stages {
        
        stage('Clone repository') {
            steps {
                echo 'Cloning repository...'
                git 'https://github.com/orkuz/gateway.git'
            }
        }

        stage('Build spring app') {
            steps {
                echo 'Building application with maven...'
                sh './mvnw clean install -DskipTests'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'

            }
        }
    }
}