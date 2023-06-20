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
                echo 'Builidng image and pushing to registry...'
                script {
                    echo "Building image orkuztech/gateway:${currentBuild.number}"
                    def appImage = docker.build("orkuztech/gateway:${currentBuild.number}")
                    appImage.push()
                }
            }
        }
    }
}
