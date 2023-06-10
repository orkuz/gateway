pipeline {
    agent any
    environment {
		DOCKERHUB_CREDENTIALS=credentials('orkuz-dockerhub')
	}
    
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
        stage('Build and push docker image') {
            steps {
                echo 'Logging in to DockerHub...'
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                echo 'Builidng image...'
                sh 'docker build orkuztech/gateway:latest'
                echo 'Pushing image to registry...'
                sh 'docker push orkuztech/gateway:latest'
                sh 'docker push orkuztech/gateway:${env.BUILD_NUMBER}'
            }
        }
    }
}