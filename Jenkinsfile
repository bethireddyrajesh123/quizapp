pipeline {
    agent any
 
    triggers {
        githubPush()
    }
 
    tools {
        jdk 'JDK-17'          // Jenkins tool name s
        maven 'Maven-3.9.6'   // Jenkins tool name
    }
 
    stages {
 
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
 
        stage('Build Quiz Backend') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
 
    }
 
    post {
        success {
            echo "Quiz Backend CI pipeline SUCCESS"
        }
        failure {
            echo "Quiz Backend CI pipeline FAILED"
        }
    }
}
