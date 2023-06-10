pipeline {
    agent any
    def app
    
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
                app = docker.build("orkuztech/gateway")
            }
        }
        
        stage('Push image to registry') {
            docker.withRegistry('https://registry.hub.docker.com', 'orkuz-dockerhub') {
                app.push("${env.BUILD_NUMBER}")
                app.push("latest")
            }
        }
    }
}