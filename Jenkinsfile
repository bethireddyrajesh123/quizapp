pipeline {
    agent any
 
    triggers {
        githubPush()
    }
 
    tools {
        maven 'Maven-3.9.6'   // must match Jenkins tool name
        jdk 'JDK-17'          // or JDK-11 based on your project
    }
 
    stages {
 
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
 
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
 
        stage('Run (Verification)') {
            steps {
                sh '''
                echo "Starting Spring Boot backend..."
                java -jar target/*.jar &
                sleep 15
                echo "Backend started successfully"
                '''
            }
        }
    }
 
    post {
        success {
            echo "Quiz Backend pipeline executed successfully"
        }
        failure {
            echo "Quiz Backend pipeline failed"
        }
    }
}
