pipeline {
    agent any
    
    stages {

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