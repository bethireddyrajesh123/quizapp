pipeline {
    agent any
 
    triggers {
        githubPush()
    }
 
    tools {
        jdk 'JDK-17'
        maven 'Maven-3.9.6'
    }
 
    stages {
 
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
 
        stage('Build Quiz Backend') {
            steps {
                dir('quizapp') {   // 👈 VERY IMPORTANT
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
 
        stage('Run (Verification)') {
            steps {
                dir('quizapp') {
                    sh '''
                    java -jar target/*.jar &
                    sleep 15
                    '''
                }
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
